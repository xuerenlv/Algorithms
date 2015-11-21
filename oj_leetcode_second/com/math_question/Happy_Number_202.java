package com.math_question;

import java.util.ArrayList;

public class Happy_Number_202 {

	public static void main(String[] args) {

		System.out.println(new Solution_Happy_Number_202().isHappy(19));
	}

}

class Solution_Happy_Number_202 {
	// 有种链表求环的，快慢指针的感觉，very bralliant
	public boolean isHappy_2(int n) {
		int x = n;
		int y = n;
		while (x > 1) {
			x = cal(x);
			y = cal(cal(y));
			if (y == 1 || x == 1)
				return true;
			if (x == y)
				return false;
		}
		return true;
	}

	public int cal(int n) {
		int x = n;
		int s = 0;
		while (x > 0) {
			s = s + (x % 10) * (x % 10);
			x = x / 10;
		}
		return s;
	}

	// ************************************************************************************
	// 感觉对大数是没有效果的
	public boolean isHappy(int n) {
		ArrayList<Integer> loop = new ArrayList<Integer>();

		while (true) {
			int power = sum_the_power(n);
			if (loop.contains(power)) {
				if (power == 1)
					return true;
				else
					return false;
			}

			loop.add(power);
			n = power;
		}
	}

	public int sum_the_power(int num) {
		int sum = 0;
		while (num != 0) {
			int digit = num % 10;
			sum += digit * digit;
			num /= 10;
		}
		return sum;
	}
}