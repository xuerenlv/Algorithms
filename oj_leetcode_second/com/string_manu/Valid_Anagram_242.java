package com.string_manu;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram_242 {

	public static void main(String[] args) {

	}

}

class Solution_Valid_Anagram_242 {

	// 挺聪明的做法，因为只有26个字母，所以开一个数组就可以了
	public boolean isAnagram_2(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}

	// 用两个map纪录字符串的特征
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;

		HashMap<Character, Integer> s_map = new HashMap<>();
		HashMap<Character, Integer> t_map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char s_ch = s.charAt(i);
			char t_ch = t.charAt(i);

			if (!s_map.containsKey(s_ch)) {
				s_map.put(s_ch, 1);
			} else {
				s_map.put(s_ch, s_map.get(s_ch) + 1);
			}
			if (!t_map.containsKey(t_ch)) {
				t_map.put(t_ch, 1);
			} else {
				t_map.put(t_ch, t_map.get(t_ch) + 1);
			}
		}
		if (s_map.size() != t_map.size())
			return false;

		for (Map.Entry<Character, Integer> entry : s_map.entrySet()) {
			char s_ch = entry.getKey();
			int s_val = entry.getValue();
			if (!(t_map.containsKey(s_ch) && t_map.get(s_ch) == s_val))
				return false;
		}
		return true;
	}
}