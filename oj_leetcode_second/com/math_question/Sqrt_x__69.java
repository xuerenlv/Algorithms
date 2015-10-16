package com.math_question;

public class Sqrt_x__69 {

	public static void main(String[] args) {

	}

}

class Solution_Sqrt_x__69 {
	// 因为返回int，所以两边进行夹逼即可
	public int sqrt_2(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = x;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}

	// 这里求得的是准确值
	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		double pre;
		double cur = 1;
		do {
			pre = cur;
			cur = x / (2 * pre) + pre / 2.0;
		} while (Math.abs(cur - pre) > 0.00001);
		return (int) cur;
	}

	// 因为在这里开方，返回的是int
	public int mySqrt_overtime(int x) {
		int end = x >> 1;
		int start = x >> 2;
		int mid;
		int temp;
		while (start < end) {
			mid = (start + end) >> 1;
			temp = mid * mid;
			if (temp == x)
				return mid;
			if (temp > x) {
				end--;
			} else {
				start++;
			}
		}

		temp = start * start;
		if (temp > x)
			return end - 1;
		else
			return end;
	}
}