package jp.ktsystem.kadai201408.t_kikuchi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import jp.ktsystem.kadai201408.Exception.ErrorCode;
import jp.ktsystem.kadai201408.Exception.KadaiException;

/**
 * ファイルのUtillクラス
 * @author TakahrioKikuchi
 *
 */
public class FileUtill {

	/**
	 * BOM文字
	 */
	public static final String UTF8_BOM = "\uFEFF";

	/**
	 * BOM取り除く
	 * @param s 対象文字列
	 * @return
	 */
	private static String removeUTF8BOM(String s) {
		if (s.startsWith(UTF8_BOM)) {
			s = s.substring(1);
		}
		return s;
	}

	/**
	 * ファイル読み込み
	 * @param aFileName  ファイルの絶対パス
	 * @return 読み込んだテキスト
	 * @throws KadaiException
	 */
	public static List<String> readFile(String aFileName) throws KadaiException
	{
		// nullチェック
		if (null == aFileName) {
			throw new KadaiException(ErrorCode.FILE_IO);
		}

		BufferedReader br = null;
		List<String> list = null;
		// ファイル存在確認
		if (!new File(aFileName).exists()) {
			throw new KadaiException(ErrorCode.FILE_IO);
		}

		try {

			boolean firstLine = true;

			br = new BufferedReader(new InputStreamReader(new FileInputStream(aFileName), "UTF-8"));
			String str;
			list = new ArrayList<String>();
			while ((str = br.readLine()) != null) {
				if (firstLine) {
					str = removeUTF8BOM(str);
					firstLine = false;
				}
				list.add(str);
			}
		} catch (IOException e) {
			throw new KadaiException(ErrorCode.FILE_IO);
		} finally
		{
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e2) {
			}
		}
		return list;
	}

	/**
	 * ファイル書き込み
	 * @param aFilePath : 出力ファイルの絶対パス
	 * @param aList : 書き込ませる文字列
	 * @param aFileName : ファイル名
	 * @throws KadaiException
	 */
	public static void writeFile(String aFilePath, List<String> aList) throws KadaiException
	{
		// ファイルパスチェック
		if (null == aFilePath || "".equals(aFilePath)) {
			throw new KadaiException(ErrorCode.FILE_IO);
		}

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(aFilePath), false), "UTF-8"));
			for (String str : aList) {
				bw.write(str);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			throw new KadaiException(ErrorCode.FILE_IO);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	/**
	 * ファイル書き込み
	 * @param aFilePath : 出力ファイルのディレクトリパス
	 * @param anInputStr : 書き込ませる文字列
	 * @param aFileName : ファイル名
	 * @aFileName : ファイル名 (省略する場合は、NULLを指定)
	 * @throws KadaiException
	 */
	public static void writeFile(String aFilePath, String anInputStr, String aFileName) throws KadaiException {
		// ファイルパスチェック
		if (null == aFilePath || "".equals(aFilePath)) {
			throw new KadaiException(ErrorCode.FILE_IO);
		}

		// ファイルパス＋ ファイル名 からファイルの絶対パスを作成
		StringBuilder sb = new StringBuilder();
		sb.append(aFilePath);

		if (null != aFileName) {
			sb.append("\\").append(aFileName);
		}

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(new File(sb.toString()), true));

			bw.write(anInputStr);
			bw.newLine();

			bw.close();
		} catch (IOException e) {
			throw new KadaiException(ErrorCode.FILE_IO);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception ex) {
				}
			}
		}
	}

}
