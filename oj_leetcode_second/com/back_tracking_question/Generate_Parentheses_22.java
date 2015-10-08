package com.back_tracking_question;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {

	public static void main(String[] args) {
		List<String> re = new Solution_Generate_Parentheses_22().generateParenthesis(10);
		for (int i = 0; i < re.size(); i++) {
			System.out.println(re.get(i));
		}
	}

}

class Solution_Generate_Parentheses_22 {
	// 不用递归
	public List<String> generateParenthesis_2(int n) {
		List<String>[] temp = new ArrayList[n + 1];
		temp[0] = new ArrayList<>();
		temp[0].add("");

		for (int i = 1; i <= n; i++) {
			temp[i] = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				for (String t1 : temp[j])
					for (String t2 : temp[i - 1 - j])
						temp[i].add("(" + t1 + ")" + t2);
			}
		}

		return temp[n];

	}

	public List<String> generateParenthesis(int n) {
		List<String> re = new ArrayList<>();
		gen_pairs(re, n, 0, 0, "");
		return re;
	}

	public void gen_pairs(List<String> re, int n, int open, int close, String current) {
		if (close > open)
			return;
		if (close == n && open == n) {
			re.add(current);
		} else {
			// 先加左括号，再加右括号
			if (open < n)
				gen_pairs(re, n, open + 1, close, current + "(");
			gen_pairs(re, n, open, close + 1, current + ")");
		}
	}
}