package com.math_question;

public class Factorial_Trailing_Zeroes_172 {

	public static void main(String[] args) {

	}

}

class Solution_Factorial_Trailing_Zeroes_172 {
	// 也就是因子为 5 ，的个数
	public int trailingZeroes_2(int n) {
		int ret = 0;
		while (n != 0) {
			ret += n / 5;
			n /= 5;
		}
		return ret;
	}

	// 超时
	public int trailingZeroes_1(int n) {
		if (n == 0) {
			return 1;
		}

		int mul = 1;
		for (int i = 1; i < n; i++) {
			mul *= i;
		}

		int count = 0;
		while (mul != 0 && mul % 10 == 0) {
			count++;
			mul /= 10;
		}

		return count;
	}
}