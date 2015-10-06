package com.array_question;

public class Maximum_Subarray_53 {

	public static void main(String[] args) {
		// int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] nums = { -84, -87, -78, -16, -94, -36, -87, -93, -50, -22, -63, -28, -91, -60, -64, -27, -41, -27, -73 };

		System.out.println(new Solution_Maximum_Subarray_53().maxSubArray(nums));
		System.out.println(new Solution_Maximum_Subarray_53().maxSubArray_overtime(nums));
	}

}

class Solution_Maximum_Subarray_53 {
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = nums[0];

		// 前面取得所有数之中加上我自身，如果比我自身大，那就要，否则不如不要，因为它让我变小
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}

	// Time Limit Exceeded
	public int maxSubArray_overtime(int[] nums) {
		int[] get = new int[1];
		get[0] = Integer.MIN_VALUE;
		max_in(nums, 0, nums.length - 1, get);
		return get[0];
	}

	void max_in(int[] nums, int start, int end, int[] get) {
		if (start > end)
			return;
		if (start < 0 || end > nums.length - 1)
			return;

		while (start < end) {
			int souyi = 0;
			for (int k = start; k <= end; k++) {
				souyi += nums[k];
			}
			get[0] = Math.max(get[0], souyi);

			if (nums[start] > nums[end]) {
				end--;
			} else if (nums[start] > nums[end]) {
				start++;
			} else {
				int s = start++;
				int e = end--;
				max_in(nums, s, end, get);
				max_in(nums, start, e, get);
			}
		}

	}
}