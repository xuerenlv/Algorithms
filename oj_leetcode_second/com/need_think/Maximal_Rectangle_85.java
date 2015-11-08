package com.need_think;

import java.util.Stack;

public class Maximal_Rectangle_85 {

	public static void main(String[] args) {

	}

}

class Solution_Maximal_Rectangle_85 {

	public int maximalRectangle_dp(char[][] matrix) {
		int area = 0, new_area, r, l;
		if (matrix.length > 0) {
			int[] line = new int[matrix[0].length];
			boolean[] is_processed = new boolean[matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == '1') {
						line[j]++;
						is_processed[j] = false;
					} else {
						line[j] = 0;
						is_processed[j] = true;
					}
				}
				for (int j = 0; j < matrix[i].length; j++) {
					if (is_processed[j])
						continue;
					r = l = 1;
					while ((j + r < line.length) && (line[j + r] >= line[j])) {
						if (line[j + r] == line[j])
							is_processed[j + r] = true;
						r++;
					}
					while ((j - l >= 0) && (line[j - l] >= line[j]))
						l++;
					new_area = (r + l - 1) * line[j];
					if (new_area > area)
						area = new_area;
				}
			}
		}
		return area;
	}

	public int maximalRectangle_2(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];
		int maxA = 0;
		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			for (int j = 0; j < n; j++) { // compute height (can do this from
											// either side)
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) { // compute left (from left to right)
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}
			// compute the area of rectangle (can do this from either side)
			for (int j = 0; j < n; j++)
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
		}
		return maxA;
	}

	// 直接使用到84题的代码
	// accepted
	// 这里使用每一行与每一列都是可以的，所以可以调少的使用
	public int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			return 0;
		}
		int col = matrix[0].length;
		int[] height = new int[col];

		int get = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			get = Math.max(get, largestRectangleArea(height));// 每一行是一个84题
		}

		return get;
	}

	public int largestRectangleArea(int[] height) {
		Stack<Integer> stk = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i <= height.length) {
			int v = i == height.length ? 0 : height[i];
			if (stk.empty() || height[stk.peek()] <= v) {
				stk.push(i++);
			} else {
				int t = stk.peek();
				stk.pop();
				maxArea = Math.max(maxArea, height[t] * (stk.empty() ? i : i - stk.peek() - 1));
			}

		}
		return maxArea;
	}
}
