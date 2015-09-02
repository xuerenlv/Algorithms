package com.string_leval;

import java.util.HashMap;
import java.util.Map;

public class first_leval {

	public static void main(String[] args) {
		String s = "python";
		String t = "ttptpy";
		System.out.println(new Solution_first_1().anagram(s, t));
	}

}

// 
class Solution_first_4 {
	
}

// 字符串查找
class Solution_first_3 {
	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		if (source == null && target == null)
			return -1;
		if (source == null)
			return -1;
		if (target == null)
			return -1;
		char[] ma_c = source.toCharArray();
		char[] f_c = target.toCharArray();
		int m_len = source.length();
		int f_len = target.length();

		if (m_len == 0 && f_len == 0)
			return 0;
		if (m_len == 0)
			return -1;
		if (f_len == 0)
			return 0;
		int i = 0, j = 0;
		int next[] = genNext(target);
		while (i < m_len && j < f_len) {

			if (j == -1 || ma_c[i] == f_c[j]) { // j=-1 意味着开始匹配
				i++;
				j++;
			} else {
				// i=i-j+1; //i-j 为回到原来的位置，加 1 位向下进一位
				// j=0;
				j = next[j];
			}
		}

		return (j == f_len) ? (i - j) : -1;
	}

	int[] genNext(String find) {
		char[] f_str = find.toCharArray();
		int len = find.length();
		int next[] = new int[len];

		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < len - 1) {

			// f_str[k] f_str[j] 前一个的next值与当前所对应的字符比较，最多next值大一
			// 分别表示前缀与后缀
			if (k == -1 || f_str[j] == f_str[k]) {
				k++;
				j++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		return next;
	}
}

// 比较字符串
class Solution_first_2 {
	/**
	 * @param A
	 *            : A string includes Upper Case letters
	 * @param B
	 *            : A string includes Upper Case letter
	 * @return : if string A contains all of the characters in B return true
	 *         else return false
	 */
	public boolean compareStrings(String A, String B) {
		int[] a_con = new int[26];

		for (int i = 0; i < A.length(); i++) {
			a_con[A.charAt(i) - 'A'] += 1;
		}

		for (int i = 0; i < B.length(); i++) {
			int index = B.charAt(i) - 'A';
			if (a_con[index] == 0) {
				return false;
			} else {
				a_con[index] -= 1;
			}
		}
		return true;
	}
}

// 两个字符串是变位词
class Solution_first_1 {
	/**
	 * @param s:
	 *            The first string
	 * @param b:
	 *            The second string
	 * @return true or false
	 */
	public boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;

		HashMap<Character, Integer> s_map = new HashMap<>();
		HashMap<Character, Integer> t_map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char s_ch = s.charAt(i);
			char t_ch = t.charAt(i);

			if (!s_map.containsKey(s_ch)) {
				s_map.put(s_ch, 1);
			} else {
				s_map.put(s_ch, s_map.get(s_ch) + 1);
			}
			if (!t_map.containsKey(t_ch)) {
				t_map.put(t_ch, 1);
			} else {
				t_map.put(t_ch, t_map.get(t_ch) + 1);
			}
		}
		if (s_map.size() != t_map.size())
			return false;

		for (Map.Entry<Character, Integer> entry : s_map.entrySet()) {
			char s_ch = entry.getKey();
			int s_val = entry.getValue();
			if (!(t_map.containsKey(s_ch) && t_map.get(s_ch) == s_val))
				return false;
		}
		return true;
	}
}