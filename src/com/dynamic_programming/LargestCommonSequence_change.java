package com.dynamic_programming;

public class LargestCommonSequence_change {

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "a";

		long start, end;
		start = System.currentTimeMillis();

		System.out.println("长度: " + lcs_first(str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length()));

		end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));

	}

	public static int lcs_first(char[] s1, int len1, char[] s2, int len2) {
		int[][] ji_hao = new int[len1 + 1][len2 + 1];

		int i, j;
		for (i = 1; i <= len1; i++) {
			for (j = 1; j <= len2; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					ji_hao[i][j] = ji_hao[i - 1][j - 1] + 1;
				} else {
					ji_hao[i][j] = Math.max(ji_hao[i - 1][j], ji_hao[i][j - 1]);
				}
			}
		}

		System.out.println("last: " + ji_hao[len1][len2]);

		// StringBuffer sb = new StringBuffer();
		// print_lcs(ji_hao, s1, len1 - 1, s2, len2 - 1, sb);
		// System.out.println(sb.toString() + " " + sb.length());

		return ji_hao[len1][len2];
	}

	// 打印出最长公共子序列
	static void print_lcs(int[][] ji_hao, char[] s1, int i, char[] s2, int j, StringBuffer re_str) {
		if (i == -1 || j == -1)
			return;
		if (s1[i] == s2[j]) {
			re_str.append(s1[i]);
			print_lcs(ji_hao, s1, i - 1, s2, j - 1, re_str);
		} else if (ji_hao[i - 1][j] > ji_hao[i][j - 1]) {
			print_lcs(ji_hao, s1, i - 1, s2, j, re_str);
		} else {
			print_lcs(ji_hao, s1, i, s2, j - 1, re_str);
		}
	}

}
