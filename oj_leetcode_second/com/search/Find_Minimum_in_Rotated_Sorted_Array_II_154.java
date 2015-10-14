package com.search;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {

	public static void main(String[] args) {
		int[] nums = { 3, 3, 1, 3, 3, 3, 3 };
		System.out.println(new Solution_Find_Minimum_in_Rotated_Sorted_Array_II_154().findMin(nums));
	}

}

class Solution_Find_Minimum_in_Rotated_Sorted_Array_II_154 {
	public int findMin(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return nums[0];
		}
		int st = 0;
		int end = len - 1;

		while (st < end) {
			if (end - st == 1) {
				return Math.min(nums[st], nums[end]);
			}
			// 当start所指元素与end所指元素相同时
			if (nums[st] == nums[end]) {
				end--;
				continue;
			}
			int mid = (st + end) / 2;
			if (nums[st] < nums[end]) {
				return nums[st];
			} else {
				if (nums[mid] >= nums[st]) {
					st = mid;
				} else {
					end = mid;
				}
			}
		}

		return nums[st];
	}
}