package com.binary_search_question;

public class Search_a_2D_Matrix_74 {

	public static void main(String[] args) {

	}

}

class Solution_Search_a_2D_Matrix_74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		// 因为这里像一个已排序的序列，折叠而成
		int start = 1;
		int end = m * n;

		int mid, i, j;
		while (start <= end) {
			mid = (start + end) / 2;
			// 算行坐标与列坐标，都是通过总列数确定的
			i = (mid - 1) / n;
			j = (mid - 1) % n;
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}