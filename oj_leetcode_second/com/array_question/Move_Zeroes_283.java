package com.array_question;

public class Move_Zeroes_283 {

	public static void main(String[] args) {

	}

}

class Solution_Move_Zeroes_283 {
	public void moveZeroes(int[] nums) {
		int count = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				if (i != index) {
					nums[index] = nums[i];
				}
				index++;
			}
		}
		index = nums.length - 1;
		while (count > 0) {
			nums[index] = 0;
			index--;
			count--;
		}
	}
}