package com.search;

public class Search_Insert_Position_35 {

	public static void main(String[] args) {
		// [1,3,5,6], 5 → 2
		// [1,3,5,6], 2 → 1
		// [1,3,5,6], 7 → 4
		// [1,3,5,6], 0 → 0
		int[] arr = { 1, 3, 5, 6 };
		System.out.println(new Solution_Search_Insert_Position_35().searchInsert(arr, 5));
		System.out.println(new Solution_Search_Insert_Position_35().searchInsert(arr, 2));
		System.out.println(new Solution_Search_Insert_Position_35().searchInsert(arr, 7));
		System.out.println(new Solution_Search_Insert_Position_35().searchInsert(arr, 0));

		int[] arr1 = { 1, 3 };
		System.out.println(new Solution_Search_Insert_Position_35().searchInsert(arr1, 3));
	}

}

class Solution_Search_Insert_Position_35 {

	public int searchInsert(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		int mid = 0;
		while (i <= j) {
			mid = (i + j) / 2;
			// System.out.println(i+" "+j +" "+target +" "+nums[i]+" "+nums[j]);
			// 当只剩下两个元素时，进行特别处理
			if (j - i <= 1) {
				if (target > nums[i] && target < nums[j])
					return i + 1;
				if (target <= nums[i])
					return i;
				if (target > nums[j])
					return j + 1;
				if (target == nums[j])
					return j;
			}

			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				i = mid;
			} else {
				j = mid;
			}

		}

		return i;
	}
}