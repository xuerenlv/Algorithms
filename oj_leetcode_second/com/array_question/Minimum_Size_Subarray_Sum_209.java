package com.array_question;

public class Minimum_Size_Subarray_Sum_209 {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 1, 2, 1, 2, 1 };
		System.out.println(new Solution_Minimum_Size_Subarray_Sum_209().minSubArrayLen(7, nums));
	}

}

class Solution_Minimum_Size_Subarray_Sum_209 {

	// 也是双指针，很有用，看来双指针不但可以前后夹，也可以一快一慢
	public int minSubArrayLen_2(int s, int[] a) {
		if (a == null || a.length == 0)
			return 0;

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum += a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public int minSubArrayLen(int s, int[] nums) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int min_window = Integer.MAX_VALUE;
		while (end < nums.length) {
			while (sum < s && end < nums.length) {
				sum += nums[end++];
			}
			while (sum >= s && start < end) {
				min_window = Math.min(min_window, end - start);
				sum -= nums[start++];
			}
		}
		return min_window == Integer.MAX_VALUE ? 0 : min_window;
	}
}