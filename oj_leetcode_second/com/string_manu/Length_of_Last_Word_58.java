package com.string_manu;

public class Length_of_Last_Word_58 {
	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(new Solution_Length_of_Last_Word_58().lengthOfLastWord(s));
	}
}

class Solution_Length_of_Last_Word_58 {
	public int lengthOfLastWord(String s) {
		s = s.trim(); // 去除最后面的空格
		int len = s.length();
		if (len == 0)
			return 0;
		int count = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}
}