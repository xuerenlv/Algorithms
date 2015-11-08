package com.dynamic_programing;

public class Scramble_String_87 {

	public static void main(String[] args) {

		System.out.println(new Solution_Scramble_String_87().isScramble("abc", "bca"));
		System.out.println(new Solution_Scramble_String_87().isScramble("great", "rgtae"));

	}

}

class Solution_Scramble_String_87 {
	// 使用递归，很慢
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		int len = s1.length();
		int len2 = s2.length();
		if (len != len2)
			return false;

		int[] count = new int[26];
		for (int i = 0; i < len; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		// 遍历可能，存在一个成立即返回true
		for (int i = 1; i <= len - 1; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i, len), s2.substring(i, len)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(len - i, len))
					&& isScramble(s1.substring(i, len), s2.substring(0, len - i)))
				return true;
		}
		return false;
	}
}