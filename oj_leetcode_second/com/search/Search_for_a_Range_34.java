package com.search;

import java.util.Arrays;

public class Search_for_a_Range_34 {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 1, 2, 3 };
		int target = 0;

		int[] re = new Solution_Search_for_a_Range_34().searchRange(nums, target);
		System.out.println(Arrays.toString(re));
	}

}

class Solution_Search_for_a_Range_34 {
	// 因为是在有序数组中查找，所以很正常想到使用二分查找
	public int[] searchRange(int[] nums, int target) {
		int[] re = { -1, -1 };
		int left = 0, right = nums.length - 1, mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			// 就是在找到元素时再进行一次处理
			if (nums[mid] == target) {
				right = mid;
				left = mid;
				while (left >= 0 && nums[left] == target)
					left--;
				while (right < nums.length && nums[right] == target)
					right++;
				re[0] = ++left;
				re[1] = --right;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return re;
	}
}