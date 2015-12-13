package com.array_question;

import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array_215 {

	public static void main(String[] args) {

	}

}

class Solution_Kth_Largest_Element_in_an_Array_215 {
	public int findKthLargest(int[] nums, int k) {
		int[] k_num = new int[k];

		for (int i = 0; i < k; i++) {
			k_num[i] = nums[i];
		}

		// 这里用的是一个优先级队列的思想
		Arrays.sort(k_num);
		int num;
		for (int i = k; i < nums.length; i++) {
			num = nums[i];
			if (num <= k_num[0])
				continue;
			insert(k_num, num);
		}

		return k_num[0];
	}

	void insert(int[] nums, int num) {
		int len = nums.length;
		nums[0] = num;// 最小值覆盖，然后进行一个排序
		for (int i = 0; i < len - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				swap(nums, i, i + 1);
			}
		}
	}

	void swap(int[] num, int i, int j) {
		int temp;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}