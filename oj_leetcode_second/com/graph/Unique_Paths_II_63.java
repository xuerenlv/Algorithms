package com.graph;

public class Unique_Paths_II_63 {

	public static void main(String[] args) {

	}

}

class Solution_Unique_Paths_II_63 {

	// 这个，也是使用动态规划，将空间降低了
	public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

	// 基于动态规划的解法
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;

		int[][] count = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					count[i][j] = 0;
				} else {
					if (i - 1 >= 0) {
						if (j - 1 >= 0) {
							count[i][j] = count[i - 1][j] + count[i][j - 1];
						} else {
							count[i][j] = count[i - 1][j];
						}
					} else {
						if (j - 1 >= 0) {
							count[i][j] = count[i][j - 1];
						} else {
							count[i][j] = obstacleGrid[i][j] == 0 ? 1 : 0;// 也就是起点
						}
					}
				}
			}
		}

		return count[m - 1][n - 1];
	}

	// 基于回溯的做法
	public int uniquePathsWithObstacles_overtime(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		if (row == 0)
			return 0;
		int col = obstacleGrid[0].length;
		int[] count = new int[1];
		tran(obstacleGrid, 0, 0, row, col, count);
		return count[0];
	}

	void tran(int[][] obstacleGrid, int x, int y, int row, int col, int[] count) {
		if (x == row - 1 && col == col - 1 && obstacleGrid[x][y] != 1) {
			count[0]++;
			return;
		}
		if (obstacleGrid[x][y] == 1)
			return;

		if (x < row - 1)
			tran(obstacleGrid, x + 1, y, row, col, count);
		if (y < col - 1)
			tran(obstacleGrid, x, y + 1, row, col, count);

	}
}