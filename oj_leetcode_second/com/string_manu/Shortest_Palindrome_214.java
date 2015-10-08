package com.string_manu;

public class Shortest_Palindrome_214 {

	public static void main(String[] args) {

	}

}

class Solution_Shortest_Palindrome_214 {

	public String shortestPalindrome__re(String s) {
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(j)) {
				j += 1;
			}
		}
		if (j == s.length()) {
			return s;
		}
		String suffix = s.substring(j);
		return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}

	public String shortestPalindrome(String s) {
		if (s.length() <= 1)
			return s;

		int mid = (s.length() - 1) / 2;
		String res = "";

		for (int i = mid; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				if ((res = check_p(s, i, i + 1)) != null)
					return res;
			}
			if ((res = check_p(s, i, i)) != null)
				return res;
		}
		return res;
	}

	String check_p(String s, int l, int r) {
		int i = 1;
		while (l - i >= 0 && r + i < s.length()) {
			if (s.charAt(l - i) != s.charAt(r + i))
				break;
			i++;
		}
		if (l - i >= 0)
			return null;

		StringBuilder sb = new StringBuilder(s.substring(r + i));
		sb.reverse();
		return sb + s;
	}
}