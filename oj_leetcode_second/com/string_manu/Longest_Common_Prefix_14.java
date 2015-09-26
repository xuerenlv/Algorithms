package com.string_manu;

public class Longest_Common_Prefix_14 {

	public static void main(String[] args) {
		String[] strs = { "aa", "aab" };
		System.out.println(new Solution_Longest_Common_Prefix_14().longestCommonPrefix(strs));
	}

}

class Solution_Longest_Common_Prefix_14 {
	// 第二个版本，进行优化
	public String longestCommonPrefix_second_version(String[] strs) {
		if (strs.length == 0)
			return "";

		String re = "";
		int i = 0;
		while (i < strs[0].length()) {
			char ch = strs[0].charAt(i);
			for (int index = 1; index < strs.length; index++) {
				if (i >= strs[index].length() || strs[index].charAt(i) != ch) {
					return re;
				}
			}
			i++;
			re += ch;
		}

		return re;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";

		String re = "";
		int i = 0;
		while (true) {
			if (i >= strs[0].length())
				break;
			char ch = strs[0].charAt(i);

			int index;
			for (index = 1; index < strs.length; index++) {
				if (i >= strs[index].length() || strs[index].charAt(i) != ch) {
					break;
				}
			}

			if (index == strs.length) {
				i++;
				re += ch;
			} else {
				break;
			}
		}

		return re;
	}
}