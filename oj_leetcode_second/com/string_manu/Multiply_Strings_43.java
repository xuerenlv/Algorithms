package com.string_manu;

public class Multiply_Strings_43 {

	public static void main(String[] args) {
		String num = "2345";

		// int与string相加，int自动转为string
		System.out.println(num.substring(0, num.length() - 1) + 5);

		// System.out.println(new Solution_Multiply_Strings_43().multi(num,
		// 20));
		// System.out.println(new Solution_Multiply_Strings_43().sum(num, ""));
		System.out.println(new Solution_Multiply_Strings_43().multiply(num, num));
	}

}

class Solution_Multiply_Strings_43 {
	public String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		if (len1 > len2)
			return multiply(num2, num1);
		if (len1 == 0)
			return "0";

		String sum = "";
		String jin = ""; // 使中间结果左移
		while (len1 != 0) {
			int i = (num1.charAt(len1 - 1) - '0');
			String mul = multi(num2, i);
			sum = sum(mul + jin, sum);
			jin = jin + "0";
			len1--;
		}

		return sum;
	}

	// 俩个 string 相加
	String sum(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		String sum = "";
		int jin = 0;
		int cur = 0;
		while (len1 != 0 && len2 != 0) {
			cur = (s1.charAt(len1 - 1) - '0') + (s2.charAt(len2 - 1) - '0') + jin;
			sum = cur % 10 + sum;
			jin = cur / 10;
			len1--;
			len2--;
		}

		while (len1 != 0) {
			cur = (s1.charAt(len1 - 1) - '0') + jin;
			sum = cur % 10 + sum;
			jin = cur / 10;
			len1--;
		}
		while (len2 != 0) {
			cur = (s2.charAt(len2 - 1) - '0') + jin;
			sum = cur % 10 + sum;
			jin = cur / 10;
			len2--;
		}

		if (jin != 0) {
			sum = jin + sum;
		}

		return sum;
	}

	// 一个数字与string相乘
	String multi(String num, int one) {
		if (one == 0) {
			return "0";
		}
		String re = "";

		int jinwei = 0;
		int cur = 0;
		int index = num.length();
		while (index > 0) {
			cur = (one * (num.charAt(index - 1) - '0') + jinwei);
			re = cur % 10 + re;
			jinwei = cur / 10;
			index--;
		}

		if (jinwei != 0) {
			re = jinwei + re;
		}
		return re;
	}
}