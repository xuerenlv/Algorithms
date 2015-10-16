package com.array_question;

public class Jump_Game_55 {

	public static void main(String[] args) {
		int[] nums_1 = { 2, 9, 1, 2, 4 };
		int[] nums_2 = { 3, 0, 0, 0, 0 };

		System.out.println(new Solution_Jump_Game_55().canJump_1(nums_1));
		System.out.println(new Solution_Jump_Game_55().canJump_1(nums_2));
	}

}

class Solution_Jump_Game_55 {

	// 因为最后只是对于，最后一个位置与0进行比较，进行返回
	// 所以这里就可以不用存储所有的值
	public boolean canJump_3(int[] nums) {
		if (nums.length <= 1)
			return true;

		int pre = nums[0], cur = 0;
		for (int i = 1; i < nums.length; i++) {
			cur = Math.max(pre, nums[i - 1]) - 1;
			if (cur < 0)
				return false;
			pre = cur;
		}

		return cur >= 0;
	}

	// 用数组记录还可以走多远
	// 从前向后进行遍历，有一点greedy的思想
	public boolean canJump_2(int[] nums) {
		if (nums.length <= 1)
			return true;
		int[] can_walk = new int[nums.length];
		can_walk[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			// 只和前一个的大小有关，最后一个大小是无意义的
			can_walk[i] = Math.max(can_walk[i - 1], nums[i - 1]) - 1;
			if (can_walk[i] < 0)
				return false;
		}

		return can_walk[nums.length - 1] >= 0;
	}

	// Time Limit Exceeded
	// 思路很明显的方法
	// 对于数组，从后向前遍历，加上一个纪录，很normal的一个想法
	// 这里就需要纪录以前生成的值，因为里面一个循环，要用到以前生成的值
	public boolean canJump_1(int[] nums) {
		if (nums.length <= 1)
			return true;
		boolean[] jihao = new boolean[nums.length - 1]; // 纪录当前位置是否可以到达last节点

		if (nums[0] >= nums.length - 1)
			return true;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] >= nums.length - i - 1) {
				jihao[i] = true;
			} else {
				int j;
				for (j = 1; j <= nums[i]; j++) { // 因为上面已经测试了nums[i]的大小，所以这一步不会发生溢出
					if (jihao[i + j]) {
						jihao[i] = true;
						break;
					}
				}
				if (j > nums[i])
					jihao[i] = false;
			}
		}

		return jihao[0];
	}
}