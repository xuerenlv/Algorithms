package com.dynamic_programming;

public class LargestCommonSequence {

	public static void main(String[] args) {
		String str1 = "acbnhhsaljfvbajbgliruaegbuierbgiuajhbdlchhhhhhhhhhhhhhhhdcberbvgiunrfhjklvnfdjvbalkvnfdjkvbfadklvjbfdkjvfadjvufdn";
		String str2 = "acbnhhsaljfvbajbgliruaegbuierbgiuajhbdlchhhhhhhhhhhhhhhhdcberbvgiunrfhjklvnfdjvbalkvnfdjkvbfadklvjbfdkjvfadjvufdns";

		long start, end;
		start = System.currentTimeMillis();

		System.out.println(lcs_first(str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length()));

		end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));

	}

	// 最大公共子序列    naive
	public static String lcs_first(char[] s1, int len1, char[] s2, int len2) {
		if (len1 == 0 || len2 == 0)
			return "";
		if (s1[len1 - 1] == s2[len2 - 1])
			return lcs_first(s1, len1 - 1, s2, len2 - 1) + s1[len1 - 1];
		else {
			if (lcs_first(s1, len1 - 1, s2, len2).length() > lcs_first(s1, len1, s2, len2 - 1).length())
				return lcs_first(s1, len1 - 1, s2, len2);
			else
				return lcs_first(s1, len1, s2, len2 - 1);
		}
	}

}
