package com.leetcode;

import java.util.Stack;

public class Valid_Parentheses_20 {

	public static void main(String[] args) {

	}

}

class Solution_Valid_Parentheses_20 {
	public boolean isValid_accepted(String s) {
		int len = s.length();
		if (len == 0)
			return true;

		int i = 0;
		Stack<Character> stack = new Stack<>();
		while (i < len) {
			Character ch = s.charAt(i);
			if (ch.equals('(') || ch.equals('[') || ch.equals('{')) {
				stack.add(ch);
				i++;
				continue;
			}
			if (ch.equals(')')) {
				if (!stack.isEmpty() && stack.pop().equals('(')) {
					i++;
				} else {
					return false;
				}

			} else if (ch.equals('}')) {
				if (!stack.isEmpty() && stack.pop().equals('{')) {
					i++;
				} else {
					return false;
				}

			} else if (ch.equals(']')) {
				if (!stack.isEmpty() && stack.pop().equals('[')) {
					i++;
				} else {
					return false;
				}

			}

		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}