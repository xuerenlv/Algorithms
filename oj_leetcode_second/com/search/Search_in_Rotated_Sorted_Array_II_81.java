package com.search;

public class Search_in_Rotated_Sorted_Array_II_81 {

	public static void main(String[] args) {

	}

}

class Solution_Search_in_Rotated_Sorted_Array_II_81 {
	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] == target)
				return true;
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
		return false;
	}
}