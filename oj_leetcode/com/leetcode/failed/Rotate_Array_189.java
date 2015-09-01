package com.leetcode.failed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rotate_Array_189 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		new Solution_Rotate_Array_189().rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

}

class Solution_Rotate_Array_189 {
	public void rotate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put((i + k) % nums.length, nums[i]);
		}
		for (Map.Entry<Integer, Integer> en : map.entrySet()) {
			nums[en.getKey()] = en.getValue();
		}
	}
}