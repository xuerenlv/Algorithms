package com.kmp;

import java.util.Arrays;

public class KMP_f {

	public static void main(String[] args) {
		String main = "cdsabacdabcn";
		String find = "abacdabc";

		// long s_1 = System.currentTimeMillis();
		// int f1 = findString(main, find);
		// long e_1 = System.currentTimeMillis();
		// System.out.println(f1+" 穷举用时： " + (e_1-s_1));
		//
		int[] next = genNext(find);

		System.out.println(Arrays.toString(next));
		// System.out.println("*************************************************");
		// for(int i=0;i<next.length;i++){
		// System.out.print(next[i] + "\t");
		// }
		// System.out.println();
		// System.out.println("*************************************************");

		// long s_2 = System.currentTimeMillis();
		// int f2 = findString(main, find,next);
		// long e_2 = System.currentTimeMillis();
		// System.out.println(f2+" kmp用时： " + (e_2-s_2));
	}

	// 模式匹配，穷举
	public static int findString(String ma, String find) {
		char[] ma_c = ma.toCharArray();
		char[] f_c = find.toCharArray();
		int m_len = ma.length();
		int f_len = find.length();
		int i = 0, j = 0;
		while (i < m_len && j < f_len) {
			if (ma_c[i] == f_c[j]) {
				i++;
				j++;
				System.out.println(i + " " + j);
			} else {
				i = i - j + 1; // i-j 为回到原来的位置，加 1 位向下进一位
				j = 0;
			}
		}

		return (j == f_len) ? (i - j + 1) : -1;
	}

	// kmp主方法
	public static int findString(String ma, String find, int next[]) {
		char[] ma_c = ma.toCharArray();
		char[] f_c = find.toCharArray();
		int m_len = ma.length();
		int f_len = find.length();
		int i = 0, j = 0;
		while (i < m_len && j < f_len) {

			if (j == -1 || ma_c[i] == f_c[j]) { // j=-1 意味着开始匹配
				i++;
				j++;
				System.out.println(i + " " + j);
			} else {
				// i=i-j+1; //i-j 为回到原来的位置，加 1 位向下进一位
				// j=0;
				j = next[j];
			}
		}

		return (j == f_len) ? (i - j + 1) : -1;
	}

	// 获得模式串的next数组
	public static int[] genNext(String find) {
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
