package com.array_question;

public class Remove_Duplicates_from_Sorted_Array_26 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		System.out.println(new Solution_Remove_Duplicates_from_Sorted_Array_26().removeDuplicates(nums));

	}

}

class Solution_Remove_Duplicates_from_Sorted_Array_26 {
	// 不需要交换，直接进行覆盖即可
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;

		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				nums[count++] = nums[i];
			}
		}
		return count;
	}
}