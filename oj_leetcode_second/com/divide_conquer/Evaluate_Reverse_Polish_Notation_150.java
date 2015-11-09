package com.divide_conquer;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150 {

	public static void main(String[] args) {
		// System.out.println(Integer.valueOf("100"));
		String[] tokens = { "0", "3", "/" };

		System.out.println(new Solution_Evaluate_Reverse_Polish_Notation_150().evalRPN(tokens));
	}

}

class Solution_Evaluate_Reverse_Polish_Notation_150 {
	// 使用一个栈，来计算逆波兰式
	public int evalRPN(String[] tokens) {
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (i < tokens.length) {
			if (tokens[i].equals("+")) {
				int i1 = (int) stack.pop();
				int i2 = (int) stack.pop();
				stack.push(i1 + i2);
				i++;
				continue;
			}

			if (tokens[i].equals("-")) {
				int i1 = (int) stack.pop();
				int i2 = (int) stack.pop();
				stack.push(i2 - i1);
				i++;
				continue;
			}
			if (tokens[i].equals("*")) {
				int i1 = (int) stack.pop();
				int i2 = (int) stack.pop();
				stack.push(i1 * i2);
				i++;
				continue;
			}
			if (tokens[i].equals("/")) {
				int i1 = (int) stack.pop();
				int i2 = (int) stack.pop();
				stack.push(i2 / i1);
				i++;
				continue;
			}
			stack.push(Integer.valueOf(tokens[i]));
			i++;
		}
		return stack.pop();
	}
}