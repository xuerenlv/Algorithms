package com.math_question;

public class Pow_x_n_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Pow_x_n_50 {
	public double myPow(double base, int exp) {
		if (equal(base, 0.0) && exp < 0) {
			return 0.0;
		}
		if (equal(base, 1.0)) {
			return 1.0;
		}
		int abs_exp = exp < 0 ? -1 * exp : exp;
		if (equal(base, -1.0)) {
			if ((abs_exp & 1) == 0) {
				return 1.0;
			} else {
				return -1.0;
			}
		}
		double re = pow_with_unsigned_exp(base, abs_exp);

		if (exp < 0) {
			return 1.0 / re;
		} else {
			return re;
		}
	}

	double pow_with_unsigned_exp(double base, int exp) {
		double re = 1.0;
		if (exp == 0) {
			return 1.0;
		}
		if (exp == 1) {
			return base;
		}
		re = pow_with_unsigned_exp(base, exp >> 1);
		re *= re;
		if ((exp & 1) == 1) {
			re *= base;
		}
		return re;
	}

	boolean equal(double num1, double num2) {
		if (num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001) {
			return true;
		} else {
			return false;
		}
	}
}