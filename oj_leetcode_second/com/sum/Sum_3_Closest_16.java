package com.sum;

import java.util.Arrays;

public class Sum_3_Closest_16 {

	public static void main(String[] args) {
		// int[] S = { -1, 2, 1, -4 };
		// int target = 1;

		int[] S = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int target = 82;
		System.out.println(new Solution_Sum_3_Closest_16().threeSumClosest(S, target));

		int[] nums = { 1, 1, -1, -1, 3 };
		int tar = -1;
		System.out.println(new Solution_Sum_3_Closest_16_second().threeSumClosest(nums, tar));
	}
}

class Solution_Sum_3_Closest_16_second {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int small = Integer.MAX_VALUE / 2; // 除以2，是为了放置越界
		int sum;
		for (int i = 0; i <= nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				sum = nums[i] + nums[start] + nums[end];
				small = Math.abs(sum - target) < Math.abs(small - target) ? sum : small;
				if (sum > target) {
					end--;
				} else {
					start++;
				}
			}
		}
		return small;
	}
}

class Solution_Sum_3_Closest_16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		int index = 0;
		int min_closet_target = Integer.MAX_VALUE / 2;
		while (index < len) {
			if (min_closet_target != Integer.MAX_VALUE && index > 0 && nums[index] == nums[index - 1]) {
				index++;
				continue;
			}
			int front = index + 1;
			int tail = len - 1;
			while (front < tail) {
				int sum = nums[front] + nums[tail] + nums[index];

				if (sum == target) {
					return target;
				} else if (sum < target) {
					int gap = target - sum;
					if (Math.abs(target - min_closet_target) > gap)
						min_closet_target = target - gap;
					++front;
				} else {
					int gap = sum - target;
					if (Math.abs(target - min_closet_target) > gap)
						min_closet_target = target + gap;
					tail--;
				}
			}
			index++;
		}

		return min_closet_target;
	}
}