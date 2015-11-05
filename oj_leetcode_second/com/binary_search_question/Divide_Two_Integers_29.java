package com.binary_search_question;

public class Divide_Two_Integers_29 {

	public static void main(String[] args) {
		System.out.println(new Solution_Divide_Two_Integers_29().divideLong(23, 9));
	}

}

class Solution_Divide_Two_Integers_29 {

	public int divide_2(int dividend, int divisor) {
		long result = divideLong(dividend, divisor);
		return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
	}

	public long divideLong(long dividend, long divisor) {
		boolean negative = dividend < 0 != divisor < 0; // 不同号，则为负
		if (dividend < 0)
			dividend = -dividend;
		if (divisor < 0)
			divisor = -divisor;

		if (dividend < divisor)
			return 0;

		// 这里有一种算幂次的思想，应该是同样的思想
		long sum = divisor;
		long divide = 1;
		while ((sum + sum) <= dividend) {
			sum += sum;
			divide += divide;
		}

		return negative ? -(divide + divideLong((dividend - sum), divisor))
				: (divide + divideLong((dividend - sum), divisor));
	}

	// 这个用了除法
	public int divide(int dividend, int divisor) {
		if (dividend < 0 && divisor < 0) {
			if (dividend / divisor < 0) {
				return Integer.MAX_VALUE;
			}
		}
		if (dividend > 0 && divisor > 0) {
			if (dividend / divisor < 0) {
				return Integer.MAX_VALUE;
			}
		}
		return dividend / divisor;
	}
	/*
	 * int divide(int dividend, int divisor) { if (!divisor || (dividend ==
	 * INT_MIN && divisor == -1)) return INT_MAX; long long dvd =
	 * labs(dividend); long long dvs = labs(divisor); int sign = (dividend > 0)
	 * ^ (divisor > 0) ? -1 : 1; int res = 0; while (dvd >= dvs) { long long tmp
	 * = dvs, multiple = 1; while (dvd >= (tmp << 1)) { tmp <<= 1; multiple <<=
	 * 1; } dvd -= tmp; res += multiple; } return sign * res; }
	 */
}