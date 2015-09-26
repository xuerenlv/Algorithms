package com.string_manu;

public class Longest_Palindromic_Substring_5 {

	public static void main(String[] args) {
		String s = "xhjxhjxhx";
		System.out.println(new Solution_Longest_Palindromic_Substring_5().longestPalindrome(s));
	}

}

// 子串中的最长回文字符串
class Solution_Longest_Palindromic_Substring_5 {
	// 很强大，看人家的
	public String longestPalindrome(String s) {
		int longest_len = 0;
		String longest = "";

		// 子串长为奇数
		for (int c = 0; c < s.length(); c++) {
			int i = 1;
			int len = 1;
			while (true) {
				int start = c - i;
				int end = c + i;
				if (start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end))
					break;
				len = end - start + 1;
				i += 1;
			}
			if (len > longest_len) {
				longest_len = len;
				longest = s.substring(c - len / 2, c + len / 2 + 1);
			}
		}

		// 子串长为偶数
		for (int c = 0; c < s.length(); c++) {
			int i = 1;
			int len = 0;
			while (true) {
				int start = c - i;
				int end = c + i - 1;
				if (start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end))
					break;
				len = end - start + 1;
				i += 1;
			}
			if (len > longest_len) {
				longest_len = len;
				longest = s.substring(c - len / 2, c + len / 2);
			}
		}

		return longest;
	}
}