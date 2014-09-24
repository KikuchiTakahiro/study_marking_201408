/**
 *
 */
package jp.ktsystem.kadai201408.t_kikuchi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * エラーチェッククラス
 * @author TakahrioKikuchi
 *
 */
public class ErrorCheck {

	/**
	 * 半角文字列のみ許容パターン
	 */
	private static final Pattern ENABLED_DAY_PATTERN = Pattern.compile("[a-zA-Z,]*");

	/**
	 * 引数が半角英字かチェック
	 * @param anStr 対象文字列
	 * @return	半角英数の時のみtrue
	 */
	public static boolean isEnableWord(String anStr)
	{
		// 引数が 半角英数時かチェック
		Matcher enabledDayData = ENABLED_DAY_PATTERN.matcher(anStr);
		//半角英数字の時のみtrue
		return enabledDayData.matches();
	}
}
