package com.divide_conquer;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators_282 {

	public static void main(String[] args) {

	}

}

class Solution_Expression_Add_Operators_282 {

	public List<String> addOperators_2(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}

	public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
		if (pos == num.length()) {
			if (target == eval)
				rst.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(rst, path + cur, num, target, i + 1, cur, cur);
			} else {
				helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

				helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

				helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
			}
		}
	}

	// ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		addOperatorsDFS(num, target, 0, 0, "", res);
		return res;
	}

	// 比如2+3*2，即将要运算到乘以2的时候，上次循环的curNum = 5, diff = 3,
	// 而如果我们要算这个乘2的时候，新的变化值diff应为3*2=6，而我们要把之前+3操作的结果去掉，再加上新的diff，即(5-3)+6=8，即为新表达式2+3*2的值
	// diff 是处理的数字，， curNum 是当前的结果
	void addOperatorsDFS(String num, int target, long diff, long curNum, String out, List<String> res) {
		if (num.length() == 0 && curNum == target) {
			res.add(out);
			return;
		}
		for (int i = 1; i <= num.length(); ++i) {
			String cur = num.substring(0, i);
			if (cur.length() > 1 && cur.charAt(0) == '0')
				return;
			String next = num.substring(i);
			if (out.length() > 0) {
				addOperatorsDFS(next, target, Long.parseLong(cur), curNum + Long.parseLong(cur), out + "+" + cur, res);
				addOperatorsDFS(next, target, -Long.parseLong(cur), curNum - Long.parseLong(cur), out + "-" + cur, res);
				addOperatorsDFS(next, target, diff * Long.parseLong(cur), (curNum - diff) + diff * Long.parseLong(cur),
						out + "*" + cur, res);
			} else {
				// 刚刚开始
				addOperatorsDFS(next, target, Long.parseLong(cur), Long.parseLong(cur), cur, res);
			}
		}
	}
}