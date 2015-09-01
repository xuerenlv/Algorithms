package com.leetcode;

public class Minimum_Size_Subarray_Sum_209 {

	public static void main(String[] args) {
		int[] nums = {4,3,1,2,1,2,1};
		System.out.println(new Solution_Minimum_Size_Subarray_Sum_209().minSubArrayLen(7, nums));
	}

}

class Solution_Minimum_Size_Subarray_Sum_209 {
	public int minSubArrayLen(int s, int[] nums) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int min_window = Integer.MAX_VALUE;
		while (start < nums.length && end < nums.length) {
			while (sum < s && end < nums.length) {
				sum += nums[end++];
			}
			while (sum >= s && start <= end) {
				min_window = Math.min(min_window, end - start);
				sum -= nums[start++];
			}
		}
		return min_window == Integer.MAX_VALUE ? 0 : min_window;
	}
}