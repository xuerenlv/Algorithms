package com.string_manu;

public class ZigZag_Conversion_6 {

	public static void main(String[] args) {
		// System.out.println(new
		// Solution_ZigZag_Conversion_6().convert("PAYPALISHIRING", 3));
		System.out.println(new Solution_ZigZag_Conversion_6().convert("A", 1));
	}

}

class Solution_ZigZag_Conversion_6 {
	public String convert(String s, int numRows) {
		String[] h_strs = new String[numRows];
		for (int i = 0; i < h_strs.length; i++)
			h_strs[i] = "";

		if (numRows < 3) {
			if (numRows == 1)
				return s;
			if (numRows == 2) {
				int j = 0;
				for (int i = 0; i < s.length(); i++) {
					j = i % 2;
					h_strs[j] += s.charAt(i);
				}
				String re = "";
				for (int i = 0; i < h_strs.length; i++) {
					re += h_strs[i];
				}
				return re;
			}
		}

		int j;
		int i = 0;
		while (i < s.length()) {
			int jishu = i % (2 * numRows - 2);
			if (jishu > numRows - 1) {
				j = 2 * numRows - 2 - jishu;
			} else {
				j = jishu % numRows;
			}
			h_strs[j] = h_strs[j] + s.charAt(i);
			i++;
		}

		String re = "";
		for (i = 0; i < h_strs.length; i++) {
			re += h_strs[i];
		}
		return re;
	}
}