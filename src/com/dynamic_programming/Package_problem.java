package com.dynamic_programming;

public class Package_problem {

	public static void main(String[] args) {

	}

}

class package_pro {

	// m:背包大小
	// items: 物品的大小
	public int backPack(int m, int[] A) {
		int[][] dp = new int[A.length][m + 1];

		for (int j = 1; j < m + 1; j++) {
			if (A[0] <= j) {
				dp[0][j] = A[0];
			}
			for (int i = 1; i < A.length; i++) {
				if (A[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i - 1][j]);
				}
			}
		}
		return dp[A.length - 1][m];
	}

}