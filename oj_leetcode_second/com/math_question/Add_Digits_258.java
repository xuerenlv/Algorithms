package com.math_question;

public class Add_Digits_258 {

	public static void main(String[] args) {
		System.out.println(new Solution_Add_Digits_258().addDigits(38));
	}

}

class Solution_Add_Digits_258 {

	// 结果 1到9 的循环出现
	public int addDigits_other_people(int num) {
		return 1 + (num - 1) % 9;
	}

	// 这个也会被accepted，但是没有上面一个优雅
	public int addDigits(int num) {
		if (num < 10)
			return num;
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return addDigits(sum);
	}
}