package com.leetcode.dp;

public class Distinct_Subsequences_115 {

	public static void main(String[] args) {
		String s = "b";
		String t = "a";
		System.out.println(new Solution_Distinct_Subsequences_115().numDistinct(s, t));
	}

}

class Solution_Distinct_Subsequences_115 {
	public int numDistinct(String s, String t) {
		if (s == null || t == null)
			return 0;
		if (s.length() < t.length())
			return 0;
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		dp[0][0] = 1;
		// 将任意一个字符串变成空串，都为1
		for (int i = 0; i < s.length(); i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}

		return dp[s.length()][t.length()];
	}
}