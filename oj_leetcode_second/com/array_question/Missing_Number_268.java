package com.array_question;

public class Missing_Number_268 {

	public static void main(String[] args) {

	}

}

class Solution_Missing_Number_268 {
	public int missingNumber(int[] nums) {
		int n = (1 + nums.length) * nums.length / 2;
		for (int i = 0; i < nums.length; i++) {
			n -= nums[i];
		}
		return n;
	}
}