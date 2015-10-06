package com.array_question;

public class Product_of_Array_Except_Self_238 {

	public static void main(String[] args) {

	}

}

class Solution_Product_of_Array_Except_Self_238 {
	// 挺有技巧得解法
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];

		// res 里面先存储的是，从右向左乘积
		res[res.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			res[i] = res[i + 1] * nums[i + 1];
		}

		// 从左向右乘积，即可得结果
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] *= left;
			left *= nums[i];
		}
		return res;

	}

	// 比较naive的解法
	public int[] productExceptSelf_Time_Limit_Exceeded(int[] nums) {
		int[] re = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int mult_1 = 1;
			int mult_2 = 1;

			for (int j = 0; j < i; j++) {
				mult_1 *= nums[j];
			}
			for (int j = i + 1; j < nums.length; j++) {
				mult_2 *= nums[j];
			}
			re[i] = mult_1 * mult_2;
		}
		return re;
	}
}