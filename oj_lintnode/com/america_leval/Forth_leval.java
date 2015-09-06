package com.america_leval;

public class Forth_leval {

	public static void main(String[] args) {
		System.out.println(1 ^ -1);
	}

}

// 不同的路径
class Solution_Forth_leval_3 {
	/**
	 * @param n,
	 *            m: positive integer (1 <= n ,m <= 100)
	 * @return an integer
	 */
	public int uniquePaths(int m, int n) {
		
	}
}

// O(1)检测2的幂次
class Solution_Forth_leval_2 {
	/*
	 * @param n: An integer
	 * 
	 * @return: True or false
	 */
	public boolean checkPowerOf2(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}
};

// 将整数A转换为B
class Solution_Forth_leval_1 {
	/**
	 * @param a,
	 *            b: Two integer return: An integer
	 */
	public static int bitSwapRequired(int a, int b) {
		int s = a ^ b;
		int count = 0;
		while (s != 0) {
			if ((s & 1) == 1)
				count++;
			// 无符号右移
			s = s >>> 1;
		}
		return count;
	}
};
