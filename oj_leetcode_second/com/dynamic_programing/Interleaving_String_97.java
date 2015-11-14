package com.dynamic_programing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interleaving_String_97 {

	public static void main(String[] args) {
		System.out.println(new Solution_Interleaving_String_97().isInterleave_better("aabcc", "dbbca", "aadbbcbcac"));

	}

}

class Solution_Interleaving_String_97 {
	// 基于回溯的算法
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		// backtracking
		return isInterleave(s1, s2, s3, 0, 0);
	}

	private boolean isInterleave(String s1, String s2, String s3, int i, int j) {
		// base base
		int k = i + j;
		if (k == s3.length()) {
			return true;
		}

		// recursive case: next character may be from either s1 or s2
		return ((i < s1.length() && s1.charAt(i) == s3.charAt(k) && isInterleave(s1, s2, s3, i + 1, j))
				|| (j < s2.length() && s2.charAt(j) == s3.charAt(k) && isInterleave(s1, s2, s3, i, j + 1)));
	}

	// ******************************************************************************************
	// 基于动态规划的算法
	public boolean isInterleave_better(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		if (len1 < len2) {
			// to save space for dp array
			return isInterleave(s2, s1, s3);
		}
		boolean[] dp = new boolean[len2 + 1];
		// System.out.println(Arrays.toString(dp)); //初始化为false
		for (int i = len1; i >= 0; i--) {
			for (int j = len2; j >= 0; j--) {
				int k = i + j;
				if (k == len3) {
					dp[j] = true;
				} else {
					dp[j] = (i < len1 && s1.charAt(i) == s3.charAt(k) && dp[j])
							// able to match s3[k] using s1[i] ?
							|| (j < len2 && s2.charAt(j) == s3.charAt(k) && dp[j + 1]);
					// able to match s3[k] using s2[j] ?
				}
			}
		}

		return dp[0];
	}

	// great 这种动态规划就易于理解一些，但是是使用二维空间
	public boolean isInterleave_4(String s1, String s2, String s3) {
		if ((s1.length() + s2.length()) != s3.length())
			return false;

		boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];
		matrix[0][0] = true;
		for (int i = 1; i < matrix[0].length; i++) {
			matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int i = 1; i < matrix.length; i++) {
			matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
						|| (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
			}
		}

		return matrix[s2.length()][s1.length()];
	}
}