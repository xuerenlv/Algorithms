package com.array_question;

import java.util.Arrays;

public class H_Index_274 {

	public static void main(String[] args) {
		int[] nums = { 3, 0, 6, 1, 5 };
		System.out.println(new Solution_H_Index_274().hIndex(nums));
	}

}

class Solution_H_Index_274 {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);

		// 降序排列
		int index = 0;
		int[] temp = new int[citations.length];
		for (int i = citations.length - 1; i >= 0; i--, index++) {
			temp[index] = citations[i];
		}

		for (int i = 1; i <= citations.length; i++) {
			if (i > temp[i - 1]) {
				return i - 1;
			}
		}

		return temp.length;
	}
}