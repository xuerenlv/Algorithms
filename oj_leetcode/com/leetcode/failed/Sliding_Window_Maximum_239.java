package com.leetcode.failed;

public class Sliding_Window_Maximum_239 {

	public static void main(String[] args) {

	}

}

class Solution_Sliding_Window_Maximum_239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] re = new int[0];
		if (nums == null || n == 0 || k == 0)
			return re;

		re = new int[n - k + 1];
		int index = -1;
		for (int i = 0; i < re.length; i++) {
			// left i right i+k-1
			if (index >= i && index <= i + k - 1 && nums[index]>=nums[i + k - 1]) {
				re[i] = nums[i];
			} else {
				if (index < i)
					index = i;
				for (int j = i + 1; j <= i + k - 1; j++) {
					if (nums[j] >= nums[index])
						index = j;
				}
				re[i] = nums[index];
			}
		}

		return re;
	}
}