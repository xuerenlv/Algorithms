package com.array_question;

public class H_Index_II_275 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_H_Index_II_275 {
	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		else if (citations.length == 1) {
			if (citations[0] == 0)
				return 0;
			else
				return 1;
		}

		int n = citations.length;
		if (n <= citations[0]) // tricky optimization
			return n;

		int l = 1;
		int r = n;

		while (l < r) {
			int m = l + (r - l) / 2;

			if (n - m <= citations[m]) {
				r = m;
			} else {
				l = m + 1;
			}
		}

		return n - r;
	}
}