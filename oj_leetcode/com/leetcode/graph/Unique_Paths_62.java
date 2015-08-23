package com.leetcode.graph;

public class Unique_Paths_62 {

	public static void main(String[] args) {
		System.out.println(new Solution_Unique_Paths_62().uniquePaths(3, 5));
		System.out.println(new Solution_Unique_Paths_62().uniquePaths_overtime(23, 12));
	}

}

class Solution_Unique_Paths_62 {
	public int uniquePaths(int m, int n) {
		int[][] count = new int[m + 1][n + 1];
		count[0][0] = 0;
		count[1][1] = 1;
		for (int i = 1; i <= m; i++)
			count[i][1] = 1;
		for (int i = 1; i <= n; i++)
			count[1][i] = 1;
		for(int i=2;i<=m;i++){
			for(int j=2;j<=n;j++){
				count[i][j] = count[i-1][j]+count[i][j-1];
			}
		}

		return count[m][n];
	}

	public int uniquePaths_overtime(int m, int n) {
		if (m == 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;

		int[] count = new int[1];
		tran(0, 0, m - 1, n - 1, count);
		return count[0];
	}

	void tran(int x, int y, int m, int n, int[] count) {
		if (x == m && y == n) {
			count[0]++;
		}
		if (y < n)
			tran(x, y + 1, m, n, count);
		if (x < m)
			tran(x + 1, y, m, n, count);
	}
}
