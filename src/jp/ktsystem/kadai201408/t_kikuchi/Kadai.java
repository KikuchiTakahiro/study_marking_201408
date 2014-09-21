package jp.ktsystem.kadai201408.t_kikuchi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.ktsystem.kadai201408.Exception.ErrorCode;
import jp.ktsystem.kadai201408.Exception.KadaiException;
import jp.ktsystem.kadai201408.Models.OutputModel;
import jp.ktsystem.kadai201408.Models.OutputModelComparator;

/**2014年8月度課題クラス
 * @author TakahrioKikuchi
 *
 */
public class Kadai {

	/**
	 * 問１
	 * データの出現位置(最初のデータが1で、以下2,3...と増えていきます) を n とします。
	 * n とデータの点数の積の合計を求める関数
	 * @param anInputPath :フルパスで****.txtまで指定する
	 * @return	 ：データの点数の積の合計
	 */
	public static long calcScoreSum(String anInputPath) throws KadaiException {

		// ファイル読み込み ＆ ファイル文字列をカンマでスプリット
		String[] aFileDataArray = KadaiUtill.createDataList(anInputPath);
		// 返却用文字列
		long sumValue = 0;
		for (int i = 0; i < aFileDataArray.length; i++)
		{
			OutputModel aData = new OutputModel(aFileDataArray[i], i + 1);
			sumValue += aData.getSumValue();
		}
		return sumValue;
	}

	/**
	 * 問2
	 * 全データのデータの点数のうち、最大の点数を持つデータをファイルに出力する関数
	* @param anInputPath :フルパスで*****.txtまで指定する
	* @param anOutputPath : フルパスで*****.txtまで指定する
	*/
	public static void printMaxScore(String anInputPath, String anOutputPath) throws KadaiException {

		// 出力ファイルパスをチェック
		if (null == anOutputPath || "".equals(anOutputPath)) {
			throw new KadaiException(ErrorCode.FILE_IO);
		}

		// ファイル読み込み ＆ ファイル文字列をカンマでスプリット
		String[] aFileDataArray = KadaiUtill.createDataList(anInputPath);
		List<OutputModel> outputModelList = new ArrayList<OutputModel>();
		for (int i = 0; i < aFileDataArray.length; i++)
		{
			OutputModel aData = new OutputModel(aFileDataArray[i], i + 1);
			outputModelList.add(aData);
		}
		// 点数とインデックスで降順ソート
		Collections.sort(outputModelList, new OutputModelComparator());

		// ファイル出力用モデル作成
		List<OutputModel> outputModelListForFile = new ArrayList<OutputModel>();
		long maxValue = 0;
		for (OutputModel aModel : outputModelList)
		{
			if (maxValue <= aModel.getSumValue())
			{
				outputModelListForFile.add(aModel);
				maxValue = aModel.getSumValue();
			}
			else {
				break;
			}
		}
		// ファイル出力文字リスト作成
		List<String> fileOutputStrList = KadaiUtill.convertOutputStrList(outputModelListForFile);

		// ファイル出力
		FileUtill.writeFile(anOutputPath, fileOutputStrList);

	}

}
