package com.structure;

import java.util.Map;

public class Add_and_Search_Word_Data_structure_design_211 {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();

		wordDictionary.addWord("at");
		wordDictionary.addWord("and");
		wordDictionary.addWord("an");

		wordDictionary.addWord("add");
		System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search(".at"));
		wordDictionary.addWord("bat");
		System.out.println(wordDictionary.search(".at"));
		System.out.println(wordDictionary.search("an."));
		System.out.println(wordDictionary.search("a.d."));
		System.out.println(wordDictionary.search("b."));
		System.out.println(wordDictionary.search("a.d"));
		System.out.println(wordDictionary.search("."));
	}

}

class WordDictionary {
	
	public TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode cur = root;
		Map<Character, TrieNode> cur_children = root.children;

		char[] word_arr = word.toCharArray();
		for (int i = 0; i < word_arr.length; i++) {
			char wc = word_arr[i];
			if (cur_children.containsKey(wc)) {
				cur = cur_children.get(wc);
			} else {
				TrieNode new_node = new TrieNode(wc);
				cur_children.put(wc, new_node);
				cur = new_node;
			}

			cur_children = cur.children;

			if (i == word_arr.length - 1) {
				cur.has_word = true;
			}
		}
	}

	public boolean search(String word) {
		return search_with_pos(word, word.length(), 0, root);
	}

	public boolean search_with_pos(String word, int n, int pos, TrieNode cur) {
		if (pos == n)
			return cur.has_word;
		if (cur == null)
			return false;

		if (word.charAt(pos) == '.') {
			for (Map.Entry<Character, TrieNode> map_entry : cur.children.entrySet()) {
				 if(search_with_pos(word, n, pos + 1, map_entry.getValue()))
					 return true;
			}
		} else {
			char ch = word.charAt(pos);
			if (cur.children.containsKey(ch)) {
				return search_with_pos(word, n, pos + 1, cur.children.get(ch));
			} else {
				return false;
			}
		}
		return false;
	}

}
