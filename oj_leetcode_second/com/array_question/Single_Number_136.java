package com.array_question;

public class Single_Number_136 {

	public static void main(String[] args) {
		System.out.println(1 ^ 2);
		System.out.println(1 ^ 0);
	}

}

class Solution_Single_Number_136 {
	public int singleNumber(int[] nums) {
		int re = 0;

		for (int i = 0; i < nums.length; i++) {
			re ^= nums[i];
		}

		return re;
	}
}