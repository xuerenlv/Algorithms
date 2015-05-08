package com.leetcode.dp;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84 {

	public static void main(String[] args) {
//		 int[] height= {2,1,5,6,2,3};
		int[] height = { 1, 1, 1, 1, 1, 1, 1 };

		System.out.println(new Solution_Largest_Rectangle_in_Histogram_84().largestRectangleArea(height));
	}

}

class Solution_Largest_Rectangle_in_Histogram_84 {
	//没懂
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stk=new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		while (i <= height.length) {
			int v= i==height.length? 0:height[i];
			if (stk.empty() || height[stk.peek()] <= v) {
//				System.out.print(i+"  ");
				stk.push(i++);
			} else {
				int t = stk.peek();
				stk.pop();
//				System.out.println(maxArea);
				maxArea = Math.max(maxArea, height[t] * (stk.empty() ? i : i - stk.peek() - 1));
//				System.out.println(maxArea);
			}

		}

		return maxArea;
	}

	// Time Limit Exceeded
	public int largestRectangleArea_overtime(int[] height) {
		if (height.length == 1)
			return height[0];
		int i = 0;
		int j = height.length - 1;
		int get = 0;

		int min = Integer.MAX_VALUE;
		int index_min = -1;
		while (i < j) {
			if (index_min < i || index_min > j) {
				min = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					if (height[k] < min) {
						min = height[k];
						index_min = k;
					}
				}
			}

			int souyi = (j - i + 1) * min;
			// System.out.println("***:  "+souyi+"   "+i+"   "+j+"  "+min+"  "+index_min);
			get = Math.max(get, souyi);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return get;
	}

}