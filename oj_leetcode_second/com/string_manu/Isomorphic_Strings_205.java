package com.string_manu;

import java.util.HashMap;

public class Isomorphic_Strings_205 {

	public static void main(String[] args) {
		String str1 = "ttthh";
		String str2 = "hhhhh";

		System.out.println(new Solution_Isomorphic_Strings_205().isIsomorphic_accepted(str1, str2));
	}

}

class Solution_Isomorphic_Strings_205 {
	// 判断两个字符串是不是同构，对应位置的字符映射
	public boolean isIsomorphic_accepted(String s, String t) {
		if (s.length() != t.length())
			return false;

		char s_c, t_c;
		HashMap<Character, Character> mapping = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			s_c = s.charAt(i);
			t_c = t.charAt(i);
			if (mapping.containsKey(s_c)) {
				if (mapping.get(s_c).equals(t_c)) {
					continue;
				} else {
					return false;
				}
			} else {
				if (mapping.containsValue(t_c))
					return false;
				mapping.put(s_c, t_c);
			}

			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j) == s_c) {
					if (t.charAt(j) != t_c)
						return false;
				}
			}
		}

		return true;
	}
}