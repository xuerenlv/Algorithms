package com.array_question;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

	public static void main(String[] args) {

	}

}

class Solution_Best_Time_to_Buy_and_Sell_Stock_121 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;
		
		int max_price=prices[len-1];
		int re=0;
		// 从后向前遍历，因为肯定要在后面的最高值卖，才可以获取最大利润
		for(int i=len-2;i>=0;i--){
			max_price=Math.max(max_price, prices[i]);
			re=Math.max(re, max_price-prices[i]);
		}
		
		return re;
	}
}