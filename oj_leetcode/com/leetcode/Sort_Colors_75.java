package com.leetcode;

public class Sort_Colors_75 {

	public static void main(String[] args) {
		int[] nums = {1};
		new Solution_Sort_Colors_75().sortColors(nums);
	}

}

class Solution_Sort_Colors_75 {
	public void sortColors(int[] nums) {
		int count_0 = 0;
		int count_1 = 0;
		int count_2 = 0;
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case 0:
				count_0++;
				break;
			case 1:
				count_1++;
				break;
			case 2:
				count_2++;
				break;
			}
		}

		for (int i = 0; i < count_0; i++) {
			nums[i] = 0;
		}

		for (int i = count_0; i < count_0+count_1; i++) {
			nums[i] = 1;
		}
		for (int i = count_0+count_1; i < count_0+count_1+count_2; i++) {
			nums[i] = 2;
		}

	}
}