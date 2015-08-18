package com.leetcode.one;

import java.util.Arrays;

public class Spiral_Matrix_II_59 {

	public static void main(String[] args) {
		int[][] mat = new Solution_Spiral_Matrix_II_59().generateMatrix(3);
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}

}

class Solution_Spiral_Matrix_II_59 {
	public int[][] generateMatrix(int n) {
		int[][] mat = new int[n][n];
		if (n == 0)
			return mat;

		int x = 0, y = 0;
		int tot = 2;
		boolean[][] visited = new boolean[n][n];

		mat[x][y] = 1;
		visited[x][y] = true;

		while (tot <= n * n) {
			while (y + 1 < n && !visited[x][y + 1]) {
				mat[x][y + 1] = tot++;
				visited[x][y + 1] = true;
				y++;
			}

			while (x + 1 < n && !visited[x + 1][y]) {
				mat[x + 1][y] = tot++;
				visited[x + 1][y] = true;
				x++;
			}

			while (y - 1 >= 0 && !visited[x][y - 1]) {
				mat[x][y - 1] = tot++;
				visited[x][y - 1] = true;
				y--;
			}
			while (x - 1 >= 0 && !visited[x - 1][y]) {
				mat[x - 1][y] = tot++;
				visited[x - 1][y] = true;
				x--;
			}
		}
		return mat;
	}
}