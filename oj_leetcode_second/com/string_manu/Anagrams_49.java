package com.string_manu;

import java.util.ArrayList;
import java.util.List;

public class Anagrams_49 {

	public static void main(String[] args) {

	}

}

class Solution_Anagrams {
	// Time Limit Exceeded
	// 超时，应该是跑过了一些例子
	public List<String> anagrams(String[] strs) {
		ArrayList<String> re_list = new ArrayList<String>();
		int len = strs.length;

		String[] tezheng = new String[len];
		for (int i = 0; i < len; i++) {
			String gen_string = ((Integer) gen_sum(strs[i])).toString() + " " + ((Integer) (gen_multiply(strs[i])));
			tezheng[i] = gen_string;
		}
		boolean[] visited = new boolean[len];
		boolean yijiaru = false;
		for (int i = 0; i < len; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			yijiaru = false;
			String str_i = tezheng[i];
			for (int j = i + 1; j < len; j++) {
				if (str_i.equals(tezheng[j])) {
					visited[j] = true;
					re_list.add(strs[j]);
					if (!yijiaru) {
						re_list.add(strs[i]);
						yijiaru = true;
					}

				}
			}
		}
		return re_list;
	}

	int gen_sum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += (int) (str.charAt(i) - '0');
		}
		return sum;
	}

	int gen_multiply(String str) {
		int muti = 1;
		for (int i = 0; i < str.length(); i++) {
			muti *= (int) (str.charAt(i) - '0');
		}
		return muti;
	}

}
