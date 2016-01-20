package com.need_think;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84 {

	public static void main(String[] args) {
		int[] height = { 2, 1, 5, 6, 2, 3 };
		// int[] height = { 1, 1 };

		System.out.println(new Solution_Largest_Rectangle_in_Histogram_84().largestRectangleArea_2(height));
		// System.out.println(new
		// Solution_Largest_Rectangle_in_Histogram_84().largestRectangleArea1(height));
	}

}

class Solution_Largest_Rectangle_in_Histogram_84 {

	public int largestRectangleArea_2(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}

	public int largestRectangleArea_another(int[] height) {
		if (height == null)
			return 0;// Should throw exception
		if (height.length == 0)
			return 0;

		Stack<Integer> index = new Stack<Integer>();
		index.push(-1);
		int max = 0;

		for (int i = 0; i < height.length; i++) {
			// Start calculate the max value
			while (index.peek() > -1)
				if (height[index.peek()] > height[i]) {
					int top = index.pop();
					max = Math.max(max, height[top] * (i - 1 - index.peek()));
				} else
					break;

			index.push(i);
		}
		while (index.peek() != -1) {
			int top = index.pop();
			max = Math.max(max, height[top] * (height.length - 1 - index.peek()));
		}
		return max;
	}

	// 懂了，很有思想
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stk = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i <= height.length) {
			int v = i == height.length ? 0 : height[i];// 对于最后一个位置，传入的是0
			if (stk.empty() || height[stk.peek()] <= v) {// 栈为空，或当前高度大于栈顶的高度，入栈
				stk.push(i++);
			} else {
				int t = stk.peek();
				stk.pop();
				// 栈中存放的最小元素为0，所以栈为空只有那么一种情况
				maxArea = Math.max(maxArea, height[t] * (stk.empty() ? i : i - stk.peek() - 1));
			}

		}
		return maxArea;
	}

	// O(n^2) with pruning
	// 这个也是可以通过的
	public int largestRectangleArea1(int[] height) {
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			// 从当前位置向后，找寻最大值
			for (int k = i + 1; k < height.length; k++) {
				if (height[k] < height[k - 1]) {
					i = k - 1;
					break;
				} else {
					i = k;
				}
			}
			int lowest = height[i];// 此时的 height[i] 是最高值
			// 对当前位置向前，逐个计算面积
			for (int j = i; j >= 0; j--) {
				if (height[j] < lowest) {
					lowest = height[j];
				}
				int currArea = (i - j + 1) * lowest;
				if (currArea > area) {
					area = currArea;
				}
			}
		}
		return area;
	}

}