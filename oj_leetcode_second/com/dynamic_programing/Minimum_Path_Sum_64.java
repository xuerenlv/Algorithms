package com.dynamic_programing;

public class Minimum_Path_Sum_64 {

	public static void main(String[] args) {

	}

}

class Solution_Minimum_Path_Sum_64 {
	// 基于回溯的算法,毫无疑问的超时
	public int minPathSum_2(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		int[] re = new int[1];
		re[0] = Integer.MAX_VALUE;
		int this_sum = 0;
		trival(grid, 0, 0, m - 1, n - 1, this_sum, re);
		return re[0];
	}

	void trival(int[][] grid, int start_r, int start_c, int m, int n, Integer this_sum, int[] re) {
		if (start_r == m && start_c == n) {
			if (this_sum < re[0]) {
				re[0] = this_sum;
			}
			return;
		}

		if (start_r < m) {
			trival(grid, start_r + 1, start_c, m, n, this_sum + grid[start_r][start_c], re);
		}
		if (start_c < n) {
			trival(grid, start_r, start_c + 1, m, n, this_sum + grid[start_r][start_c], re);
		}

	}

	// 基于动态规划的算法
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;

		int[][] count = new int[m][n];
		count[0][0] = grid[0][0];
		// 给第一行的元素赋值
		for (int i = 1; i < m; i++)
			count[i][0] = grid[i][0] + count[i - 1][0];
		// 给第一列的元素赋值
		for (int i = 1; i < n; i++)
			count[0][i] = grid[0][i] + count[0][i - 1];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				count[i][j] = Math.min(count[i - 1][j], count[i][j - 1]) + grid[i][j];
			}
		}

		return count[m - 1][n - 1];
	}
}