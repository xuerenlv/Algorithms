package com.array_question;

public class Single_Number_II_137 {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 3 };

		System.out.println(new Solution_Single_Number_II_137().singleNumber(nums));

	}

}

class Solution_Single_Number_II_137 {
	public int singleNumber(int[] nums) {
		int[] number = new int[32];

		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			// 对位进行操作
			for (int j = 0; j < 32; ++j) {
				if ((nums[i] & (1 << j)) != 0) {
					number[j]++;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 32; ++i) {
			if (number[i] % 3 != 0) {
				result += (1 << i);
			}
		}
		return result;
	}
}