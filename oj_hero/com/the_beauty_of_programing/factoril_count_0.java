package com.the_beauty_of_programing;

public class factoril_count_0 {

	public static void main(String[] args) {
		System.out.println(new solution_factoril_count_0().factorial_count_tail_0(100));
		System.out.println(new solution_factoril_count_0().factorial_count_tail_1(100));
	}

}

class solution_factoril_count_0 {

	int factorial_count_tail_0(int N) {
		int count = 0;
		int k;
		for (int i = 1; i <= N; i++) {
			k=i;
			while (k % 5 != 0) {
				count++;
				k /= 5;
			}
		}
		return count;
	}

	int factorial_count_tail_1(int N) {
		int count = 0;
		int k;
		for (int i = 1; i <= N; i++) {
			k=i;
			while (k != 0) {
				count += k / 5;
				k/= 5;
			}
		}
		return count;
	}

}
