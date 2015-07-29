package com.book.sword_offer;

public class print_to_max_of_digits {

	public static void main(String[] args) {
		// print_to(20);
//		System.out.println(new char[10]);
		print_to_2(2);
	}

	static void print_to(int n) {
		int num = 1;
		while (n > 0) {
			num *= 10;
			n--;
		}
		System.out.println(num);
		// for(int i=1;i<num;i++){
		// System.out.println(i);
		// }
	}

	static void print_to_2(int n) {
		if (n <= 0)
			return;
		char[] number = new char[n];
		for (int i = 0; i < n; i++)
			number[i] = '0';
		while (!increment(number)) {
			System.out.println(number);
		}
	}

	static boolean increment(char[] number) {
		boolean isoverflow = false;
		int n_takeover = 0;
		int len = number.length;

		for (int i = len - 1; i >= 0; i--) {
			int n_sum = number[i] - '0' + n_takeover;
			if (i == len - 1) {
				n_sum++;
			}

			if (n_sum >= 10) {
				if (i == 0) {
					isoverflow = true;
				} else {
					n_sum -= 10;
					n_takeover = 1;
					number[i] = (char) ('0' + n_sum);
				}
			} else {
				number[i] = (char) ('0' + n_sum);
				System.out.println("----------"+number[i]+"--------"+i+"--------------"+n_takeover+"--------------"+n_sum);
				break;
			}
		}
		return isoverflow;
	}

}
