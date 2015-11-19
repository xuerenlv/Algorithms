package com.array_question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rotate_Array_189 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		new Solution_Rotate_Array_189().rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

}

class Solution_Rotate_Array_189 {
	// 基于逆置的
	public void rotate_2(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		if (k == 0)
			return;
		inverse(nums, 0, len - k - 1);
		inverse(nums, len - k, len - 1);
		inverse(nums, 0, len - 1);
	}

	private void inverse(int[] nums, int start, int end) {
		int temp;
		while (start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	// 要开辟新空间
	public void rotate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			// 使用一个map用来纪录新位置
			map.put((i + k) % nums.length, nums[i]);
		}
		for (Map.Entry<Integer, Integer> en : map.entrySet()) {
			nums[en.getKey()] = en.getValue();
		}
	}
}