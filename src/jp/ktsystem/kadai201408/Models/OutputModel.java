package jp.ktsystem.kadai201408.Models;

import jp.ktsystem.kadai201408.Exception.ErrorCode;
import jp.ktsystem.kadai201408.Exception.KadaiException;

/**
 * データ出力用モデルクラス
 * @author TakahrioKikuchi
 *
 */
public class OutputModel {

	/**
	 * 対象文字列
	 * 例) Aa
	 */
	private String targetStr;

	/**
	 * 対象文字列のインデックス
	 * 1 始まり
	 */
	private long targetIndex;

	/**
	 * 対象文字列の計算結果
	 */
	private long sumValue;

	/**
	 * コンストラクタ
	 * @param aTargetStr : 対象文字列
	 * @param anIndex 	 ：対象文字列のインデックス
	 */
	public OutputModel(String aTargetStr, long anIndex) throws KadaiException {
		targetStr = aTargetStr;
		targetIndex = anIndex;
		calcSumValue();
	}

	/**
	 * 文字列から計算
	 * @throws KadaiException
	 */
	private void calcSumValue() throws KadaiException {

		sumValue = 0;
		// 対象文字列がから文字の場合 点数は0
		if ("".equals(targetStr))
			return;
		// 対象文字列を大文字に変換
		String temStr = targetStr.toUpperCase();

		for (char temChar : temStr.toCharArray())
		{
			try {
				sumValue += (temChar - 'A' + 1);
			} catch (Exception ex)
			{
				throw new KadaiException(ErrorCode.OTHER);
			}
		}
		sumValue = sumValue * targetIndex;
	}

	public String getTargetStr() {
		return targetStr;
	}

	public void setTargetStr(String targetStr) {
		this.targetStr = targetStr;
	}

	public long getTargetIndex() {
		return targetIndex;
	}

	public void setTargetIndex(long targetIndex) {
		this.targetIndex = targetIndex;
	}

	public long getSumValue() {
		return sumValue;
	}

	public void setSumValue(long sumValue) {
		this.sumValue = sumValue;
	}

}
