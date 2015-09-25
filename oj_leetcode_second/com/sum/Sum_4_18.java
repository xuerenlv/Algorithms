package com.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_4_18 {

	public static void main(String[] args) {
		int[] nums = { 0, 2, 2, 4, 4, 4 };
		int ter = 12;

		// List<List<Integer>> re = new Solution_Sum_4_18().fourSum(nums, ter);

		List<List<Integer>> re = new Solution_Sum_4_18_second().fourSum(nums, ter);

		for (int i = 0; i < re.size(); i++) {
			System.out.println(Arrays.toString(re.get(i).toArray()));
		}
	}

}

class Solution_Sum_4_18_second {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return re;

		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 4; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			for (int k = i + 1; k <= nums.length - 3; k++) {
				int start = k + 1;
				int end = nums.length - 1;
				while (start < end) {
					int sum = nums[start] + nums[end] + nums[i] + nums[k];
					if (sum == target) {
						List<Integer> item = new ArrayList<Integer>();
						item.add(nums[i]);
						item.add(nums[k]);
						item.add(nums[start]);
						item.add(nums[end]);
						if (!re.contains(item)) {
							re.add(item);
						}
						start++;
						end--;
					} else if (sum > target) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return re;
	}
}

class Solution_Sum_4_18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return re;

		Arrays.sort(nums);
		// System.out.println(Arrays.toString(nums));

		int index = 0;
		while (index < nums.length - 3) {
			if (index > 0 && nums[index] == nums[index - 1]) {
				index++;
				continue;
			}
			int index_1 = index + 1;
			while (index_1 < nums.length - 2) {
				int front = index_1 + 1;
				int tail = nums.length - 1;
				while (front < tail) {
					// System.out.println(nums[index]+" "+nums[index_1]+"
					// "+nums[front]+" "+nums[tail]);
					if (nums[front] + nums[tail] == (nums[index] + nums[index_1]) * (-1) + target) {
						List<Integer> item = new ArrayList<Integer>();
						item.add(nums[index]);
						item.add(nums[index_1]);
						item.add(nums[front]);
						item.add(nums[tail]);

						if (!re.contains(item)) {
							re.add(item);
						}
						front++;
						tail--;
					} else if (nums[front] + nums[tail] < (nums[index] + nums[index_1]) * (-1) + target) {
						front++;
					} else {
						tail--;
					}
				}
				index_1++;

			}
			index++;
		}

		return re;
	}
}