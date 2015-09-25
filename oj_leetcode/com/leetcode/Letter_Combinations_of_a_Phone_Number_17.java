package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number_17 {

	public static void main(String[] args) {
		List<String> re = new Solution_Letter_Combinations_of_a_Phone_Number_17().letterCombinations("2222222");

		for (String s : re) {
			System.out.println(s);
		}
	}

}

class Solution_Letter_Combinations_of_a_Phone_Number_17 {
	public List<String> letterCombinations(String digits) {
		int len = digits.length();
		List<String> re = new ArrayList<>();
		String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String s = "";

		if (len == 0)
			return re;
		doCombinations(digits, 0, len - 1, letters, re, s);

		return re;
	}

	// 有全排列的思想
	void doCombinations(String digits, int start, int end, String[] letters, List<String> re, String s) {
		if (start > end) {
			re.add(s);
		} else {
			String le = letters[digits.charAt(start) - '0'];
			for (int i = 0; i < le.length(); i++) {
				s += letters[digits.charAt(start) - '0'].charAt(i);
				doCombinations(digits, start + 1, end, letters, re, s);
				s = s.substring(0, s.length() - 1);
			}
		}

	}
}