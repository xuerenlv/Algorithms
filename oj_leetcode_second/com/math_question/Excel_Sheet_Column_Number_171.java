package com.math_question;

public class Excel_Sheet_Column_Number_171 {

	public static void main(String[] args) {
		// System.out.println('Z'-'A'+1);
		System.out.println(new Solution_Excel_Sheet_Column_Number_171().titleToNumber("A"));
		System.out.println(new Solution_Excel_Sheet_Column_Number_171().titleToNumber("AA"));
	}

}

class Solution_Excel_Sheet_Column_Number_171 {
	// 实质就是26进制数
	public int titleToNumber(String s) {
		int quan = 1; // 位权
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int ch_i = s.charAt(i) - 'A' + 1;
			sum += ch_i * quan;

			quan *= 26;
		}
		return sum;
	}
}