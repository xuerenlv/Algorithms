package com.string_leval;

import java.util.Arrays;

public class first_1 {

	public static void main(String[] args) {
		String s="python";
		String t="ttptpy";
		System.out.println( new Solution_first_1().anagram(s, t));
	}

}

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
		
		int[] s_arr = new int[26];
		int[] t_arr = new int[26];
	
		for(int i=0;i<s.length();i++){
			s_arr[s.charAt(i)-'a']++;
			t_arr[t.charAt(i)-'a']++;
		}
		System.out.println(Arrays.toString(s_arr));
		System.out.println(Arrays.toString(t_arr));
		for(int i=0;i<26;i++){
			if(s_arr[i] != t_arr[i])
				return false;
		}
		return true;
	}
}