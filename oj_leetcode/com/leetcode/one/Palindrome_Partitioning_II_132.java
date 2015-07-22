package com.leetcode.one;

public class Palindrome_Partitioning_II_132 {

	public static void main(String[] args) {
		String s = "ababababababababababababcbabababababababababababa";
		System.out.println(new Solution_Palindrome_Partitioning_II_132().minCut(s));
		System.out.println(new Solution_Palindrome_Partitioning_II_132().minCut_my(s));
	}

}

class Solution_Palindrome_Partitioning_II_132 {
	// 还没有明白
	public int minCut(String s) {
		int len = s.length();
		int[] D = new int[len + 1];
		boolean[][] P = new boolean[len][len];
		// the worst case is cutting by each char
		for (int i = 0; i <= len; i++)
			D[i] = len - i;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || P[i + 1][j - 1])) {
					P[i][j] = true;
					D[i] = Math.min(D[i], D[j + 1] + 1);
				}
			}
		}
		return D[0] - 1;
	}

	// easy version
	// Time Limit Exceeded
	public int minCut_my(String s) {
		int[] count = { Integer.MAX_VALUE };
		par_str(s, 0, s.length(), 0, count);
		return count[0] - 1;
	}

	void par_str(String s, int start, int end, int depth, int[] count) {
		if (start == end) {
			if (count[0] > depth) {
				count[0] = depth;
			}
			return;
		}
		for (int i = start + 1; i <= end; i++) {
			String test = s.substring(start, i);
			if (isPalindrome(test)) {
				par_str(s, i, end, depth + 1, count);
			}
		}
	}

	boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char s1 = s.charAt(i);
			if (s1 == ' ' || !((s1 >= 'A' && s1 <= 'Z') || (s1 >= 'a' && s1 <= 'z') || (s1 >= '0' && s1 <= '9'))) {
				i++;
				continue;
			}
			char s2 = s.charAt(j);
			if (s2 == ' ' || !((s2 >= 'A' && s2 <= 'Z') || (s2 >= 'a' && s2 <= 'z') || (s2 >= '0' && s2 <= '9'))) {
				j--;
				continue;
			}

			if (Character.toLowerCase(s1) == Character.toLowerCase(s2)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}