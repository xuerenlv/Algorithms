package com.dynamic_programing;

import java.util.HashMap;
import java.util.Map;

public class House_Robber_II_213 {

	public static void main(String[] args) {
		int[] nums = { 1, 7, 9, 2 };
		System.out.println(new Solution_House_Robber_II_213().rob(nums));
	}

}

class Solution_House_Robber_II_213 {
	// 把一个环，按它讲的条件，切成两个单链
	public int rob(int[] nums) {
		int len = nums.length;
		if (len <= 0)
			return 0;
		if (len == 1)
			return nums[0];

		return Math.max(rob_start_to_end(nums, 0, len - 2), rob_start_to_end(nums, 1, len - 1));
	}

	int rob_start_to_end(int[] nums, int start, int end) {
		int len = end - start;
		if (len < 0)
			return 0;
		if (len == 0)
			return nums[start];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(start, nums[start]);
		map.put(start + 1, Math.max(nums[start], nums[start + 1]));
		for (int i = 2; i < len + 1; i++) {
			map.put(start + i, Math.max(map.get(i - 2 + start) + nums[i + start], map.get(i - 1 + start)));
		}
		return map.get(end);
	}

}