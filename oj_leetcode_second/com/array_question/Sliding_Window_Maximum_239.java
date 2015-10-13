package com.array_question;

import java.util.LinkedList;

public class Sliding_Window_Maximum_239 {

	public static void main(String[] args) {

	}

}

class Solution_Sliding_Window_Maximum_239 {

	// 挺有技巧的，一遍遍历即可，用一个 双向链表（因为经常增删）
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] re = new int[0];
		if (nums == null || n == 0 || k == 0)
			return re;

		LinkedList<Integer> list_index = new LinkedList<>();
		re = new int[n - k + 1];
		for (int i = 0; i < n; i++) {
			// left i right i+k-1
			while (!list_index.isEmpty() && nums[i] >= nums[list_index.getLast()]) {
				list_index.removeLast();
			}
			list_index.add(i);

			// 对头元素的位置进行控制
			if (i - list_index.getFirst() + 1 > k) {
				list_index.removeFirst();
			}

			if (i + 1 >= k)
				re[i - k + 1] = nums[list_index.getFirst()];
		}

		return re;
	}

	// naive
	public int[] maxSlidingWindow_naive(int[] nums, int k) {
		int n = nums.length;
		int[] re = new int[0];
		if (nums == null || n == 0 || k == 0)
			return re;

		re = new int[n - k + 1];
		int index;
		for (int i = 0; i < re.length; i++) {
			// left i right i+k-1
			index = i; // 用于纪录最大值的位置
			for (int j = i + 1; j <= i + k - 1; j++) {
				if (nums[j] > nums[index])
					index = j;
			}
			re[i] = nums[index];
		}

		return re;
	}
}