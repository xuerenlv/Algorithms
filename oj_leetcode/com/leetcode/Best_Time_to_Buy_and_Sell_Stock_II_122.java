package com.leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

	public static void main(String[] args) {

	}

}

class Solution_Best_Time_to_Buy_and_Sell_Stock_II_122 {
	// accepted
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;

		int re = 0;
		int sum = 0;
		for (int i = 1; i < len; i++) {
			sum = Math.max(0, prices[i] - prices[i - 1]);		//处于上升期的所有的和
			re += sum;
		}

		return re;
	}
}