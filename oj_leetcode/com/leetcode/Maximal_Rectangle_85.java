package com.leetcode;

import java.util.Stack;

public class Maximal_Rectangle_85 {

	public static void main(String[] args) {

	}

}

class Solution_Maximal_Rectangle_85 {
	// 直接使用到84题的代码
	// accepted
	public int maximalRectangle(char[][] matrix) {
		int row = matrix.length;
		if(row==0){
			return 0;
		}
		int col = matrix[0].length;
		int[] height = new int[col];
		
		int get=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j] == '1'){
					height[j]++;
				}else{
					height[j]=0;
				}
			}
			get = Math.max(get, largestRectangleArea(height));
			
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
