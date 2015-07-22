package com.leetcode.dp;

public class Jump_Game_II_45 {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 1, 4 };

		System.out.println(new Solution_Jump_Game_II_45().jump(nums));

	}

}

class Solution_Jump_Game_II_45 {

	public int jump(int[] nums) {
		int jump = 0;
		int curMax = 0;
		int curRch = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curRch < i) {
				jump++;
				curRch = curMax;
			}
			curMax = Math.max(curMax, nums[i] + i);
		}
		return jump;
	}

	// Time Limit Exceeded
	public int jump_overtime(int[] nums) {
		if (nums.length <= 1)
			return 0;

		int[] smallest_dis = new int[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] >= nums.length - i - 1) {
				smallest_dis[i] = 1;
				continue;
			}
			int small = Integer.MAX_VALUE;
			for (int j = 1; j <= nums[i]; j++) {
				if (small > smallest_dis[i + j]) {
					small = smallest_dis[i + j];
				}
				if (small == 1) {
					break;
				}
			}
			smallest_dis[i] = small + 1;
		}

		return smallest_dis[0];
	}
}