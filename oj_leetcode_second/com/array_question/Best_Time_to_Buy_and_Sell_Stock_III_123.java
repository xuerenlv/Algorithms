package com.array_question;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

	public static void main(String[] args) {
		int[] p = { 6, 1, 3, 2, 4, 7 };
		System.out.println(new Solution_Best_Time_to_Buy_and_Sell_Stock_III_123().maxProfit(p));
	}

}

class Solution_Best_Time_to_Buy_and_Sell_Stock_III_123 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;

		int re = 0;
		for (int i = 0; i < len; i++) {
			// 去掉一群不需要计算的
			if (i > 0 && i < len - 1) {
				if (prices[i] <= prices[i - 1]) {
					continue;
				}
			}
			// 将做两次交易，分解成做两个一次交易
			re = Math.max(re, maxProfit_start_end(prices, 0, i) + maxProfit_start_end(prices, i + 1, len - 1));
		}

		return re;
	}

	int maxProfit_start_end(int[] prices, int start, int end) {
		if (end == start)
			return 0;

		int max_price = prices[end];
		int re = 0;
		for (int i = end - 1; i >= start; i--) {
			max_price = Math.max(max_price, prices[i]);
			re = Math.max(re, max_price - prices[i]);
		}

		return re;
	}
}