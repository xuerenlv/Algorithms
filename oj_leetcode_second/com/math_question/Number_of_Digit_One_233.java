package com.math_question;

public class Number_of_Digit_One_233 {

	public static void main(String[] args) {

	}

}

class Solution_Number_of_Digit_One_233 {

	// 有意思，但是还没有理解
	public int countDigitOne_2(int n) {
		int remain;
		int acc = 0;
		int numIndex = 0;
		int factor = 1;
		int count = 0;
		while (n > 0) {
			remain = n % 10;
			n /= 10;
			if (remain == 1)
				count += numIndex + acc + 1;
			else if (remain > 1)
				count += remain * numIndex + factor;
			acc += remain * factor;
			numIndex += 9 * numIndex + factor;
			factor *= 10;
		}

		return count;
	}

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