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

		// 文字列を1文字毎に処理
		for (char temChar : temStr.toCharArray())
		{
			try {
				// 対象文字列の点数の合計を求める
				// ＡＢ なら、 1+2 となる
				// 文字の点数は、Enumの設定値から求められる
				sumValue += EnabledWord.valueOf(String.valueOf(temChar)).getValue();
			} catch (Exception ex)
			{
				throw new KadaiException(ErrorCode.OTHER);
			}
		}
		// 点数の合計を求める  ＡＢ が3番目にある場合、
		// (1+2) × 3 となる
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
