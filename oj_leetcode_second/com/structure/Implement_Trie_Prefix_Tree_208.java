package com.structure;

import java.util.HashMap;
import java.util.Map;

public class Implement_Trie_Prefix_Tree_208 {

	public static void main(String[] args) {

	}

}

class TrieNode {
	char ch;
	boolean has_word;
	HashMap<Character, TrieNode> children;

	public TrieNode() {
		this.ch = ' ';
		this.has_word = false;
		this.children = new HashMap<>();
	}

	public TrieNode(char c) {
		this.ch = c;
		this.has_word = false;
		this.children = new HashMap<>();
	}
}

class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
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

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode cur = root;
		Map<Character, TrieNode> cur_children = root.children;

		char[] word_arr = word.toCharArray();
		for (int i = 0; i < word_arr.length; i++) {
			char wc = word_arr[i];
			if (cur_children.containsKey(wc)) {
				cur = cur_children.get(wc);
				cur_children = cur.children;
			} else {
				return false;
			}
			if (i == word_arr.length - 1) {
				return cur.has_word;
			}
		}
		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode cur = null;
		char[] sArray = prefix.toCharArray();
		for (int i = 0; i < sArray.length; i++) {
			char c = sArray[i];
			if (children.containsKey(c)) {
				cur = children.get(c);
				children = cur.children;
			} else {
				return false;
			}
		}
		return true;
	}
}