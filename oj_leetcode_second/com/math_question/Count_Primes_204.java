package com.math_question;

public class Count_Primes_204 {

	public static void main(String[] args) {
		// 两种方法通过对比，可以发现相差很大
		long l1 = System.currentTimeMillis();
		int i1 = new Solution_Count_Primes_204().countPrimes_accepted(99999999);
		long l2 = System.currentTimeMillis();
		System.out.println(i1 + "-------" + (l2 - l1));

		long l3 = System.currentTimeMillis();
		int i2 = new Solution_Count_Primes_204().countPrimes_overtime(99999999);
		long l4 = System.currentTimeMillis();

		System.out.println(i1 + "   " + i2);
		System.out.println((l2 - l1) + " ***** " + (l4 - l3));
	}

}

class Solution_Count_Primes_204 {
	// Time Limit Exceeded
	public int countPrimes_overtime(int n) {
		if (n <= 1)
			return 0;
		int count = 1;
		for (int i = 3; i < n; i += 2) {
			if (is_prime(i)) {
				count++;
			}

		}
		return count;
	}

	// 判断是不是一个素数
	public boolean is_prime(int num) {
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
	// 埃拉托色尼筛法
	public int countPrimes_accepted(int n) {
		boolean not_prim[] = new boolean[n + 2];
		not_prim[0] = true;
		not_prim[1] = true;

		// i 为乘子
		for (int i = 2; i * i < n; i++) {
			if (!not_prim[i]) {
				int j = 2; // j 用于向上增加
				while (j * i < n) {
					not_prim[j * i] = true;
					j++;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (!not_prim[i])
				sum++;
		}

		return sum;
	}
}