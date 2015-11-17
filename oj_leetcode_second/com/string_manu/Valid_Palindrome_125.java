package com.string_manu;

public class Valid_Palindrome_125 {

	public static void main(String[] args) {
		// Character ch = new Character('A');
		// Character cha = new Character('A');
		// System.out.println(Character.toLowerCase(ch) ==
		// Character.toLowerCase(cha));

		// char s1 = '8';
		// System.out.println((s1>='0' && s1<='9'));

		String s = "1a2";
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		System.out.println(new Solution_Valid_Palindrome_125().isPalindrome(s1));
		System.out.println(new Solution_Valid_Palindrome_125().isPalindrome(s2));
		System.out.println(new Solution_Valid_Palindrome_125().isPalindrome(s));
	}

}

class Solution_Valid_Palindrome_125 {

	// *********************************************************************************************

	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char s1 = s.charAt(i);
			if (s1 == ' ' || !((s1 >= 'A' && s1 <= 'Z') || (s1 >= 'a' && s1 <= 'z') || (s1 >= '0' && s1 <= '9'))) {
				i++;
				continue;
			}
			char s2 = s.charAt(j);
			if (s2 == ' ' || !((s2 >= 'A' && s2 <= 'Z') || (s2 >= 'a' && s2 <= 'z') || (s2 >= '0' && s2 <= '9'))) {
				j--;
				continue;
			}

			if (Character.toLowerCase(s1) == Character.toLowerCase(s2)) {
				i++;
				j--;
			} else {
				return false;
			}

		}

		return true;

	}
}