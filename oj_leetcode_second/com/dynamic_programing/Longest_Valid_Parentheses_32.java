package com.dynamic_programing;

import java.util.Stack;

public class Longest_Valid_Parentheses_32 {

	public static void main(String[] args) {
		String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
		System.out.println(new Solution_Longest_Valid_Parentheses_32().longestValidParentheses(s));
		System.out.println(new Solution_Longest_Valid_Parentheses_32().longestValidParentheses_overtime(s));
	}

}

class Solution_Longest_Valid_Parentheses_32 {
	public int longestValidParentheses(String s) {
		int len = s.length();
		boolean[] flag = new boolean[len];

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.add(i); // stack里面装的都是左括号
			}
			if (s.charAt(i) == ')' && !stack.isEmpty()) {
				flag[i] = true; // 当前的 ） 标记为 true
				flag[stack.pop()] = true; // 与之相对应的 （ 也标记为 true
			}
		}

		int curlen = 0;
		int maxlen = 0;
		for (int i = 0; i < len; i++) {
			if (flag[i]) {
				curlen++;
			} else {
				maxlen = Math.max(maxlen, curlen);
				curlen = 0;
			}
		}

		return maxlen;
	}

	// 递归的想法， 经过验证，是对的
	// 有一点动态规划的意味，需要继续做
	public int longestValidParentheses_overtime(String s) {
		if (is_valid(s))
			return s.length();
		return Math.max(longestValidParentheses(s.substring(1)),
				longestValidParentheses(s.substring(0, s.length() - 1)));
	}

	// 判断 string 是不是 可行的
	boolean is_valid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && stack.pop() == '(') {
					continue;
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}