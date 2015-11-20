package com.graph;

public class Number_Of_Islands_200 {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(new Solution_Number_Of_Islands_200().numIslands(grid));
	}

}

class Solution_Number_Of_Islands_200 {
	public int numIslands(char[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// 两层意思：是块陆地，而且没有被访问过
				if (grid[i][j] == '1') {
					// System.out.println("*****************************************");
					// System.out.println(Arrays.toString(grid[0]));
					// System.out.println(Arrays.toString(grid[1]));
					// System.out.println(Arrays.toString(grid[2]));
					// System.out.println(Arrays.toString(grid[3]));
					// System.out.println("*****************************************");
					sum++;
					set_visit(grid, i, j);
				}
			}
		}
		return sum;
	}

	// 将grid[i][j]的上下左右设置为'2'，表示已被访问过
	void set_visit(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return;

		// 已经访问过
		if (grid[i][j] == 'v' || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = 'v';
		set_visit(grid, i, j + 1);
		set_visit(grid, i, j - 1);
		set_visit(grid, i + 1, j);
		set_visit(grid, i - 1, j);
	}
}
