package com.leetcode;

public class Decode_Ways_91 {

	public static void main(String[] args) {
		String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		long s1 = System.currentTimeMillis();
		System.out.println(new Solution_Decode_Ways_91().numDecodings_1(s));
		long s2 = System.currentTimeMillis();
		System.out.println(new Solution_Decode_Ways_91().numDecodings(s));
		long s3 = System.currentTimeMillis();
		System.out.println(s2-s1);
		System.out.println(s3-s2);
	}

}

class Solution_Decode_Ways_91 {
	// 按照爬楼梯的思想做
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0)
			return 0;

		if (s.charAt(0) == '0')
			return 0;
		if (len == 1)
			return 1;

		int[] numbers = new int[len + 1];
		numbers[0] = 1;
		numbers[1] = 1;

		int tmp;
		for (int i = 2; i <= len; i++) {
			// 检查当前字符是不是'0'
			tmp = s.charAt(i - 1) - '0';
			if (tmp != 0) {
				numbers[i] = numbers[i - 1];
			}
			// 检查当前字符和前一个字符组合在一起是否在1-26之间
			if (s.charAt(i - 2) != '0') {
				tmp = Integer.parseInt(s.substring(i - 2, i));
				if (tmp > 0 && tmp <= 26) {
					numbers[i] += numbers[i - 2];
				}
			}
		}
		return numbers[s.length()];

	}

	// 超时，是对的
	public int numDecodings_1(String s) {
		int len = s.length();
		if (len == 0)
			return 1;
		if (s.charAt(0) == '0')
			return 0;
		if (len == 1)
			return 1;

		char[] s_2 = s.substring(0, 2).toCharArray();

		boolean is_over = false;
		if ((s_2[0] - '0') >= 3 || ((s_2[0] - '0') == 2 && (s_2[1] - '0') >= 7)) {
			is_over = true;
		}

		if (is_over) {
			return numDecodings_1(s.substring(1));
		} else {
			return numDecodings_1(s.substring(1)) + numDecodings_1(s.substring(2));
		}
	}
}