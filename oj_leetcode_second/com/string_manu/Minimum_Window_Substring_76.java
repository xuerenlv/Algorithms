package com.string_manu;

public class Minimum_Window_Substring_76 {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(new Solution_Minimum_Window_Substring_76().minWindow(s, t));
	}

}

class Solution_Minimum_Window_Substring_76 {

	// 这里也是使用两个数组，说明这种方式很好，也是双指针
	// 但是数组纪录的数据不一样，很有趣
	public String minWindow_2(String S, String T) {
		if (S == null || S.isEmpty() || T == null || T.isEmpty())
			return "";
		int i = 0, j = 0;
		int[] Tmap = new int[256];
		int[] Smap = new int[256];
		for (int k = 0; k < T.length(); k++) {
			Tmap[T.charAt(k)]++;
		}
		int found = 0;
		int length = Integer.MAX_VALUE;
		String res = "";
		while (j < S.length()) {
			if (found < T.length()) {
				if (Tmap[S.charAt(j)] > 0) {
					Smap[S.charAt(j)]++;
					if (Smap[S.charAt(j)] <= Tmap[S.charAt(j)]) {
						found++;
					}
				}
				j++;
			}
			while (found == T.length()) {
				if (j - i < length) {
					length = j - i;
					res = S.substring(i, j);
				}
				if (Tmap[S.charAt(i)] > 0) {
					Smap[S.charAt(i)]--;
					if (Smap[S.charAt(i)] < Tmap[S.charAt(i)]) {
						found--;
					}
				}
				i++;
			}
		}
		return res;
	}

	// 写的也是很优雅，用两个 数组 来纪录一个字符串的特征
	// 一个纪录有那些字符出现，另一个纪录字符出现了几次
	// 还有一点就是双指针，也很美
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