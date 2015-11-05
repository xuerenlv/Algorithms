package com.array_question;

public class Climbing_Stairs_70 {

	public static void main(String[] args) {

	}

}

// 实际就是斐波那契数列的使用，但是还带有一点动态规划的思想
class Solution_Climbing_Stairs_70 {
	public int climbStairs(int n) {
		// 至少要有3个slot,这3个slot用来存初始值
		int[] sum = new int[n + 1];

		sum[0] = 0;
		sum[1] = 1;
		sum[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			sum[i] = sum[i - 1] + sum[i - 2];
		}

		return sum[n];
	}
}