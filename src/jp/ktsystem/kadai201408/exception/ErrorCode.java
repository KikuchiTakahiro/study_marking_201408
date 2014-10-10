/**
 *
 */
package jp.ktsystem.kadai201408.exception;

/**
 * エラーコード
 * @author TakahrioKikuchi
 *
 */
public enum ErrorCode {

/**
 * ファイルの入出力エラー
 */
FILE_IO,
/**
 * データ内部に半角英字以外の文字が存在した
 */
INVALID_STRING,
/**
 * その他
 */
OTHER
}
