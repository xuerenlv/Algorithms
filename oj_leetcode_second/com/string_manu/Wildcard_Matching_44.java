package com.string_manu;

public class Wildcard_Matching_44 {

	public static void main(String[] args) {
		String s = "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb";
		String p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a";

		System.out.println(new Solution_Wildcard_Matching_44().isMatch_dp_1(s, p));
		System.out.println(new Solution_Wildcard_Matching_44().isMatch_dp_2("aa", "*"));
		// System.out.println(new Solution_Wildcard_Matching_44().isMatch(s,
		// p));
	}

}

class Solution_Wildcard_Matching_44 {

	// 这个是根据人家dp的思想，自己做的
	public boolean isMatch_dp_2(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;
		for (int i = 1; i < s.length(); i++) {
			match[i][0] = false;
		}
		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*') {
				match[0][i] = match[0][i - 1];
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
					match[i][j] = match[i - 1][j - 1];
				else if (p.charAt(j - 1) == '*')
					match[i][j] = match[i][j - 1] || match[i - 1][j];
				else
					match[i][j] = false;
			}
		}
		return match[s.length()][p.length()];
	}

	// DP , from discuss
	public boolean isMatch_dp_1(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) != '*')
				break;
			else
				match[s.length()][i] = true;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (p.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}

	// Time Limit Exceeded
	// 递归的版本，耗时太大
	// "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"
	// "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;
		if (s.length() == 0) {
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*')
					return false;
			}
			return true;
		}

		if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
			return isMatch(s.substring(1), p.substring(1));
		} else if (p.charAt(0) == '*') {
			// p = p.substring(1, p.length());
			// '*' Matches any sequence of characters (including the empty
			// sequence).
			// 一个 ＊ 或者多个 ＊ 效果是一样的
			while (p.length() > 0 && p.charAt(0) == '*')
				p = p.substring(1);
			while (s.length() != 0) {
				if (isMatch(s, p))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p);
		}
		return false;
	}
}