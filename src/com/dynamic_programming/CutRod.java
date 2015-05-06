package com.dynamic_programming;

public class CutRod {

	public static void main(String[] args) {
		int price[] = { 0, 1, 5, 3, 4, 5, 10, 2, 32, 11, 33 };
		int n = 30;

		System.out.println(cut_rod_bottom_up(price, n));
		/*
		// ---------------------------------------------------------------------
		long start, end;
		start = System.currentTimeMillis();

		int s_n = cut_rod_naive(price, n);

		end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
		// ---------------------------------------------------------------------

		// ---------------------------------------------------------------------
		start = System.currentTimeMillis();

		int o_u_d = cut_rod_up_to_down(price, n);

		end = System.currentTimeMillis();
		System.out.println("所花时间：" + (end - start));
		// ---------------------------------------------------------------------

		System.out.println(s_n);
		System.out.println(o_u_d);
		*/
	}

	// 切割钢条 naive 对重复计算的子问题无记忆
	public static int cut_rod_naive(int price[], int n) {
		if (n == 0)
			return 0;
		int get = 0;

		// 递归求解各个子问题，但是要注意子问题的划分与确定
		for (int i = 1; i <= Math.min(price.length - 1, n); i++) {
			get = Math.max(get, cut_rod_naive(price, n - i) + price[i]);
		}
		return get;
	}

	// 带备忘的自顶向下法
	public static int memorized_cut_rod_aux(int price[], int n, int r[]) {
		if (n == 0)
			return 0;
		if (r[n] > 0)
			return r[n];

		int get = 0;
		for (int i = 1; i <= Math.min(price.length - 1, n); i++) {
			get = Math.max(get, price[i] + memorized_cut_rod_aux(price, n - i, r));
		}
		r[n] = get;
		return get;
	}
	public static int cut_rod_up_to_down(int price[], int n) {
		int r[] = new int[n + 1];
		return memorized_cut_rod_aux(price, n, r);
	}
	
	//自底向上
	public static int cut_rod_bottom_up(int price[],int n){
		int r[]=new int[n+1];
		for(int j=1;j<n+1;j++){
			int get=0;
			for(int i=1;i<=Math.min(price.length-1, j);i++){
				get=Math.max(get,price[i]+r[j-i]);
			}
			r[j]=get;
		}
		return r[n];
	}


}
