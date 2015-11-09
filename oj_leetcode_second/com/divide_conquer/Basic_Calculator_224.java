package com.divide_conquer;

import java.util.Stack;

public class Basic_Calculator_224 {

	public static void main(String[] args) {

	}

}

// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
class Solution_Basic_Calculator_224 {

	// 很精巧
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return s.charAt(0) - '0';

		Stack<Integer> stack = new Stack<>();
		int current = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {// 里面全是 if 判断，只处理自己感兴趣的
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int cur = ch - '0';
				// 非个位数时
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				current += sign * cur;
			}
			if (ch == '-') {
				sign = -1;
			}
			if (ch == '+') {
				sign = 1;
			}
			if (ch == '(') {
				stack.push(current);
				stack.push(sign);
				current = 0;
				sign = 1;
			}
			if (ch == ')') {
				current = stack.pop() * current + stack.pop();
				sign = 1;
			}

		}
		return current;
	}
}