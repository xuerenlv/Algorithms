package com.dynamic_programing;

public class Distinct_Subsequences_115 {

	public static void main(String[] args) {
		String s = "b";
		String t = "a";
		System.out.println(new Solution_Distinct_Subsequences_115().numDistinct(s, t));
	}

}

class Solution_Distinct_Subsequences_115 {

	public int numDistinct_3(String S, String T) {
		if (T.length() == 0)
			return 0;

		int[] counts = new int[T.length()];
		for (int indexS = 0; indexS < S.length(); indexS++) {
			char charS = S.charAt(indexS);
			for (int indexT = T.length() - 1; indexT >= 0; indexT--) {
				if (T.charAt(indexT) == charS) {
					if (indexT == 0)
						counts[0]++;
					else
						counts[indexT] += counts[indexT - 1];
				}
			}
		}

		return counts[counts.length - 1];
	}

	public int numDistinct_2(String S, String T) {
		int sl = S.length();
		int tl = T.length();

		int[][] dp = new int[tl + 1][sl + 1];
		for (int i = 0; i <= sl; ++i) {
			dp[0][i] = 1;
		}

		for (int t = 1; t <= tl; ++t) {
			for (int s = 1; s <= sl; ++s) {
				if (T.charAt(t - 1) != S.charAt(s - 1)) {
					dp[t][s] = dp[t][s - 1];
				} else {
					dp[t][s] = dp[t][s - 1] + dp[t - 1][s - 1];
				}
			}
		}

		return dp[tl][sl];
	}

	// 这个易于理解	
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