package com.leetcode;

public class Rotate_Image_48 {

	public static void main(String[] args) {

	}

}

class Solution_Rotate_Image_48 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int layers = n / 2;
		for (int layer = 0; layer < layers; layer++) {
			for (int i = layer; i < n - 1 - layer; i++) {
				int temp = matrix[i][layer];
				matrix[i][layer] = matrix[n - 1 - layer][i];
				matrix[n - 1 - layer][i] = matrix[n - 1 - i][n - 1 - layer];
				matrix[n - 1 - i][n - 1 - layer] = matrix[layer][n - 1 - i];
				matrix[layer][n - 1 - i] = temp;
			}
		}
	}

}