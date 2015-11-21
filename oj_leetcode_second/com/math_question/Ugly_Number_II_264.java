package com.math_question;

public class Ugly_Number_II_264 {

	public static void main(String[] args) {
		System.out.println(new Solution_Ugly_Number_II_264().nthUglyNumber(4));
	}

}

class Solution_Ugly_Number_II_264 {
	// 求第n个 丑数
	public int nthUglyNumber(int n) {
		int[] re = new int[n];
		re[0] = 1;

		int factor_2 = 2;
		int factor_3 = 3;
		int factor_5 = 5;
		int index_2 = 0;
		int index_3 = 0;
		int index_5 = 0;

		int min_val;
		for (int i = 1; i < n; i++) {
			min_val = Math.min(Math.min(factor_2, factor_3), factor_5);
			re[i] = min_val;
			if (min_val == factor_2)
				factor_2 = 2 * re[++index_2];
			if (min_val == factor_3)
				factor_3 = 3 * re[++index_3];
			if (min_val == factor_5)
				factor_5 = 5 * re[++index_5];
		}

		return re[n - 1];
	}
}