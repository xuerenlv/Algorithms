package com.dynamic_programing;

public class House_Robber_198 {
	/*
	 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the
	 * only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will
	 * automatically contact the police if two adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
	 * you can rob tonight without alerting the police
	 */
	public static void main(String[] s) {
		// int[] nums={1,21,43,66,88,122,43,1,2,12,46,768,7,57,87,2,1,21,21,32,43,43,5,43,23,6,5,6,4674,767,233,58};
		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		long s1 = System.currentTimeMillis();
		System.out.println(rob(nums));
		long s2 = System.currentTimeMillis();
		System.out.println(rob_my(nums));
		long s3 = System.currentTimeMillis();
		System.out.println((s2 - s1) + " <> " + (s3 - s2));
	}

	// accepted 自低向上
	public static int rob(int[] nums) {
		if (nums.length <= 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int r[] = new int[nums.length];
		r[0] = nums[0];
		r[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			r[i] = Math.max(r[i - 2] + nums[i], r[i - 1]);
		}
		return r[nums.length - 1];
	}

	// 使用递归，超时
	// 虽然也是使用记录，但是自顶向下，还是不行
	public static int rob_my(int[] nums) {
		int r[] = new int[nums.length + 1];
		return rob_n(nums, nums.length, r);
	}
	public static int rob_n(int[] nums, int n, int[] r) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return nums[0];
		if (r[n] > 0)
			return r[n];

		int i, j;
		if ((i = nums[n - 1] + rob_n(nums, n - 2, r)) > (j = rob_n(nums, n - 1, r))) {
			r[n] = i;
			return i;
		} else {
			r[n] = j;
			return j;
		}
	}

}
