package com.math_question;

public class Bitwise_AND_of_Numbers_Range_201 {

	public static void main(String[] args) {

		System.out.println(5 & 7);
		System.out.println(new Solution_Bitwise_AND_of_Numbers_Range_201().rangeBitwiseAnd_accepted(5, 7));
	}

}

class Solution_Bitwise_AND_of_Numbers_Range_201 {
	// Time Limit Exceeded
	public int rangeBitwiseAnd_overtime(int m, int n) {
		int sum = m;
		for (int i = m + 1; i < n + 1; i++) {
			sum = sum & i;
		}
		return sum;
	}

	// 没懂，应该和m是递增到n有关
	// m n 共同的前缀
	public int rangeBitwiseAnd_accepted(int m, int n) {
		int offset = 0;
		while (m != 0 && n != 0) {
			if (m == n) {
				// System.out.println(m + " " + offset);
				return m << offset;
			}
			m >>= 1;
			n >>= 1;
			offset++;
		}

		return 0;
	}
}