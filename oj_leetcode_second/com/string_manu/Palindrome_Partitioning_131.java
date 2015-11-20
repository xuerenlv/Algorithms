package com.string_manu;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {

	public static void main(String[] args) {
		List<List<String>> re = new Solution_Palindrome_Partitioning_131().partition("cbbbcc");

		for (List<String> in : re) {
			System.out.println(in.toString());
		}
	}

}

class Solution_Palindrome_Partitioning_131 {
	// 其实就是一个回溯法，我感觉回溯法，很像深度优先遍历
	public List<List<String>> partition(String s) {
		List<List<String>> re = new ArrayList<List<String>>();
		List<String> in = new ArrayList<String>();
		par_str(s, 0, s.length(), in, re);
		return re;
	}

	void par_str(String s, int start, int end, List<String> in, List<List<String>> re) {
		if (start == end) {
			re.add(new ArrayList<String>(in));
			return;
		}
		for (int i = start + 1; i <= end; i++) {
			String test = s.substring(start, i);
			if (isPalindrome(test)) {
				in.add(test);
				par_str(s, i, end, in, re);
				in.remove(in.size() - 1);
			}
		}
	}

	boolean isPalindrome(String s) {
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