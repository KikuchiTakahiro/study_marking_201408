/**
 *
 */
package jp.ktsystem.kadai201408.Models;

import java.util.Comparator;

/**
 * 点数とインデックスにて昇順ソート用クラス
 * @author TakahrioKikuchi
 *
 */
public class OutputModelComparator implements Comparator<OutputModel> {

	@Override
	public int compare(OutputModel o1, OutputModel o2) {
		long outputSumValue1 = o1.getSumValue();
		long outputSumValue2 = o2.getSumValue();
		long outputIndex1 = o1.getTargetIndex();
		long outputIndex2 = o2.getTargetIndex();

		if (outputSumValue1 > outputSumValue2)
		{
			return -1;
		} else if ((outputSumValue1 == outputSumValue2) && (outputIndex1 < outputIndex2)) {
			return -1;
		}
		else if ((outputSumValue1 == outputSumValue2) && (outputIndex1 == outputIndex2))
		{
			return 0;
		} else if ((outputSumValue1 == outputSumValue2) && (outputIndex1 > outputIndex2)) {
			return 1;
		}
		else {
			return 1;
		}
	}

}
