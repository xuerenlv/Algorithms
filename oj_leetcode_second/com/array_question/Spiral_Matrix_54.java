package com.array_question;

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

	public List<Integer> spiralOrder_2(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return res;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		// 也很清晰，因为开始条件与终止条件都已确定，然后就便于处理
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> re = new ArrayList<>();
		int row = matrix.length;
		if (row == 0)
			return re;
		int col = matrix[0].length;

		int x = 0, y = 0;
		int num = row * col;// num为元素的个数
		boolean[][] visited = new boolean[row][col];// 纪录是否遍历
		re.add(matrix[x][y]); // 第一个数据先加入
		visited[x][y] = true;

		while (num > 1) { // 里面的4个方向逐个运转，vistied负责纪录边界，num负责退出循环
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