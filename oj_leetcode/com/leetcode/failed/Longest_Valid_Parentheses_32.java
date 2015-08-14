package com.leetcode.failed;

import java.util.Arrays;
import java.util.Stack;

public class Longest_Valid_Parentheses_32 {

	public static void main(String[] args) {
		String s = ")()((()(())";
		System.out.println(new Solution_Longest_Valid_Parentheses_32().longestValidParentheses(s));
	}

}

class Solution_Longest_Valid_Parentheses_32 {
	public int longestValidParentheses(String s) {
		int len = s.length();
		boolean[] flag = new boolean[len];

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.add(i);
			}
			if (s.charAt(i) == ')' && !stack.isEmpty()) {
				flag[i] = true;
				flag[stack.pop()] = true;
			}
		}

		int curlen = 0;
		int maxlen = 0;
		for (int i = 0; i < len; i++) {
			if (flag[i]) {
				curlen++;
			} else {
				curlen = 0;
			}
			maxlen = Math.max(maxlen, curlen);
		}

		return maxlen;
	}

	public int longestValidParentheses_overtime(String s) {
		if (is_valid(s))
			return s.length();
		return Math.max(longestValidParentheses(s.substring(1)),
				longestValidParentheses(s.substring(0, s.length() - 1)));
	}

	boolean is_valid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			switch (c) {
			case '(':
				stack.push(c);
				break;

			default:
				if (stack.isEmpty())
					return false;
				char d = stack.pop();
				if (d == '(') {
					continue;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}