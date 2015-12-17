package com.binary_search_question;

public class Find_the_Duplicate_Number_287 {

	public static void main(String[] args) {

	}

}

class Solution_Find_the_Duplicate_Number_287 {
	// 感觉就是求链表环的起点
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1)
			return -1;
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}