package com.leetcode;

public class Maximal_Square_221 {

	public static void main(String[] args) {

	}

}

class Solution_Maximal_Square_221 {
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
				int a = Math.min(i - j + 1, lowest);
				int currArea = a * a;
				if (currArea > area) {
					area = currArea;
				}
			}
		}
		return area;
	}
}