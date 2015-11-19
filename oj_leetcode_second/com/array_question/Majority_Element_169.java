package com.array_question;

import java.util.Arrays;

public class Majority_Element_169 {

	public static void main(String[] args) {

	}

}

class Solution_Majority_Element_169 {

	public int majorityElement_2(int[] num) {
		Arrays.sort(num);
		return num[num.length / 2];
	}

	public int majorityElement(int[] nums) {
		int val = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == val) {
				count++;
			} else {
				count--;
				if (count < 0) {
					count = 1;
					val = nums[i];
				}
			}
		}

		// count = 0;
		// for (int i = 0; i < nums.length; i++) {
		// if (nums[i] == val) {
		// count++;
		// }
		// }
		// return count >= (nums.length / 2) ? count : 0;

		return val;
	}
}