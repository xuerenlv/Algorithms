package com.graph;

import java.util.Arrays;

public class Sudoku_Solver_37_changed {

	public static void main(String[] args) {
		char[][] board_1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		char[][] board_2 = { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' }, { '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' }, { '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' }, { '.', '.', '.', '2', '7', '5', '9', '.', '.' } };

		// new Solution_Sudoku_Solver_37_changed().solveSudoku(board_1);
		// print(board_1);

		new Solution_Sudoku_Solver_37_changed().solveSudoku(board_2);
		print(board_2);
	}

	static void print(char[][] board) {
		System.out.println("*************************start****************************");
		for (int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("**************************end*****************************");
	}

}

class Solution_Sudoku_Solver_37_changed {

	// second version
	public void solveSudoku_2(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (solve(board))
								return true; // If it's the solution return true
							else
								board[i][j] = '.'; // Otherwise go back
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int i, int j, char c) {
		for (int row = 0; row < 9; row++)
			if (board[row][j] == c)
				return false;
		for (int col = 0; col < 9; col++)
			if (board[i][col] == c)
				return false;
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
				if (board[row][col] == c)
					return false;
		return true;
	}

	// first version
	public void solveSudoku(char[][] board) {
		try {
			resolve(board, 0);
		} catch (Exception e) {
		}
	}

	void resolve(char[][] board, int place) throws Exception {
		print(board);
		int row = 0, col = 0;
		for (int i = place; i < 81; i++) {
			row = i / 9;
			col = i % 9;
			if (board[row][col] == '.')
				break;
			if (i == 80) {
				// 为何抛出异常，目的是让程序全局停止
				throw new Exception("end");
			}

		}

		for (int i = 0; i < 9; i++) {
			char test = (char) (i + '1');
			if (is_ok(board, row, col, test)) {
				board[row][col] = test;
				resolve(board, place + 1);
			}
		}
		board[row][col] = '.';
	}

	boolean is_ok(char[][] board, int row, int col, char fill) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == fill || board[i][col] == fill) {
				return false;
			}
		}

		int row_st = (int) (row / 3) * 3;
		int col_st = (int) (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row_st + i][col_st + j] == fill) {
					return false;
				}
			}
		}

		return true;
	}

	void print(char[][] board) {
		System.out.println("*************************start****************************");
		for (int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("**************************end*****************************");
	}
}
