package com.array_question;

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
	// 一个是基于纪录访问
	// 一个是固定开始与结束，都是模拟这个过程

	public int[][] generateMatri_2(int n) {
		int[][] mat = new int[n][n];
		if (n == 0)
			return mat;

		int rowBegin = 0;
		int rowEnd = mat.length - 1;
		int colBegin = 0;
		int colEnd = mat[0].length - 1;

		int tot = 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				mat[rowBegin][j] = tot++;
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				mat[j][colEnd] = tot++;
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					mat[rowEnd][j] = tot++;
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					mat[j][colBegin] = tot++;
				}
			}
			colBegin++;
		}

		return mat;
	}

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