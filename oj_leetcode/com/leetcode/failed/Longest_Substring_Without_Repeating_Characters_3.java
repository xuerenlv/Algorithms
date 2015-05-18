package com.leetcode.failed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Longest_Substring_Without_Repeating_Characters_3 {

	public static void main(String[] args) {
		// String s = "abcabcbb";
		String s = "cdd";
		System.out.println(new Solution_Longest_Substring_Without_Repeating_Characters_3().lengthOfLongestSubstring(s));
	}

}

class Solution_Longest_Substring_Without_Repeating_Characters_3 {
	// 还没有弄清楚
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int maxLen = 1;
		int dupNextIndex = 0;
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hash.containsKey(c)) {
				maxLen = Math.max(maxLen, i - dupNextIndex);
				dupNextIndex = Math.max(hash.get(c) + 1, dupNextIndex);
			}
			hash.put(c, i);
		}

		maxLen = Math.max(maxLen, s.length() - dupNextIndex);

		return maxLen;
	}

	// 可以使用但是O(n^2)的时间复杂度，超时
	public int lengthOfLongestSubstring_overtime(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		} else if (len == 1) {
			return 1;
		}
		int max = 0;

		for (int i = 0; i < len; i++) {
			int j = i + 1;
			List<Character> li = new ArrayList<>();
			li.add(s.charAt(i));
			for (; j < len; j++) {
				if (li.contains(s.charAt(j))) {
					max = Math.max(max, j - i);
					break;
				} else {
					li.add(s.charAt(j));
				}
			}
			if (j == len) {
				max = Math.max(max, j - i);
			}
		}

		return max;
	}
}