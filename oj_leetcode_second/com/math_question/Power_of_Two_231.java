package com.math_question;

public class Power_of_Two_231 {

	public static void main(String[] args) {
		System.out.println(new Solution_Power_of_Two_231().isPowerOfTwo(-2));
	}

}

class Solution_Power_of_Two_231 {
	// 若为2的高次方，则所有的位中只有一个为1
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) // 防止负数造成的影响
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