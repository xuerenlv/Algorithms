package com.array_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {

	public static void main(String[] args) {
		int[] p = { 3, 2, 6, 5, 0, 3 };
		// System.out.println(new
		// Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188().maxProfit_my(2,
		// p));
		// System.out.println(new
		// Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188().maxProfit_my_2(2,
		// p));
		System.out.println(new Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188().maxProfit(2, p));
		System.out.println(new Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188().maxProfit___DP(2, p));
	}

}

class Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188 {

	// 动态规划 程序
	// 有待于继续理解，思考
	public int maxProfit___DP(int k, int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;

		// if k >= n/2, then you can make maximum number of transactions.
		if (k >= n / 2) {
			int maxPro = 0;
			for (int i = 1; i < n; i++) {
				if (prices[i] > prices[i - 1])
					maxPro += prices[i] - prices[i - 1];
			}
			return maxPro;
		}

		int[][] dp = new int[k + 1][n];
		for (int i = 1; i <= k; i++) {
			int localMax = dp[i - 1][0] - prices[0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
				localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
			}
		}
		return dp[k][n - 1];
	}

	// 这个不行，要求是： you must sell the stock before you buy again
	public int maxProfit_my_2(int k, int[] prices) {
		int len = prices.length;
		if (len < 2 || k == 0)
			return 0;

		int sum_profit = 0;
		if (k >= len / 2) {
			for (int i = 1; i < len; i++) {
				sum_profit += Math.max(0, prices[i] - prices[i - 1]);
			}
			return sum_profit;
		}

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int max_price = prices[len - 1];
		// 从后向前遍历，因为肯定要在后面的最高值卖，才可以获取最大利润
		for (int i = len - 2; i >= 0; i--) {
			max_price = Math.max(max_price, prices[i]);
			priorityQueue.add(max_price - prices[i]);
		}

		// System.out.println(priorityQueue.toString());
		for (int i = 0; i < k; i++) {
			sum_profit += priorityQueue.poll();
		}
		return sum_profit;
	}

	// 这个错了，购买行为不可以有交叉
	public int maxProfit_my(int k, int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;

		int max_price = 0;
		ArrayList<Integer> get_list = new ArrayList<Integer>();
		for (int i = len - 1; i >= 0; i--) {
			max_price = Math.max(max_price, prices[i]);
			get_list.add(max_price - prices[i]);
		}
		Object[] arr = get_list.toArray();
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		int sum = 0;
		int i = arr.length - 1;
		while (k > 0 && i >= 0) {
			sum += (Integer) arr[i];
			i--;
			k--;
		}

		return sum;
	}

	// 别人的
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (len < 2)
			return 0;

		int maxProfit = 0;
		if (k >= len / 2) {
			for (int i = 1; i < len; i++) {
				maxProfit += Math.max(0, prices[i] - prices[i - 1]);
			}
			return maxProfit;
		}

		int[] maxProfitSoFar = new int[len + 1];
		int currentProfit = 0;
		int runningProfit = 0;
		int prevMaxProfit = 0;
		for (int j = 0; j < k; j++) {
			runningProfit = 0;
			prevMaxProfit = maxProfitSoFar[j];
			for (int i = j + 1; i < len; i++) {
				currentProfit = prices[i] - prices[i - 1];
				runningProfit = Math.max(runningProfit + currentProfit, prevMaxProfit);
				prevMaxProfit = maxProfitSoFar[i];
				maxProfitSoFar[i] = Math.max(runningProfit, maxProfitSoFar[i - 1]);
			}
		}

		return maxProfitSoFar[len - 1];
	}

}