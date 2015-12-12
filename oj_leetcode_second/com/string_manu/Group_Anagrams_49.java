package com.string_manu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Group_Anagrams_49 {

	// 很清晰的做法， “Anagram”中抽出的特征是相同的
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> re = new ArrayList<>();
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		Map<String, ArrayList<String>> map = new HashMap<>();
		for (String s : strs) {
			String te_zheng = sort_str(s);
			if (map.containsKey(te_zheng)) {
				map.get(te_zheng).add(s);
			} else {
				ArrayList<String> li = new ArrayList<>();
				li.add(s);
				map.put(te_zheng, li);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			re.add(entry.getValue());
		}

		return re;
	}

	// 对str自身进行排序，从而消除，，，，
	String sort_str(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	// 超时
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