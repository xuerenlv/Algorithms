package com.string_manu;

public class Regular_Expression_Matching_10 {

	public static void main(String[] args) {
		System.out.println(new Solution_Regular_Expression_Matching_10().isMatch("aab", "c*a*b"));
		System.out.println(new Solution_Regular_Expression_Matching_10().isMatch("ab", ".*"));
		System.out.println(new Solution_Regular_Expression_Matching_10().isMatch("aa", ".*"));
	}

}

class Solution_Regular_Expression_Matching_10 {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		if (p.length() >= 2 && p.charAt(1) == '*') {
			// '*' Matches zero or more of the preceding element.
			while (s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
				if (isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		} else if (s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
			return isMatch(s.substring(1), p.substring(1));
		}
		return false;
	}
}