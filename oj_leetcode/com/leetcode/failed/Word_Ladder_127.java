package com.leetcode.failed;

import java.util.Set;

public class Word_Ladder_127 {

	public static void main(String[] args) {
		// System.out.println(new Solution_Word_Ladder_127().does_one("dog",
		// "log"));
	}

}

class Solution_Word_Ladder_127 {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		if (does_one(beginWord, endWord))
			return 1;
		if (wordDict.size() == 0)
			return 0;

		int count = Integer.MAX_VALUE;
		String[] arr = new String[wordDict.size()];
		wordDict.toArray(arr);
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			if (does_one(beginWord, str)) {
				wordDict.remove(str);
				count = Math.min(count, ladderLength(str, endWord, wordDict));
				wordDict.add(str);
			}
		}

		if (count == 0)
			return 0;
		else
			return count + 1;
	}

	// 判断start是否与end有一个字符的差别
	boolean does_one(String start, String end) {
		int count = 0;
		for (int i = 0; i < start.length(); i++) {
			for (int j = 0; j < end.length(); j++) {
				if (start.charAt(i) == end.charAt(j)) {
					count++;
					break;
				}
			}
		}
		return count == (start.length() - 1);
	}
}