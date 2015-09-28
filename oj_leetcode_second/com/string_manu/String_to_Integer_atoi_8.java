package com.string_manu;

public class String_to_Integer_atoi_8 {

	public static void main(String[] args) {
		// System.out.println(new
		// Solution_String_to_Integer_atoi_8().myAtoi("-0012a21"));
		//
		// System.out.println(new
		// Solution_String_to_Integer_atoi_8().myAtoi("2147483648"));
		// System.out.println(new
		// Solution_String_to_Integer_atoi_8().myAtoi("10522545459"));

		// System.out.println(new
		// Solution_String_to_Integer_atoi_8().myAtoi("-1123u3761867"));
		// System.out.println(new
		// Solution_String_to_Integer_atoi_8().myAtoi("-1010023630o4"));

		System.out.println(new Solution_String_to_Integer_atoi_8().myAtoi("+10523538441s"));
	}

}

class Solution_String_to_Integer_atoi_8 {
	/*
	 * 问题：将字符窜转换成数字 分析：感觉题目不难，但是细节很多，容易想不到 1.数字前面有空格 如s=“ 123456”
	 * 2.数字前出现了不必要或多于的字符导致数字认证错误，输出0 如s=“ b1234” ，s=“ ++1233” , s=“ +-1121”
	 * 3.数字中出现了不必要的字符，返回字符前的数字 如s=“ 12a12” ， s=“ 123 123” 4.数字越界
	 * 超过了范围（-2147483648--2147483647) 若超过了负数的 输出-2147483648 超过了正数的输出2147483647
	 * 在科普一个知识点，倘若某个数超过了2147483647则会变为负数，反过来一样
	 */
	public int myAtoi(String str) {
		str = str.trim(); // 去除字符串两边的空格
		if (str.isEmpty())
			return 0;
		if (str.charAt(0) == '-' && str.length() == 1)
			return 0;
		if (str.charAt(0) == '+' && str.length() == 1)
			return 0;
		if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) < '0' || str.charAt(0) > '9'))
			return 0;

		int signal;
		if (str.charAt(0) == '+' || (str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
			signal = 1;
		} else {
			signal = -1;
		}

		int sum = 0;
		int length = 0; // 统计要计算的字符串的长度
		if (!(str.charAt(0) == '+' || str.charAt(0) == '-')) {
			for (int i = 0; i < str.length(); i++) {
				if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
					break;
				}
				sum = (str.charAt(i) - '0') + sum * 10;
				length++;
			}
		} else {
			for (int i = 1; i < str.length(); i++) {
				if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
					break;
				}
				sum = (str.charAt(i) - '0') + sum * 10;
				length++;
			}
		}

		if (sum < 0 || (length > 10)) {
			if (signal == -1) {
				return -2147483648;
			} else {
				return 2147483647;
			}

		} else {
			return sum * signal;
		}

	}
}
