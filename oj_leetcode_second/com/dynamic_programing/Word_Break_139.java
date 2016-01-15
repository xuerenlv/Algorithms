package com.dynamic_programing;

import java.util.Set;

public class Word_Break_139 {

	public static void main(String[] args) {
		// Set<String> wordDict = new HashSet<String>();
		// wordDict.add("xhj");
		// wordDict.add("xh");
		//
		// System.out.println(new Solution_Word_Break_139().wordBreak("xxhj",
		// wordDict));
		System.out.println("xhj".substring(1, 3));
	}

}

class Solution_Word_Break_139 {
	// 这个是动态规划
	public boolean wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] f = new boolean[len + 1];
		f[0] = true;
		for (int i = 1; i < len + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		return f[len];
	}
}