package com.graph;

import java.util.ArrayList;

public class Valid_Sudoku_36 {

	public static void main(String[] args) {
		System.out.println((int) (8 / 3) * 3);
	}

}

class Solution_Valid_Sudoku_36 {
	// 应用3条规则，对一个数独是否合理，进行检验
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!first_rule(board, i) || !second_rule(board, i)) {
				return false;
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!third_rule(board, i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	boolean first_rule(char[][] board, int row) {
		ArrayList<Integer> container = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.') {
				int num = (int) (board[row][i] - '0');
				if (!container.contains(num)) {
					container.add(num);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	boolean second_rule(char[][] board, int col) {
		ArrayList<Integer> container = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.') {
				int num = (int) (board[i][col] - '0');
				if (!container.contains(num)) {
					container.add(num);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	boolean third_rule(char[][] board, int row_st, int col_st) {
		ArrayList<Integer> container = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row_st + i][col_st + j] != '.') {
					int num = (int) (board[row_st + i][col_st + j] - '0');
					if (!container.contains(num)) {
						container.add(num);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}