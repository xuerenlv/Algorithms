package com.leetcode;

public class Number_of_Digit_One_233 {

	public static void main(String[] args) {

	}

}

class Solution_Number_of_Digit_One_233 {
	public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10) {
			long a = n / m, b = n % m;
			ones += (a + 8) / 10 * m;
			if (a % 10 == 1)
				ones += b + 1;
		}
		return ones;
	}

}