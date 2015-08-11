package com.the_beauty_of_programing;

public class count_1 {

	public static void main(String[] args) {
		long s1 = System.currentTimeMillis();
		System.out.println(new solution_count_1().count_1_to_N_version_1(1000000000));
		long s2 = System.currentTimeMillis();
		System.out.println("version_1 consuming: " + (s2 - s1));
		
		s1 = System.currentTimeMillis();
		System.out.println(new solution_count_1().count_1_to_N_version_2(1000000000));
		s2 = System.currentTimeMillis();
		System.out.println("version_2 consuming: " + (s2 - s1));
	}

}

class solution_count_1 {
	int count_1_to_N_version_2(int N) {
		int i_count = 0;
		int i_factor = 1;

		int i_lowernum = 0;
		int i_cur_num = 0;
		int i_higher_num = 0;

		while (N / i_factor != 0) {
			i_lowernum = N - (N / i_factor) * i_factor;
			i_cur_num = (N / i_factor) % 10;
			i_higher_num = N / (i_factor * 10);

			switch (i_cur_num) {
			case 0:
				i_count += i_higher_num * i_factor;
				break;
			case 1:
				i_count += i_higher_num * i_factor + (i_lowernum + 1);
				break;

			default:
				i_count += (i_higher_num + 1) * i_factor;
				break;
			}

			i_factor *= 10;
		}
		return i_count;
	}

	int count_1_to_N_version_1(int N) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			count += count_1_int(i);
		}
		return count;
	}

	int count_1_int(int num) {
		int count = 0;
		while (num != 0) {
			count += (num % 10 == 1) ? 1 : 0;
			num /= 10;
		}
		return count;
	}
}