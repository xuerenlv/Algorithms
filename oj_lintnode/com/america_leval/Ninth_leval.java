package com.america_leval;

public class Ninth_leval {

	public static void main(String[] args) {
		System.out.println(new Solution_Ninth_leval_2().climbStairs(4));
	}

}

// 乘积最大子序列
class Solution_Ninth_leval_5 {
	/**
	 * @param nums:
	 *            an array of integers
	 * @return: an integer
	 */
	public int maxProduct(int[] nums) {
		
		
		
		
	}
}

// 最大子数组
class Solution_Ninth_leval_4 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;

		int max = nums[0];
		int this_max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (this_max < 0)
				this_max = 0;
			this_max += nums[i];
			max = Math.max(this_max, max);
		}

		return max;
	}
}

// 数字三角形
class Solution_Ninth_leval_3 {
	/**
	 * @param triangle:
	 *            a list of lists of integers.
	 * @return: An integer, minimum path sum.
	 */
	public int minimumTotal(int[][] triangle) {
		int[] A = new int[triangle.length + 1];
		for (int i = triangle.length - 1; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				A[j] = Math.min(A[j], A[j + 1]) + triangle[i][j];
			}
		}
		return A[0];
	}
}

// 爬楼梯
class Solution_Ninth_leval_2 {
	/**
	 * @param n:
	 *            An integer
	 * @return: An integer
	 */
	public int climbStairs(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int a = 1;
		int b = 2;

		int tmp;
		while (n > 2) {
			tmp = b;
			b = a + b;
			a = tmp;
			n--;
		}

		return b;
	}
}

// 不同的路径 II
class Solution_Ninth_leval_1 {
	/**
	 * @param obstacleGrid:
	 *            A list of lists of integers
	 * @return: An integer
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int[][] path_num = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = 0; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			else
				path_num[i][0] = 1;
		}

		for (int j = 0; j < obstacleGrid[0].length; j++) {
			if (obstacleGrid[0][j] == 1)
				break;
			else
				path_num[0][j] = 1;
		}

		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					path_num[i][j] = 0;
				} else {
					path_num[i][j] = path_num[i - 1][j] + path_num[i][j - 1];
				}
			}
		}

		return path_num[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}