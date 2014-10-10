/**
 *
 */
package jp.ktsystem.kadai201408.t_kikuchi;

import java.util.ArrayList;
import java.util.List;

import jp.ktsystem.kadai201408.exception.ErrorCode;
import jp.ktsystem.kadai201408.exception.KadaiException;
import jp.ktsystem.kadai201408.models.OutputModel;

/**
 * 課題Utilクラス
 * @author TakahrioKikuchi
 *
 */
public class KadaiUtill {

	/**
	 * ファイルからデータ読み込み＆整形
	 * @param anInputPath 読み込みファイルパス
	 * @return ファイルのデータの1データづつに区切った文字列配列
	 * @throws KadaiException
	 */
	public static String[] createDataList(String anInputPath) throws KadaiException
	{
		// ファイル読み込み
		List<String> aFileStrList = FileUtill.readFile(anInputPath);

		//ファイルのみ存在する場合
		if(null == aFileStrList || 0 == aFileStrList.size()){
			aFileStrList.add("");
		}

		// ファイル内文字列チェック
		String aFirstDataStr = aFileStrList.get(0);
		if(!ErrorCheck.isEnableWord(aFirstDataStr)){
			throw new KadaiException(ErrorCode.INVALID_STRING);
		}
		// ファイル文字列をカンマでスプリット(から文字も取得)
		return aFirstDataStr.split(",",-1);

	}

	/** モデルリストからファイル出力用の文字列リストに変換
	 *
	 * @param aModelList 出力対象モデルリスト
	 * @return 文字列リスト ⇒ [データの出現位置1]:[データの内容]:[データの点数]
	 * @throws KadaiException
	 */
	public static List<String> convertOutputStrList (List<OutputModel> aModelList) throws KadaiException
	{
		List<String> outputFileStrList = new ArrayList<String>();

		// 出力文字列の区切り文字
		String separatorStr = ":";

		for (OutputModel aModel : aModelList)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(aModel.getTargetIndex()).append(separatorStr);
			sb.append(aModel.getTargetStr()).append(separatorStr);
			sb.append(aModel.getSumValue());
			outputFileStrList.add(sb.toString());
		}

		return outputFileStrList;

	}

}
