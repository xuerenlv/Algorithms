package com.leetcode.one;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> re = new Solution_Spiral_Matrix_54().spiralOrder(matrix);
		System.out.println(re.toString());
	}

}

class Solution_Spiral_Matrix_54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> re = new ArrayList<>();
		int row = matrix.length;
		if (row == 0)
			return re;
		int col = matrix[0].length;

		int x = 0, y = 0;
		int num = row * col;
		boolean[][] visited = new boolean[row][col];
		re.add(matrix[x][y]);
		visited[x][y] = true;
		while (num > 1) {
			while (y + 1 < col && !visited[x][y + 1]) {
				re.add(matrix[x][y + 1]);
				visited[x][y + 1] = true;
				y++;
				num--;
			}

			while (x + 1 < row && !visited[x + 1][y]) {
				re.add(matrix[x + 1][y]);
				visited[x + 1][y] = true;
				x++;
				num--;
			}

			while (y - 1 >= 0 && !visited[x][y - 1]) {
				re.add(matrix[x][y - 1]);
				visited[x][y - 1] = true;
				y--;
				num--;
			}
			while (x - 1 >= 0 && !visited[x - 1][y]) {
				re.add(matrix[x - 1][y]);
				visited[x - 1][y] = true;
				x--;
				num--;
			}
		}
		return re;
	}
}