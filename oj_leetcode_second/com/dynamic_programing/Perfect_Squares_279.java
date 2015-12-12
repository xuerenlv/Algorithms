package com.dynamic_programing;

public class Perfect_Squares_279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Perfect_Squares_279 {
	// dynamic prgraming
	public int numSquares(int n) {
		int[] d = new int[n + 1];
		d[1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (j * j <= i) {
				if (j * j == i) {// min为1是最小值，所以可以跳出循环
					min = 1;
					break;
				}
				min = Math.min(min, d[i - j * j] + 1);
				j++;
			}
			d[i] = min;
		}
		return d[n];
	}
}