package com.string_manu;

import java.util.ArrayList;

public class Wildcard_Matching_44 {

	public static void main(String[] args) {
		// System.out.println(new
		// Solution_Wildcard_Matching_44().isMatch("abefcdgiescdfimde",
		// "ab*cd?i*de"));

	}

}

class Solution_Wildcard_Matching_44 {
	public boolean isMatch_tan_xin(String s, String p) {
		ArrayList<String> p_pattern = new ArrayList<>();
		ArrayList<String> rs_li = new ArrayList<>();

		int index_s = 0;
		int index_p = 0;
		while (index_s < s.length() && index_p < p.length()) {
			if (s.charAt(index_s) == p.charAt(index_p) || p.charAt(index_p) == '?') {
				index_s++;
				index_p++;
				continue;
			}
			if (p.charAt(index_p) == '*') {
				p_pattern.add(p.substring(index_p + 1));
				index_p++;
				rs_li.add(s);
				continue;
			}
			if (p_pattern.size() != 0) {
				p = p_pattern.get(0);
				index_p = 0;
				s = rs_li.get(0);
				index_s++;
				continue;
			}
			return false;

		}
		while (p.charAt(index_p) == '*')
			index_p++;
		return index_p == '\0';
	}

	// Time Limit Exceeded
	// 递归的版本，耗时太大
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