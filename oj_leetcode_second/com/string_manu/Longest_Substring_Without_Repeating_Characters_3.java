package com.string_manu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Longest_Substring_Without_Repeating_Characters_3 {

	public static void main(String[] args) {
		String s = "abba";
		// String s = "cdd";
		// System.out.println(new
		// Solution_Longest_Substring_Without_Repeating_Characters_3().lengthOfLongestSubstring(s));

		// System.out.println(new
		// Solution_Longest_Substring_Without_Repeating_Characters_3_second()
		// .lengthOfLongestSubstring_naive_way(s));

		System.out.println(
				new Solution_Longest_Substring_Without_Repeating_Characters_3_second().lengthOfLongestSubstring(s));
	}

}

class Solution_Longest_Substring_Without_Repeating_Characters_3_second {

	// 还没有弄清楚，就是使用一个map纪录 数字 和 相应的位序
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
				// System.out.println(i+" "+(hash.get(c) + 1)+" "+dupNextIndex);
				dupNextIndex = Math.max(hash.get(c) + 1, dupNextIndex);
			}
			hash.put(c, i);
		}

		maxLen = Math.max(maxLen, s.length() - dupNextIndex);
		return maxLen;
	}

	// 可以使用但是O(n^2)的时间复杂度，超时
	public int lengthOfLongestSubstring_naive_way(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		} else if (len == 1) {
			return 1;
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			List<Character> li = new ArrayList<>();

			// 向后进行遍历
			int k = i;
			while (k >= 0 && !li.contains(s.charAt(k))) {
				li.add(s.charAt(k));
				k--;
			}
			// 向前进行遍历
			int j = i + 1;
			while (j < len && !li.contains(s.charAt(j))) {
				li.add(s.charAt(j));
				j++;
			}
			max = Math.max(max, j - k - 1);
		}
		return max;
	}
}
