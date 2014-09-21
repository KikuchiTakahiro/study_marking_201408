package jp.ktsystem.kadai201408.Exception;

/**
 * 課題エラークラス
 * @author TakahrioKikuchi
 *
 */
public class KadaiException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * エラーコード
	 */
	private ErrorCode errorCode;

	/**
	 * エラー
	 * @param errorCode  エラーコード
	 */
	public KadaiException(ErrorCode errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * @return エラーコード
	 */
	public ErrorCode getErrorCode() {
		return this.errorCode;
	}

}
