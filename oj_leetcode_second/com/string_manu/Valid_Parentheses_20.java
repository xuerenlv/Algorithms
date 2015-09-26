package com.string_manu;

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

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.add(ch);
				continue;
			}
			if (ch == ')') {
				if (!(!stack.isEmpty() && stack.pop().equals('('))) {
					return false;
				}

			} else if (ch == '}') {
				if (!(!stack.isEmpty() && stack.pop().equals('{'))) {
					return false;
				}

			} else if (ch == ']') {
				if (!(!stack.isEmpty() && stack.pop().equals('['))) {
					return false;
				}

			}

		}

		return stack.isEmpty();
	}
}