package com.leetcode.failed;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators_282 {

	public static void main(String[] args) {

	}

}

class Solution_Expression_Add_Operators_282 {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		addOperatorsDFS(num, target, 0, 0, "", res);
		return res;
	}

	void addOperatorsDFS(String num, int target, int diff, int curNum, String out, List<String> res) {
		if (num.length() == 0 && curNum == target) {
			res.add(out);
		}
		for (int i = 1; i <= num.length(); ++i) {
			String cur = num.substring(0, i);
			if (cur.length() > 1 && cur.charAt(0) == '0')
				return;
			String next = num.substring(i);
			if (out.length() > 0) {
				addOperatorsDFS(next, target, Integer.parseInt(cur), curNum + Integer.parseInt(cur), out + "+" + cur,
						res);
				addOperatorsDFS(next, target, -Integer.parseInt(cur), curNum - Integer.parseInt(cur), out + "-" + cur,
						res);
				addOperatorsDFS(next, target, diff * Integer.parseInt(cur),
						(curNum - diff) + diff * Integer.parseInt(cur), out + "*" + cur, res);
			} else {
				addOperatorsDFS(next, target, Integer.parseInt(cur), Integer.parseInt(cur), cur, res);
			}
		}
	}
}