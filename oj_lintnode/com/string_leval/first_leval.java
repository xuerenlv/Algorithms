package com.string_leval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class first_leval {

	public static void main(String[] args) {
//		String s = "python";
//		String t = "ttptpy";
//		System.out.println(new Solution_first_1().anagram(s, t));
		
		
		String[] str_s = {"tea","tea","eat"};
		List<String> re = new Solution_first_4().anagrams(str_s);
		System.out.println(re.toString());
		
		System.out.println(new Solution_first_4().sort_str(""));
	}

}

// 最长公共子串 
class Solution_5{
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	
    
    }
}

// 乱序字符串
class Solution_first_4 {
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: A list of strings
	 */
	public List<String> anagrams(String[] strs) {
		List<String> re_list= new ArrayList<>();
		Map<String, String> map_sort = new HashMap<>();
		Map<String, Integer> double_str = new HashMap<>();
		for(String str : strs){
			map_sort.put(str, sort_str(str));
			if(!double_str.containsKey(str)){
				double_str.put(str, 1);
			}else{
				double_str.put(str, double_str.get(str)+1);
			}
		}
		
		Map<String, Integer> value_mark = new HashMap<>();
		List<String> sorted_list = new ArrayList<>();
		for(String sort_s : map_sort.values()){
			if(!value_mark.containsKey(sort_s)){
				value_mark.put(sort_s, 1);
			}else{
				sorted_list.add(sort_s);
			}
		}
		
		for(String str : map_sort.keySet()){
			if(sorted_list.contains(map_sort.get(str)))
				re_list.add(str);
		}
		
//		int count_void = 0;
//		for(String str : strs){
//			if(str.equals("")){
//				count_void++;
//			}
//		}
//		if(count_void>1){
//			for(int i=0;i<count_void;i++){
//				re_list.add("");
//			}
//		}
		
		for(String str : double_str.keySet()){
			if (double_str.get(str)>1) {
				if(re_list.contains(str)){
					for(int i=0;i<double_str.get(str)-1;i++)
						re_list.add(str);
				}else{
					for(int i=0;i<double_str.get(str);i++)
						re_list.add(str);
				}
			}
		}
		
		return re_list;
	}

	String sort_str(String str) {
		if (str == null)
			return "";
		if (str.length() <= 1)
			return str;
		char[] str_arr = str.toCharArray();
		char temp;
		for (int i = 0; i < str_arr.length - 1; i++) {
			for (int j = i + 1; j < str_arr.length; j++) {
				if (str_arr[i] > str_arr[j]) {
					temp = str_arr[i];
					str_arr[i] = str_arr[j];
					str_arr[j] = temp;
				}
			}
		}

		return new String(str_arr);
	}
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