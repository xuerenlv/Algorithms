package com.math_question;

public class Rectangle_Area_223 {

	public static void main(String[] args) {

	}

}

class Solution_Rectangle_Area_223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int A1 = Math.max(A, E);
		int B1 = Math.max(B, F);
		int C1 = Math.min(C, G);
		int D1 = Math.min(D, H);

		if (A1 >= C1 || B1 >= D1) {
			return area(A, B, C, D) + area(E, F, G, H);
		} else {// 分成的两个矩形没有交集
			return area(A, B, C, D) + area(E, F, G, H) - area(A1, B1, C1, D1);
		}
	}

	private int area(int A, int B, int C, int D) {
		return Math.abs(C - A) * Math.abs(D - B);
	}
}