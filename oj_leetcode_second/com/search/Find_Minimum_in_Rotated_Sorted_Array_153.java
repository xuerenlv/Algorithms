package com.search;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {

	public static void main(String[] args) {
		int[] nums = { 3, 1 };
		System.out.println(new Solution_Find_Minimum_in_Rotated_Sorted_Array_153().findMin(nums));
	}

}

class Solution_Find_Minimum_in_Rotated_Sorted_Array_153 {
	public int findMin(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return nums[0];
		}

		int start = 0;
		int end = len - 1;
		while (start < end) {
			if (end - start == 1) { // 只有两个元素时
				return Math.min(nums[start], nums[end]);
			}
			int mid = (start + end) / 2;
			if (nums[start] < nums[end]) {
				return nums[start];
			} else {
				if (nums[mid] >= nums[start]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		return nums[start];
	}
}