package com.graph;

public class Unique_Paths_62 {

	public static void main(String[] args) {
		System.out.println(new Solution_Unique_Paths_62().uniquePaths(3, 5));
		System.out.println(new Solution_Unique_Paths_62().uniquePaths_overtime(3, 5));
	}

}

class Solution_Unique_Paths_62 {
	// C(m+n-2)(m-1) 也可以直接算，使用组合公式
	int uniquePaths_formulas(int m, int n) {
		int N = n + m - 2;// how much steps we need to do
		int k = m - 1; // number of steps that need to go down
		double res = 1;
		// here we calculate the total possible path number
		// Combination(N, k) = n! / (k!(n - k)!)
		// reduce the numerator and denominator and get
		// C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
		for (int i = 1; i <= k; i++)
			res = res * (N - k + i) / i;
		return (int) res;
	}

	// 总结而言，动态规划，有些空间换时间的意味
	public int uniquePaths(int m, int n) {
		int[][] count = new int[m + 1][n + 1];// 只用外层的1，不用内层的零
		count[1][1] = 1;
		for (int i = 1; i <= m; i++)
			count[i][1] = 1;
		for (int i = 1; i <= n; i++)
			count[1][i] = 1;
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				count[i][j] = count[i - 1][j] + count[i][j - 1];
			}
		}

		return count[m][n];
	}

	// 基于回溯的想法
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
		if (x < m)
			tran(x + 1, y, m, n, count);
		if (y < n)
			tran(x, y + 1, m, n, count);
	}
}
