package com.leetcode.failed;

public class Power_of_Two_231 {

	public static void main(String[] args) {

	}

}

class Solution_Power_of_Two_231 {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n >>= 1;
		}
		return count == 1;
	}
}