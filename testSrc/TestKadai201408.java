import jp.ktsystem.kadai201408.exception.ErrorCode;
import jp.ktsystem.kadai201408.exception.KadaiException;
import jp.ktsystem.kadai201408.t_kikuchi.Kadai;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * testクラス
 * @author TakahrioKikuchi
 *
 */
@RunWith(JUnit4.class)
public class TestKadai201408 {

	/**
	 * 入力ファイルパスがnull
	 */
	@Test
	public void test_G01T101() {
		assertFailForLevel1(null, ErrorCode.FILE_IO);

	}

	/**
	 * 入力ファイルが存在しないl
	 */
	@Test
	public void test_G01T102() {
		assertFailForLevel1("", ErrorCode.FILE_IO);

	}

	/**
	 * 読み込みデータの1行目に使用不可能文字が混ざっているl
	 * testフォルダ\\input\\
	 */
	@Test
	public void test_G01T104() {
		assertFailForLevel1("testフォルダ\\input\\1行目に不正文字あり.txt", ErrorCode.INVALID_STRING);

	}

	/**
	 * 読み込みファイルの読み取り権限がない
	 */
	@Test
	public void test_G01T105() {
		assertFailForLevel1("testフォルダ\\input\\hoge.txt", ErrorCode.FILE_IO);

	}

	/**
	 * 入力データが半角英字のみ1行
	 */
	@Test
	public void test_G01T106() {
		assertEqualsForLevel1("testフォルダ\\input\\半角のみ.txt", 103);

	}

	/**
	 * 入力データが半角英字のみ2行以上データ
	 *
	 */
	@Test
	public void test_G01T107() {

		assertEqualsForLevel1("testフォルダ\\input\\２行目データあり.txt", 145);
	}

	/**
	 * 入力データが半角全角混じり1行
	 */
	@Test
	public void test_G01T108() {

		assertEqualsForLevel1("testフォルダ\\input\\全角半角混じり.txt", 145);
	}

	/**
	 * 入力データが半角全角混じり2行
	 */
	@Test
	public void test_G01T109() {

		assertEqualsForLevel1("testフォルダ\\input\\２行目データあり.txt", 145);

	}

	/**
	 * 入力ファイルの中身が空
	 */
	@Test
	public void test_G01T110() {
		assertEqualsForLevel1("testフォルダ\\input\\空データ.txt", 0);

	}

	/**
	 * 二行目以降に使用不可能データあり
	 * 2行目に不正.txt
	 */
	@Test
	public void test_G01T111() {
		assertEqualsForLevel1("testフォルダ\\input\\2行目に不正.txt", 145);

	}

	//// レベル２

	/**
	 * 入力ファイルパスがnull
	 */
	@Test
	public void test_G02T101() {
		assertFailForLevel2(null, "", ErrorCode.FILE_IO);
	}

	/**
	 * 出力ファイルパスがnull
	 */
	@Test
	public void test_G02T102() {
		assertFailForLevel2("", null, ErrorCode.FILE_IO);
	}

	/**
	 * 入力ファイルパスが存在しないl
	 */
	@Test
	public void test_G02T103() {
		assertFailForLevel2("", "", ErrorCode.FILE_IO);
	}

	/**
	 * 出力ファイルパスが空文字
	 */
	@Test
	public void test_G02T104() {
		assertFailForLevel2("", "", ErrorCode.FILE_IO);
	}

	/**
	 * 1行目にエラー文字列
	 */
	@Test
	public void test_G02T105() {
		assertFailForLevel2("testフォルダ\\input\\1行目に不正文字あり.txt", "hoge", ErrorCode.INVALID_STRING);
	}

	/**
	 * 読み込みファイルに読み取り権限がない
	 */
	@Test
	public void test_G02T106() {
		assertFailForLevel2("", "", ErrorCode.FILE_IO);
	}

	/**
	 * 出力ファイルに書き込み権限がない
	 */
	@Test
	public void test_G02T107() {
		assertFailForLevel2("", "", ErrorCode.FILE_IO);
	}

	/**
	 * 入力データが半角英字のみの一行データ
	 */
	@Test
	public void test_G02T108() {
		assertEqualsForLevel2("testフォルダ\\input\\半角のみ.txt", "testフォルダ\\output\\108.txt");
	}

	/**
	 * 入力ファイルデータが半角英字のみの2行以上データ
	 */
	@Test
	public void test_G02T109() {
		assertEqualsForLevel2("testフォルダ\\input\\２行目データあり.txt", "testフォルダ\\output\\109.txt");
	}

	/**
	 * 入力ファイルが半角と全角英字のみの1行
	 */
	@Test
	public void test_G02T110() {
		assertEqualsForLevel2("testフォルダ\\input\\全角半角混じり.txt", "testフォルダ\\output\\110.txt");
	}

	/**
	 * 入力ファイルが半角と全角英字のみの2行以上データ
	 */
	@Test
	public void test_G02T111() {
		assertEqualsForLevel2("testフォルダ\\input\\２行目データあり.txt", "testフォルダ\\output\\111.txt");
	}

	/**
	 * 入力ファイルデータの中身が空
	 */
	@Test
	public void test_G02T112() {
		assertEqualsForLevel2("testフォルダ\\input\\空データ.txt", "testフォルダ\\output\\112.txt");
	}

	/**
	 * 2行目以降に使用不可能文字が混ざっている
	 */
	@Test
	public void test_G02T113() {
		assertEqualsForLevel2("testフォルダ\\input\\2行目に不正.txt", "testフォルダ\\output\\113.txt");
	}

	/**
	 * 出力ファイルが既に存在する(上書きする)
	 */
	@Test
	public void test_G02T114() {
		assertEqualsForLevel2("testフォルダ\\input\\全角のみ.txt", "testフォルダ\\output\\114.txt");
	}

	/**
	 * 複数出力
	 */
	@Test
	public void test_G02T115() {
		assertEqualsForLevel2("testフォルダ\\input\\同じ値.txt", "testフォルダ\\output\\115_複数.txt");
	}

	/**
	 * から文字混じり
	 */
	@Test
	public void test_G02T116() {
		assertEqualsForLevel2("testフォルダ\\input\\から文字混じりデータ.txt", "testフォルダ\\output\\116_から文字混じり.txt");
	}

	/**
	 * から文字ノミ
	 */
	@Test
	public void test_G02T117() {
		assertEqualsForLevel2("testフォルダ\\input\\から文字のみ.txt", "testフォルダ\\output\\117_から文字ノミ.txt");
	}

	/**
	 * レベル1の正常系テスト
	 *
	 * @param anInputFilePath
	 * @param anOutputFilePath
	 */
	private void assertEqualsForLevel1(String anInputFilePath, long exceptNum) {

		try {
			if (exceptNum != Kadai.calcScoreSum(anInputFilePath)) {
				throw new KadaiException(null);
			}
		} catch (KadaiException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * レベル1の異常系のテスト
	 * @param anInputPath
	 * @param anOutputPath
	 * @param expected
	 */
	private void assertFailForLevel1(String anInputPath, ErrorCode expected) {

		try {
			Kadai.calcScoreSum(anInputPath);
			Assert.fail();
		} catch (KadaiException e) {
			Assert.assertEquals(expected, e.getErrorCode());
		}
	}

	/**
	 * レベル2の正常系テスト
	 *
	 * @param anInputFilePath
	 * @param anOutputFilePath
	 */
	private void assertEqualsForLevel2(String anInputFilePath, String anOutputFilePath) {

		try {
			Kadai.printMaxScore(anInputFilePath, anOutputFilePath);
		} catch (KadaiException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * レベル2の異常系のテスト
	 * @param anInputPath
	 * @param anOutputPath
	 * @param expected
	 */
	private void assertFailForLevel2(String anInputPath, String anOutputPath, ErrorCode expected) {

		try {
			Kadai.printMaxScore(anInputPath, anOutputPath);
			Assert.fail();
		} catch (KadaiException e) {
			Assert.assertEquals(expected, e.getErrorCode());
		}
	}
}
