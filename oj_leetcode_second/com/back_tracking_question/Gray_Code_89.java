package com.back_tracking_question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Gray_Code_89 {

	public static void main(String[] args) {
		List<Integer> re = new Solution_Gray_Code_89().grayCode(1);
		System.out.println(re.toString());
	}

}

class Solution_Gray_Code_89 {

	public List<Integer> grayCode_2(int n) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < 1 << n; i++)
			result.add(i ^ i >> 1);
		return result;
	}

	public List<Integer> grayCode(int n) {
		List<Integer> re = new ArrayList<>();
		re.add(0);
		for (int i = 0; i < n; i++) {
			int highest = 1 << i;
			int len = re.size();
			for (int j = len - 1; j >= 0; j--) {
				re.add(highest + re.get(j));
			}
		}
		return re;
	}

	// 此处为求格雷码
	public List<Integer> grayCode_wrong(int n) {
		List<Integer> re = new ArrayList<>();
		re.add(0);
		if (n == 0)
			return re;
		int max_num = 0;
		for (int i = 0; i < n; i++) {
			max_num += Math.pow(2, i);
		}

		for (int i = 1; i <= max_num; i++) {
			re.add(i);
		}
		return re;
	}
}