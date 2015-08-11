package com.leetcode.failed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Substring_with_Concatenation_of_All_Words_30 {

	public static void main(String[] args) {

	}

}

class Solution_Substring_with_Concatenation_of_All_Words_30 {
	public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (s == null || s.isEmpty() || words == null || words.length < 1) {
			return result;
		}
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> find = new HashMap<String, Integer>();
		int arr_len = words.length;
		int str_len = words[0].length();
		for (int i = 0; i < arr_len; i++) {
			if (!toFind.containsKey(words[i])) {
				toFind.put(words[i], 1);
			} else {
				toFind.put(words[i], toFind.get(words[i]) + 1);
			}
		}
		for (int i = 0; i <= s.length() - arr_len * str_len; i++) {
			find.clear();
			int j;
			for (j = 0; j < arr_len; j++) {
				int k = i + j * str_len;
				String subStr = s.substring(k, k + str_len);
				if (!toFind.containsKey(subStr))
					break;
				if (!find.containsKey(subStr)) {
					find.put(subStr, 1);
				} else {
					find.put(subStr, find.get(subStr) + 1);
				}
				if (find.get(subStr) > toFind.get(subStr))
					break;
			}
			if (j == arr_len)
				result.add(i);
		}
		return result;
	}
	
}