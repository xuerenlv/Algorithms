package com.dynamic_programing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_127 {

	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<>();
		wordDict.add("lest");
		wordDict.add("leet");
		wordDict.add("lose");
		wordDict.add("code");
		wordDict.add("lode");
		wordDict.add("robe");
		wordDict.add("lost");
		System.out.println(new Solution_Word_Ladder_127().ladderLength("leet", "code", wordDict));
		System.out.println(new Solution_Word_Ladder_127().ladderLength_overtime("leet", "code", wordDict));
		// System.out.println(new Solution_Word_Ladder_127().does_one("lode",
		// "code"));
	}

}

class Solution_Word_Ladder_127 {


	// ******************************************************************************************
	class Pair {
		String word;
		int index;

		public Pair(String word, int index) {
			this.word = word;
			this.index = index;
		}
	}

	// 就是一种深度优先遍历
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		if (wordDict.size() == 0)
			return 0;
		if (does_one(beginWord, endWord))
			return 2;

		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(beginWord, 1));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			List<String> remove_str = new ArrayList<>();
			for (String word : wordDict) {
				if (word.equals(beginWord) || word.equals(endWord)) {
					remove_str.add(word);
					continue;
				}
				if (does_one(pair.word, word)) {
					if (does_one(word, endWord)) {
						return pair.index + 2;
					}
					queue.add(new Pair(word, pair.index + 1));
					remove_str.add(word);
				}
			}
			for (String word : remove_str) {
				wordDict.remove(word);
			}
		}

		return 0;
	}

	// 还是超时
	public int ladderLength_overtime_2(String beginWord, String endWord, Set<String> wordDict) {
		if (wordDict.size() == 0)
			return 0;
		if (does_one(beginWord, endWord))
			return 2;

		int count = Integer.MAX_VALUE;

		for (int i = 0; i < beginWord.length(); i++) {
			char ch = beginWord.charAt(i);
			for (int j = 0; j < 26; j++) {
				char new_char = (char) (j + 'a');
				if (new_char != ch) {
					String new_begin_word = beginWord.substring(0, i) + new_char + beginWord.substring(i + 1);
					if (wordDict.contains(new_begin_word)) {
						wordDict.remove(new_begin_word);
						count = Math.min(count, ladderLength_overtime_2(new_begin_word, endWord, wordDict));
						wordDict.add(new_begin_word);
					}
				}
			}
		}

		if (count == 0)
			return 0;
		else
			return count + 1;
	}

	// 过滤所有的可能，超时
	public int ladderLength_overtime(String beginWord, String endWord, Set<String> wordDict) {
		if (does_one(beginWord, endWord))
			return 2;
		if (wordDict.size() == 0)
			return 0;

		int count = Integer.MAX_VALUE;
		String[] arr = new String[wordDict.size()];
		wordDict.toArray(arr);
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			if (does_one(beginWord, str)) {
				wordDict.remove(str);
				count = Math.min(count, ladderLength_overtime(str, endWord, wordDict));
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
			if (start.charAt(i) == end.charAt(i)) {
				count++;
			}
		}
		return count == (start.length() - 1);
	}
}