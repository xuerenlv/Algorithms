package com.book.sword_offer;

public class pow_p91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Pow {
	boolean invalid_input = false;

	public Pow() {
	}

	double pow(double base, int exp) {
		invalid_input = false;
		if (equal(base, 0.0) && exp < 0) {
			invalid_input = true;
			return 0.0;
		}

		int abs_exp = exp < 0 ? -1 * exp : exp;
		double re = pow_with_unsigned_exp(base, abs_exp);

		if (exp < 0) {
			return 1.0 / re;
		} else {
			return re;
		}
	}

	double pow_with_unsigned_exp(double base, int exp) {
		double re = 1.0;
//		for (int i = 1; i <= exp; i++) {
//			re *= base;
//		}
		if(exp==0){
			return 1.0;
		}
		if(exp==1){
			return base;
		}
		
		re = pow_with_unsigned_exp(base, exp>>1);
		re *= re;
		if((exp & 1) == 1){
			re*=base;
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