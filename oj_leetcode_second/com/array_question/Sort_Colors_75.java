package com.array_question;

public class Sort_Colors_75 {

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		new Solution_Sort_Colors_75().sortColors_two_pointer(nums);
	}

}

class Solution_Sort_Colors_75 {

	// 这个玩意还是经常用的，在快速排序，和其他一些地方，都有运用
	public void sortColors_two_pointer(int[] nums) {
		int start_count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (start_count != i) {
					nums[i] = nums[start_count];
					nums[start_count] = 0;
				}
				start_count++;
			}
		}
		int end_count = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 2) {
				if (i != end_count) {
					nums[i] = nums[end_count];
					nums[end_count] = 2;
				}
				end_count--;
			}
		}

	}

	// 1 用三个常量来记录三种颜色出现地次数
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

		for (int i = count_0; i < count_0 + count_1; i++) {
			nums[i] = 1;
		}
		for (int i = count_0 + count_1; i < count_0 + count_1 + count_2; i++) {
			nums[i] = 2;
		}

	}
}