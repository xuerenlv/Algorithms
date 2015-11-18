package com.dynamic_programing;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {

	public static void main(String[] args) {
		List<Integer> line1 = new ArrayList<>();
		line1.add(-1);

		List<Integer> line2 = new ArrayList<>();
		line2.add(3);
		line2.add(2);

		List<Integer> line3 = new ArrayList<>();
		line3.add(1);
		line3.add(-2);
		line3.add(-1);

		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(line1);
		triangle.add(line2);
		triangle.add(line3);

		System.out.println(new Solution_Triangle_120().minimumTotal(triangle));
		System.out.println(new Solution_Triangle_120().minimumTotal_overtime_2(triangle));
	}

}

class Solution_Triangle_120 {
	// 从下向上进行计算
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] A = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
			}
		}
		return A[0];
	}

	// 使用回溯法也是可以的，只是会超时
	public int minimumTotal_overtime_2(List<List<Integer>> triangle) {
		int row = triangle.size();
		if (row == 0)
			return 0;

		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;

		for (int i = 0; i < triangle.get(row - 1).size(); i++) {
			tran_bottom_up(row - 1, i, triangle, min, triangle.get(row - 1).get(i));
		}

		return min[0];
	}

	void tran_bottom_up(int start_row, int index, List<List<Integer>> triangle, int[] min, int val) {
		if (start_row == 0) {
			min[0] = val < min[0] ? val : min[0];
			return;
		}

		if (index < triangle.get(start_row - 1).size()) {
			tran_bottom_up(start_row - 1, index, triangle, min, val + triangle.get(start_row - 1).get(index));
		}
		if (index - 1 < triangle.get(start_row - 1).size() && index - 1 >= 0) {
			tran_bottom_up(start_row - 1, index - 1, triangle, min, val + triangle.get(start_row - 1).get(index - 1));
		}
	}

	// 超时
	public int minimumTotal_overtime(List<List<Integer>> triangle) {
		int row = triangle.size();
		if (row == 0)
			return 0;

		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		tran(0, triangle.size(), 0, triangle, min, triangle.get(0).get(0));
		return min[0];
	}

	void tran(int start_row, int end_row, int index, List<List<Integer>> triangle, int[] min, int val) {
		if (start_row == end_row - 1) {
			min[0] = val < min[0] ? val : min[0];
			return;
		}

		int a = index;
		int b = a + 1;
		if (a < triangle.get(start_row + 1).size()) {
			tran(start_row + 1, end_row, a, triangle, min, val + triangle.get(start_row + 1).get(a));
		}
		if (b < triangle.get(start_row + 1).size()) {
			tran(start_row + 1, end_row, b, triangle, min, val + triangle.get(start_row + 1).get(b));
		}
	}
}