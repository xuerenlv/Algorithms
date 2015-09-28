package com.math_question;

public class Palindrome_Number_9 {

	public static void main(String[] args) {
		System.out.println(new Solution_Palindrome_Number_9().isPalindrome(111));
	}

}

class Solution_Palindrome_Number_9 {
	// 判断一个数字是不是回文，不用额外空间
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int i = 1000000000;
		int j = 10;
		while (i >= j) {
			if (x / i == 0) {
				i = i / 10;
			} else {
				// (x / i) % 10 从高位向低位，取最后一个数字
				// (x % j) / (j / 10) 从低位向高位，取第一个数字
				if ((x / i) % 10 != (x % j) / (j / 10)) {
					return false;
				} else {
					i /= 10;
					j *= 10;
				}
			}
		}
		return true;
	}
}