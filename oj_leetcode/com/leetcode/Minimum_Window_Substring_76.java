package com.leetcode;

import java.util.Arrays;

public class Minimum_Window_Substring_76 {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(new Solution_Minimum_Window_Substring_76().minWindow(s, t));
	}

}

class Solution_Minimum_Window_Substring_76 {
	public String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0)
			return "";

		int[] tmap = new int[256]; // store the count of each character in t
		boolean[] tbmap = new boolean[256]; // store the appearance of each
											// character in t

		for (int i = 0; i < t.length(); i++) {
			tmap[t.charAt(i)]++;
			tbmap[t.charAt(i)] = true;
		}

		int i = 0, j = 0; // i and j stores the start and end index of substring
		int found = 0; // found stores how many letters in t has been found in s
		int len = Integer.MAX_VALUE;
		String res = "";
		
		while (j < s.length()) {
			char cj = s.charAt(j);
			if (found < t.length()) { // we haven't found all the letters in t
				if (tbmap[cj]) {
					if (tmap[cj] > 0) { // the times cj appear in s is smaller
										// than the times appears in t
						found++;
					}
					tmap[cj]--;
				}
				j++;
			}
			while (found == t.length()) {
				char ci = s.charAt(i);
				if (!tbmap[ci])
					i++; // ci in s is not in t
				else if (tmap[ci] < 0) { // ci appears more times in s than t
					tmap[ci]++;
					i++;
				} else {
					if (j - i < len) {
						res = s.substring(i, j);
						len = j - i;
					}
					found--;
					tmap[ci]++;
					i++;
				}
			}
		}
		return res;
	}
}