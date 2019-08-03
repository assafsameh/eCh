package helper;

import org.testng.Assert;

import helper.EnumHelper.Result;

public class AssertionHelper {

	public static void makeTrue(Result result) {
		if (result.equals(Result.Passed)) {
			Assert.assertTrue(true);
		} else if (result.equals(Result.Failed)) {
			Assert.assertTrue(false);
		} else if (result.equals(Result.Warning)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(false);
		}
	}

	public static void makeTrue(Result result, String msg) {
		if (result.equals(Result.Passed)) {
			Assert.assertTrue(true, msg);
		} else if (result.equals(Result.Failed)) {
			Assert.assertTrue(false, msg);
		} else if (result.equals(Result.Warning)) {
			Assert.assertTrue(false, msg);
		} else {
			Assert.assertTrue(false, msg);
		}
	}

	public static void checkEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void checkEqual(String actual, String expected, String msg) {
		Assert.assertEquals(actual, expected, msg);
	}
}
