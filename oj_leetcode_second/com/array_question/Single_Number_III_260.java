package com.array_question;

public class Single_Number_III_260 {

	public static void main(String[] args) {
		int xor = 3 ^ 5;
		System.out.println(xor);
		System.out.println(xor & -xor);
		System.out.println(xor & -xor);
	}

}

class Solution_Single_Number_III_260 {
	public int[] singleNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++)
			xor ^= nums[i];
		int mask = xor & (-xor);// 取这个数中bit位的第一个1

		int a = 0;
		int b = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & mask) != 0) {
				a ^= nums[i];
			} else {
				b ^= nums[i];
			}
		}

		return new int[] { a, b };
	}
}