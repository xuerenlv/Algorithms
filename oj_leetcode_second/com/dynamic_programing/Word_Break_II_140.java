package com.dynamic_programing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break_II_140 {

	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		String s = "catsanddog";

		List<String> re = new Solution_Word_Break_II_140().wordBreak(s, wordDict);
		for (String str : re) {
			System.out.println(str);
		}
	}

}

class Solution_Word_Break_II_140 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> re = new ArrayList<String>();
		if (!wordBreak_139(s, wordDict)) {// 加一下，可以节省很多的时间
			return re;
		}
		String sen = "";
		breakWords(s, 0, wordDict, sen, re);
		return re;
	}

	// 使用回溯法，求出所有的可能
	void breakWords(String s, int index, Set<String> wordDict, String sen, List<String> re) {
		if (index == s.length()) {
			re.add(sen.substring(0, sen.length() - 1));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			String word = s.substring(index, i + 1);
			if (wordDict.contains(word)) {
				breakWords(s, i + 1, wordDict, sen + word + " ", re);
			}
		}
	}

	boolean wordBreak_139(String s, Set<String> wordDict) {
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