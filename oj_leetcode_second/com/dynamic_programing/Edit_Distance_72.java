package com.dynamic_programing;

public class Edit_Distance_72 {

	public static void main(String[] args) {
		String s1 = "dinitrophenylhydrazine";
		String s2 = "benzalphenylhydrazone";

		System.out.println(new Solution_Edit_Distance_72().minDistance_overtime(s1, s2));
	}

}

class Solution_Edit_Distance_72 {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length() + 1;
		int len2 = word2.length() + 1;

		// 初始化纪录矩阵，这好像是动态规划的标配
		int[][] mark = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				mark[i][j] = Integer.MAX_VALUE;
			}
		}

		mark[0][0] = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				// 这里是有一个先后关系的，先尝试插入与删除，然后才是比较是否相等，因为这三种操作方法是并行的，没有优先级关系
				if (i > 0)
					mark[i][j] = Math.min(mark[i][j], mark[i - 1][j] + 1); // delete
				if (j > 0)
					mark[i][j] = Math.min(mark[i][j], mark[i][j - 1] + 1);// insert

				// substitute
				if (i > 0 && j > 0) {
					if (word1.charAt(i - 1) != word2.charAt(j - 1))
						mark[i][j] = Math.min(mark[i][j], mark[i - 1][j - 1] + 1);
					else
						mark[i][j] = Math.min(mark[i][j], mark[i - 1][j - 1]);
				}
			}
		}

		return mark[len1 - 1][len2 - 1];
	}

	// 递归的算法，不好
	public int minDistance_overtime(String word1, String word2) {
		return min_d(word1, word1.length() - 1, word2, word2.length() - 1);
	}

	int min_d(String s1, int end1, String s2, int end2) {
		if (end1 <= 0)
			return end2 + 1;
		if (end2 <= 0)
			return end1 + 1;

		if (s1.charAt(end1) == s2.charAt(end2)) {
			return min_d(s1, end1 - 1, s2, end2 - 1);
		}
		if (end1 - 1 >= 0 && end2 - 1 >= 0 && s1.charAt(end1) == s2.charAt(end2 - 1)
				&& s1.charAt(end1 - 1) == s2.charAt(end2)) {
			return 1 + Math.min(Math.min(min_d(s1, end1 - 2, s2, end2 - 2), min_d(s1, end1 - 1, s2, end2)),
					min_d(s1, end1, s2, end2 - 1));
		}

		return 1 + Math.min(Math.min(min_d(s1, end1 - 1, s2, end2 - 1), min_d(s1, end1 - 1, s2, end2)),
				min_d(s1, end1, s2, end2 - 1));
	}

}