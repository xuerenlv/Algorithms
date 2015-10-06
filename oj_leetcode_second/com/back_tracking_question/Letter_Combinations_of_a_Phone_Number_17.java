package com.back_tracking_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number_17 {

	public static void main(String[] args) {
		List<String> re = new Solution_Letter_Combinations_of_a_Phone_Number_17().letterCombinations("2222222");

		for (String s : re) {
			System.out.println(s);
		}
	}

}

class Solution_Letter_Combinations_of_a_Phone_Number_17 {
	Map<Integer, List<String>> digitMap = new HashMap<Integer, List<String>>();

	public Solution_Letter_Combinations_of_a_Phone_Number_17() {
		digitMap.put(2, Arrays.asList(new String[] { "a", "b", "c" }));
		digitMap.put(3, Arrays.asList(new String[] { "d", "e", "f" }));
		digitMap.put(4, Arrays.asList(new String[] { "g", "h", "i" }));
		digitMap.put(5, Arrays.asList(new String[] { "j", "k", "l" }));
		digitMap.put(6, Arrays.asList(new String[] { "m", "n", "o" }));
		digitMap.put(7, Arrays.asList(new String[] { "p", "q", "r", "s" }));
		digitMap.put(8, Arrays.asList(new String[] { "t", "u", "v" }));
		digitMap.put(9, Arrays.asList(new String[] { "w", "x", "y", "z" }));
	}

	public List<String> letterCombinations_2(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits.length() == 0)
			return result;
		if (digits.length() == 1)
			return digitMap.get(digits.charAt(0) - '0');

		List<String> intermediate = letterCombinations(digits.substring(1, digits.length()));
		for (String first : digitMap.get(digits.charAt(0) - '0'))
			for (String rest : intermediate)
				result.add(first + rest);
		return result;
	}

	public List<String> letterCombinations(String digits) {
		int len = digits.length();
		List<String> re = new ArrayList<>();
		if (len == 0)
			return re;
		String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String s = "";
		doCombinations(digits, 0, len - 1, letters, re, s);
		return re;
	}

	// 有全排列的思想，直接遍历
	void doCombinations(String digits, int start, int end, String[] letters, List<String> re, String s) {
		if (start > end) {
			re.add(s);
		} else {
			String le = letters[digits.charAt(start) - '0'];
			for (int i = 0; i < le.length(); i++) {
				s += le.charAt(i);
				doCombinations(digits, start + 1, end, letters, re, s);
				s = s.substring(0, s.length() - 1);
			}
		}
	}
}