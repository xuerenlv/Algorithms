package com.book.sword_offer;

public class print_matrix_p128 {

	public static void main(String[] args) {

	}

}

class solution_p128 {
	void print_matrix(int[][] mat) {
		int row = mat.length;
		if (row == 0)
			return;
		int col = mat[0].length;

		int start = 0;
		while (2 * start < row && 2 * start < col) {
			print_mat_in_circle(mat, start);
			start++;
		}
	}

	void print_mat_in_circle(int[][] mat, int start) {
		
	}
}