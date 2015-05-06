package com.leetcode.graph;

public class Dungeon_Game_174 {

	public static void main(String[] args) {
		int[][] grid = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		System.out.println(new Solution_Dungeon_Game_174().calculateMinimumHP(grid));
	}

}

class Solution_Dungeon_Game_174 {

	public int calculateMinimumHP(int[][] dungeon) {
		
		return 1;
	}

	// 题目理解的也有问题
	public int calculateMinimumHP_fail(int[][] dungeon) {
		int h_len = dungeon.length;
		int c_len = dungeon[0].length;
		int get = calc_min(dungeon, 0, 0, h_len - 1, c_len - 1);
		return get >= 0 ? 0 : Math.abs(get);
	}

	int calc_min(int[][] grid, int h_start, int c_start, int h_end, int c_end) {
		if (h_start > h_end || c_start > c_end)
			return 0;
		if (h_start == h_end && c_start == c_end)
			return grid[h_end][c_end];

		return Math.min(grid[h_start][c_start] + calc_min(grid, h_start, c_start + 1, h_end, c_end), grid[h_start][c_start]
				+ calc_min(grid, h_start + 1, c_start, h_end, c_end));
	}
}