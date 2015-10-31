package com.back_tracking_question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_Queens_51 {

	public static void main(String[] args) {

		List<List<String>> re = new Solution_N_Queens_51().solveNQueens(10);
		for (List<String> in : re) {
			System.out.println(in.toString());
		}
	}

}

class Solution_N_Queens_51 {
	// 这种方法超时，但是图的深度遍历的方法很有趣
	public List<List<String>> solveNQueens_other(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(board, 0, res);
		return res;
	}

	private void dfs(char[][] board, int colIndex, List<List<String>> res) {
		if (colIndex == board.length) {
			res.add(construct(board));
			return;
		}

		for (int i = 0; i < board.length; i++) {// 遍历 每一行
			if (validate(board, i, colIndex)) {
				board[i][colIndex] = 'Q';
				dfs(board, colIndex + 1, res);
				board[i][colIndex] = '.';
			}
		}
	}

	private boolean validate(char[][] board, int x, int y) {
		for (int i = 0; i < x; i++) {
			int i_col = 0;
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'Q') {
					i_col = j;
					break;
				}
			}
			if (i_col == y)
				return false;
			if (Math.abs(x - i) == Math.abs(i_col - y))
				return false;
		}

		return true;
	}

	private List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}

	// ／／／／／／／／／／／／／／／／／／／／／／／／／／／
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> re = new ArrayList<List<String>>();
		int[] arr = new int[n];
		n_queens(arr, n, 0, re);
		return re;
	}

	// 这个是将数组转变成结果所要求的形式
	// arr 里面存放每一行，放于哪一个位置
	void printN(int[] arr, List<List<String>> re) {
		List<String> in = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			String str = "";
			for (int j = 0; j < arr.length; j++) {
				if (j != arr[i]) {
					str += '.';
				} else {
					str += 'Q';
				}
			}
			in.add(str);
		}
		re.add(in);
	}

	// index 代表的是行
	void n_queens(int[] arr, int n, int index, List<List<String>> re) {
		for (int i = 0; i < n; i++) { // 遍历一列中的所有位置
			if (isValid(arr, index, i)) {
				arr[index] = i;
				if (index == n - 1) {// 当走到最后一行了
					printN(arr, re);
					arr[index] = 0;
					return;
				}
				n_queens(arr, n, index + 1, re);
				arr[index] = 0;
			}

		}
	}

	// 在第row行，放置在col列是否合适
	boolean isValid(int[] arr, int row, int col) {
		for (int i = 0; i < row; i++) {
			int i_col = arr[i];
			if (i_col == col) // 在同一列
				return false;
			if (Math.abs(i_col - col) == Math.abs(i - row)) // 在一个对角线上
				return false;
		}
		return true;
	}
}