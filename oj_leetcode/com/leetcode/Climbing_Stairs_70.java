package com.leetcode;

public class Climbing_Stairs_70 {

	public static void main(String[] args) {

	}

}

// 实际就是斐波那契数列的使用
class Solution_Climbing_Stairs_70 {
	public int climbStairs(int n) {
		// 至少要有3个slot
		int[] sum = new int[n + 3];

		sum[0] = 0;
		sum[1] = 1;
		sum[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			sum[i] = sum[i - 1] + sum[i - 2];
		}

		return sum[n];
	}
}