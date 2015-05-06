package com.leetcode.graph;

public class Dungeon_Game_174 {

	public static void main(String[] args) {
		int[][] grid = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		System.out.println(new Solution_Dungeon_Game_174().calculateMinimumHP(grid));
	}

}

class Solution_Dungeon_Game_174 {

	public int calculateMinimumHP(int[][] dungeon) {
		// 二维空间DP问题
		int m = dungeon.length;
		int n = dungeon[0].length;
		// 0225
		int[][] dp = new int[m][n];// dp[i][j]表示从(i,j)到目的地(m-1,n-1)需要的最小生命值
		// 初始化 操作数据（change数据）
		dp[m - 1][n - 1] = Math.max(0 - dungeon[m - 1][n - 1], 0);
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 0);
		}
		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i], 0);
		}
		// 从下向上，从右向左填表
		// dp方程为 dp[i][j] = min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j] 再和0取最大
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j], 0);
			}
		}
		return dp[0][0] + 1;
	}

	// 题目理解的也有问题
	public int calculateMinimumHP_fail(int[][] dungeon) {
		int h_len = dungeon.length;
		int c_len = dungeon[0].length;
		int get = calc_min(dungeon, 0, 0, h_len - 1, c_len - 1);
		return get >= 0 ? 0 : Math.abs(get);
	}

	int calc_min(int[][] grid, int h_start, int c_start, int h_end, int c_end) {
		if (h_start > h_end || c_start > c_end)
			return 0;
		if (h_start == h_end && c_start == c_end)
			return grid[h_end][c_end];

		return Math.min(grid[h_start][c_start] + calc_min(grid, h_start, c_start + 1, h_end, c_end), grid[h_start][c_start]
				+ calc_min(grid, h_start + 1, c_start, h_end, c_end));
	}
}