package com.back_tracking_question;

public class N_Queens_II_52 {

	public static void main(String[] args) {
		System.out.println(new Solution_N_Queens_II_52().totalNQueens(10));
	}

}

class Solution_N_Queens_II_52 {
	public int totalNQueens(int n) {
		int[] count = new int[1];
		int[] arr = new int[n];
		n_queens(arr, n, 0, count);
		// 用一个数组来传递个数
		return count[0];
	}

	void n_queens(int[] arr, int n, int index, int[] count) {
		for (int i = 0; i < n; i++) { // 遍历第index行的每一列
			if (isValid(arr, index, i)) {
				arr[index] = i;
				if (index == n - 1) {
					count[0]++;
					arr[index] = 0;
					return;
				}
				n_queens(arr, n, index + 1, count);
				arr[index] = 0;
			}

		}
	}

	// 在第row行，放置在col列是否合适
	boolean isValid(int[] arr, int row, int col) {
		for (int i = 0; i < row; i++) {
			int i_col = arr[i];
			if (i_col == col)
				return false;
			if (i_col - col == i - row)
				return false;
			if (i_col - col == row - i)
				return false;
		}
		return true;
	}
}