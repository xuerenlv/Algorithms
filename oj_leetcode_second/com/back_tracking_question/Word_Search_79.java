package com.back_tracking_question;

public class Word_Search_79 {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		String s = "ABCESEEEFS";
		System.out.println(new Solution_Word_Search_79().exist_huisuo(board, s));
	}

}

class Solution_Word_Search_79 {
	public boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;

		if (word.length() == 0) // 词的长度为0
			return true;
		if (row == 0)
			return false;

		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if (word.length() == 1 || sou_suo_true(board, i, j, word.substring(1), visited)) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

	// 从 board［i］［j］ 出发开始搜索 word
	boolean sou_suo_true(char[][] board, int i, int j, String word, boolean[][] visited) {
		if (word.length() == 0) {
			return true;
		}
		// 用这种方法定义4个方向，挺不错
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int k = 0; k < direction.length; k++) {
			int ii = i + direction[k][0];
			int jj = j + direction[k][1];
			if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[i].length && board[ii][jj] == word.charAt(0)
					&& visited[ii][jj] == false) {
				visited[ii][jj] = true;
				if (word.length() == 1 || sou_suo_true(board, ii, jj, word.substring(1), visited)) {
					return true;
				}
				visited[ii][jj] = false;
			}
		}
		return false;

	}

	// 888888888888888888888888888888888888888888888888888888888888888888888888888
	// 没有出错，就是使用之后没有复原
	public boolean exist_huisuo(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;

		if (word.length() == 0)
			return true;
		if (row == 0)
			return false;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (sou_suo(board, i, j, visited, word, row, col)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean sou_suo(char[][] board, int s_row, int s_col, boolean[][] visited, String word, int row, int col) {
		if (word.length() == 0) {
			return true;
		}
		if (board[s_row][s_col] == word.charAt(0)) {
			word = word.substring(1);
			if (word.length() == 0) {
				return true;
			}
			visited[s_row][s_col] = true;
			boolean a = false;
			boolean b = false;
			boolean c = false;
			boolean d = false;

			if (s_row - 1 >= 0 && !visited[s_row - 1][s_col]) {
				a = sou_suo(board, s_row - 1, s_col, visited, word, row, col);
			}
			if (s_col - 1 >= 0 && !visited[s_row][s_col - 1]) {
				b = sou_suo(board, s_row, s_col - 1, visited, word, row, col);
			}
			if (s_row + 1 < row && !visited[s_row + 1][s_col]) {
				c = sou_suo(board, s_row + 1, s_col, visited, word, row, col);
			}
			if (s_col + 1 < col && !visited[s_row][s_col + 1]) {
				d = sou_suo(board, s_row, s_col + 1, visited, word, row, col);
			}
			visited[s_row][s_col] = false;
			return a || b || c || d;
		} else {
			return false;
		}
	}
}