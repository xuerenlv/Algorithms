package com.string_manu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repeated_DNA_Sequences_187 {

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		for (String str : new Solution_Repeated_DNA_Sequences_187().findRepeatedDnaSequences(s)) {
			System.out.println(str);
		}
	}

}

class Solution_Repeated_DNA_Sequences_187 {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ans = new ArrayList<String>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int key = 0;
		for (int i = 0; i < s.length(); i++) {
			// A-G 总共8个 ， key 就是对这个长为 10 的字符串的一个 singature
			key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;
			if (i < 9)
				continue;
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else if (map.get(key) == 1) {
				ans.add(s.substring(i - 9, i + 1));
				map.put(key, 2);// 表明已经提取了这个字符串
			}
		}
		return ans;
	}
}