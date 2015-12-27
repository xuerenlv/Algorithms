package com.string_manu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Word_Pattern_290 {

	public static void main(String[] args) {

	}

}

class Solution_Word_Pattern_290 {

	// 精简
	public boolean wordPattern_others(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Object, Integer> index = new HashMap<Object, Integer>();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;
	}

	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || pattern.length() == 0)
			return str == null ? true : str.length() == 0;

		char[] pattern_array = pattern.toCharArray();
		String[] str_array = str.split(" ");
		if (pattern_array.length != str_array.length) {
			return false;
		}
		HashMap<Character, ArrayList<Integer>> pat_map = new HashMap<>();
		HashMap<String, ArrayList<Integer>> str_map = new HashMap<>();
		for (int i = 0; i < pattern_array.length; i++) {
			char ch = pattern_array[i];
			String one_str = str_array[i];

			if (!pat_map.containsKey(ch)) {
				if (str_map.containsKey(one_str)) {
					return false;
				} else {
					ArrayList<Integer> pat_list = new ArrayList<>();
					ArrayList<Integer> str_list = new ArrayList<>();
					pat_list.add(i);
					str_list.add(i);
					pat_map.put(ch, pat_list);
					str_map.put(one_str, str_list);
				}
			} else {
				if (!str_map.containsKey(one_str)) {
					return false;
				} else {
					pat_map.get(ch).add(i);
					str_map.get(one_str).add(i);

					if (!(pat_map.get(ch).containsAll(str_map.get(one_str))
							&& str_map.get(one_str).containsAll(pat_map.get(ch)))) {
						return false;
					}
				}
			}
		}
		return true;
	}
}