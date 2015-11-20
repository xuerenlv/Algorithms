package com.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Surrounded_Regions_130 {

	public static void main(String[] args) {
		char[][] grid = { { 'X', 'X', 'X' }, { 'X', 'O', 'X' }, { 'X', 'X', 'X' } };

		// char[][] grid = { { 'X', 'X', 'X', '0', '0' },
		// { 'X', 'X', '0', 'X', '0' },
		// { '0', '0', 'X', '0', 'X' },
		// { '0', '0', '0', 'X', 'X' } };

		new Solution_Surrounded_Regions_130().solve(grid);
		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		// int[][] v_board=new int[grid.length][grid[0].length];
		// System.out.println(new
		// Solution_Surrounded_Regions_130().is_surrond(0, 3, v_board, grid));
	}

}

class Solution_Surrounded_Regions_130 {
	/*
	 * 其实前一阵面微软的时候二面考的算法就跟这个有相似的地方，总的来说都可以归结为一个连通性的问题，用BFS；
	 * 
	 * 1.很明显在最外面一圈的O挨着的O肯定最后不是被包围的，与这个O也相连的也不能被包围，即这些O在最后的矩阵里面还是O；
	 * 
	 * 2.我们从最外面一圈的O出发，用BFS，利用队列帮助进行扩展，将所有它能联通到的O都标记，
	 * 
	 * 3.随后我们再扫描一遍矩阵，被标记的改回O,没有被标记的O都是可以被包围的，所以要改成X；
	 */

	public void solve(char[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;

		int i, j;
		for (i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				process(i, 0, board);
			if (board[i][n - 1] == 'O')
				process(i, n - 1, board);
		}
		for (i = 0; i < n; i++) {
			if (board[0][i] == 'O')
				process(0, i, board);
			if (board[m - 1][i] == 'O')
				process(m - 1, i, board);
		}

		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'E')
					board[i][j] = 'O';
			}
		}
	}

	class Pair {
		int i;
		int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	void process(int i, int j, char[][] board) {
		int m = board.length;
		int n = board[0].length;

		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(i, j));
		board[i][j] = 'E';
		while (!queue.isEmpty()) {
			Pair f = queue.poll();
			int x = f.i;
			int y = f.j;

			// extending
			if (x != 0 && board[x - 1][y] == 'O') {
				queue.add(new Pair(x - 1, y));
				board[x - 1][y] = 'E'; // extended;
			}
			if (x != m - 1 && board[x + 1][y] == 'O') {
				queue.add(new Pair(x + 1, y));
				board[x + 1][y] = 'E'; // extended;
			}
			if (y != 0 && board[x][y - 1] == 'O') {
				queue.add(new Pair(x, y - 1));
				board[x][y - 1] = 'E'; // extended;
			}
			if (y != n - 1 && board[x][y + 1] == 'O') {
				queue.add(new Pair(x, y + 1));
				board[x][y + 1] = 'E'; // extended;
			}
		}
	}

	// ****************************************************************************************************
	// Line 26: java.lang.StackOverflowError
	public void solve_runtime_error(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int[][] v_board;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					v_board = new int[board.length][board[0].length];
					if (is_surrond(i, j, v_board, board)) {
						set_to(i, j, board);
					}
				}
			}
		}
	}

	boolean is_surrond(int i, int j, int[][] v_board, char[][] board) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		// 已经访问过
		if (v_board[i][j] == 1 || board[i][j] == 'X') {
			return true;
		}
		v_board[i][j] = 1;
		return is_surrond(i, j + 1, v_board, board) && is_surrond(i, j - 1, v_board, board)
				&& is_surrond(i + 1, j, v_board, board) && is_surrond(i - 1, j, v_board, board);
	}

	void set_to(int i, int j, char[][] board) {
		if (board[i][j] == 'X')
			return;

		board[i][j] = 'X';
		set_to(i, j + 1, board);
		set_to(i, j - 1, board);
		set_to(i + 1, j, board);
		set_to(i - 1, j, board);
	}

}