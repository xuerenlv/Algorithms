package com.leetcode;

public class Sqrt_x__69 {

	public static void main(String[] args) {

	}

}

class Solution_Sqrt_x__69 {
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