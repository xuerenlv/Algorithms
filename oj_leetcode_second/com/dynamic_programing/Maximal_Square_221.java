package com.dynamic_programing;

import java.util.Stack;

public class Maximal_Square_221 {

	public static void main(String[] args) {

	}

}

class Solution_Maximal_Square_221 {
	// 使用动态规划的算法
	// 也是很有想法的算法，很有趣
	public int maximalSquare_2(char[][] a) {
		if (a == null || a.length == 0 || a[0].length == 0)
			return 0;

		int max = 0, n = a.length, m = a[0].length;

		// dp(i, j) represents the length of the square
		// whose lower-right corner is located at (i, j)
		// dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		// return the area
		return max * max;
	}

	// *************************************************************************************
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int[] height = new int[col];

		int get = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			get = Math.max(get, largestSquareArea(height));

		}

		return get;
	}

	public int largestSquareArea(int[] height) {
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			for (int k = i + 1; k < height.length; k++) {
				if (height[k] < height[k - 1]) {
					i = k - 1;
					break;
				} else {
					i = k;
				}
			}
			int lowest = height[i];
			for (int j = i; j >= 0; j--) {
				if (height[j] < lowest) {
					lowest = height[j];
				}
				// i-j+1是长度 lowest是高度
				int a = Math.min(i - j + 1, lowest);
				int currArea = a * a;
				if (currArea > area) {
					area = currArea;
				}
			}
		}
		return area;
	}

	// also ok
	public int largestSquareArea_2(int[] height) {
		Stack<Integer> stk = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i <= height.length) {
			int v = i == height.length ? 0 : height[i];
			if (stk.empty() || height[stk.peek()] <= v) {
				stk.push(i++);
			} else {
				int t = stk.peek();
				stk.pop();
				int a = Math.min(height[t], (stk.empty() ? i : i - stk.peek() - 1));
				maxArea = Math.max(maxArea, a * a);
			}

		}
		return maxArea;
	}
}