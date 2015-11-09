package com.divide_conquer;

import java.util.ArrayList;
import java.util.List;

public class Different_Ways_to_Add_Parentheses_241 {

	public static void main(String[] args) {

	}

}

class Solution_Different_Ways_to_Add_Parentheses_241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> re = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				List<Integer> re_lv = diffWaysToCompute(input.substring(0, i));
				List<Integer> re_rv = diffWaysToCompute(input.substring(i + 1));
				for (int x : re_lv) {
					for (int y : re_rv) {
						if (ch == '+') {
							re.add(x + y);
						} else if (ch == '*') {
							re.add(x * y);
						} else if (ch == '-') {
							re.add(x - y);
						}
					}
				}
			}
		}

		if (re.isEmpty()) // 经过上面的循环，这里剩下的 串 里面不包含 运算符
			re.add(Integer.parseInt(input));
		return re;
	}
}