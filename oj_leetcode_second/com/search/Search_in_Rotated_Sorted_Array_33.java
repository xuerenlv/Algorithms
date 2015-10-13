package com.search;

public class Search_in_Rotated_Sorted_Array_33 {

	public static void main(String[] args) {
		int[] nums = { 6, 7, 8, 1, 3, 5 };
		int target = 5;
		System.out.println(new Solution_Search_in_Rotated_Sorted_Array_33().search(nums, target));
	}

}

class Solution_Search_in_Rotated_Sorted_Array_33 {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid =  (right + left) >> 1;
			if (nums[mid] == target)
				return mid;
			if (nums[left] < nums[mid]) {
				if (target <= nums[mid] && target >= nums[left])
					right = mid - 1;
				else
					left = mid + 1;
			} else if (nums[left] > nums[mid]) {
				if (target >= nums[left] || target <= nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else
				left++;
		}
		return -1;
	}
}