package com.back_tracking_question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Search_II_212 {

	public static void main(String[] args) {

	}

}

class TrieNode {
	public String item = "";// 要用这个 item 表明有没有这个单词
	public TrieNode[] children = new TrieNode[26];
}

class Trie {
	private TrieNode root;

	public Trie() {
		// root 本身，直接指向26个分支
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.item = word;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
		}
		return node.item.equals(word);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char c : prefix.toCharArray()) {
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
		}
		return true;
	}
}

class Solutio__Word_Search_II_212 {
	Set<String> res = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, "", i, j, trie);
			}
		}

		return new ArrayList<String>(res);
	}

	public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if (visited[x][y])
			return;

		str += board[x][y];
		if (!trie.startsWith(str)) // 没有以这个为前缀的
			return;

		if (trie.search(str)) {
			res.add(str);
		}

		visited[x][y] = true;
		dfs(board, visited, str, x - 1, y, trie);
		dfs(board, visited, str, x + 1, y, trie);
		dfs(board, visited, str, x, y - 1, trie);
		dfs(board, visited, str, x, y + 1, trie);
		visited[x][y] = false;
	}
}

class Solution_Word_Search_II_212 {
	// 需要构造字典树
	// 这里是 naive 的想法
	public List<String> findWords(char[][] board, String[] words) {
		List<String> re = new ArrayList<>();
		for (String s : words) {
			if (!re.contains(s)) {
				re.add(s);
			}
		}
		List<String> re_s = new ArrayList<>();
		for (String s : re) {
			if (exist(board, s)) {
				re_s.add(s);
			}
		}
		return re_s;
	}

	public boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;

		if (word.length() == 0)
			return true;
		if (row == 0)
			return false;

		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if (word.length() == 1 || sou_suo_true(board, i, j, word.substring(1), visited)) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

	boolean sou_suo_true(char[][] board, int i, int j, String word, boolean[][] visited) {
		if (word.length() == 0) {
			return true;
		}
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int k = 0; k < direction.length; k++) {
			int ii = i + direction[k][0];
			int jj = j + direction[k][1];
			if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[i].length && board[ii][jj] == word.charAt(0)
					&& visited[ii][jj] == false) {
				visited[ii][jj] = true;
				if (word.length() == 1 || sou_suo_true(board, ii, jj, word.substring(1), visited)) {
					return true;
				}
				visited[ii][jj] = false;
			}
		}
		return false;

	}
}