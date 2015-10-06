package com.array_question;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

	public static void main(String[] args) {

	}

}

class Solution_Best_Time_to_Buy_and_Sell_Stock_II_122 {
	// accepted
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0 || len == 1)
			return 0;

		int re = 0;
		for (int i = 1; i < len; i++) {
			// 处于上升期的所有的和
			re += Math.max(0, prices[i] - prices[i - 1]);
		}

		return re;
	}
}