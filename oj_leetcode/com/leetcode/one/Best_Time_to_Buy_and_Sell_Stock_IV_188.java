package com.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {

	public static void main(String[] args) {
		int[] p = {1,2,4};
		System.out.println(new Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188().maxProfit_my(2, p));
	}

}

class Solution_Best_Time_to_Buy_and_Sell_Stock_IV_188 {
	//这个错了，购买行为不可以有交叉
	public int maxProfit_my(int k, int[] prices) {
		int len = prices.length;
		if (len == 0)
			return 0;
		
		int max_price = 0;
		ArrayList<Integer> get_list = new ArrayList<Integer>();
		for (int i = len-1; i >= 0; i--) {
			max_price = Math.max(max_price, prices[i]);
			get_list.add(max_price - prices[i]);
		}
		Object[] arr = get_list.toArray();
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int sum = 0;
		int i = arr.length-1;
		while(k>0 && i>=0){
			sum += (Integer)arr[i];
			i--;
			k--;
		}
		
		return sum;
	}
	public int maxProfit(int k, int[] prices) {
		    int len = prices.length;
		    if (len < 2) return 0;

		    int maxProfit = 0;
		    //simple case where we just need to find the maximum climb in prices among all the pairs
		    if (k >= len / 2){
		        for (int i = 1; i < len; i++){
		            maxProfit += Math.max(0, prices[i] - prices[i-1]);
		        }
		        return maxProfit;
		    }
		    
		    //Dynamic Programming case where we need to maximize our profit
		    //keeps track of maximum profit so far at each index. On any index 'i' the value is max profit that we gained
		    //by dealing stock that came before 'i'. After any 'm' iterations, this array holds max profit on index 'i' if we had
		    //only 'i' stock values and 'm' possible deals.
		    int[] maxProfitSoFar=new int[len+1];

		    //calculates the difference between the very current and previous stock price
		    int currentProfit = 0;
		    //keeps track of our current balance.
		    int runningProfit = 0;
		    //it backs up the value of max profit after doing 'm-1' deals until index 'i' before updating it to 
		    //the value of doing 'm' deals until index i.
		    int prevMaxProfit = 0;
		    //k iterations for k deals - after each round mapxProfitSoFar holds the max profit for 'j' possible deals
		    for (int j = 0; j < k; j++){
		        //resetting our balance for new iteration
		        runningProfit = 0;
		        //initializing with the last max profit we are going to start the next iteration with indexes after this.
		        prevMaxProfit = maxProfitSoFar[j]; 
		        //we don't need to start from the beginning eveytime since we would face "the simple case" (above) and the profit 
		        //is already calculated. It means that number of deals is greater than the 'len'
		        for (int i = j+1; i < len; i++){
		            //what is the immediate different of the current two prices.
		            currentProfit = prices[i] - prices[i-1];
		            //is it better to do this deal? or should we stick to what we did with one less deal and see what future holds!
		            runningProfit = Math.max(runningProfit + currentProfit, prevMaxProfit); 
		            //backing up max value with one less deal to compare in the next round
		            prevMaxProfit = maxProfitSoFar[i]; 
		            //updating max profit so far by asking if we gained more profit with last deal or we didn't gain anything more
		            maxProfitSoFar[i] = Math.max(runningProfit, maxProfitSoFar[i-1]); 
		        }
		    }

		    //well the last item in the MaxProfitSoFar after k iterations holds max profit of 'k' deals of 'len' items.
		    return maxProfitSoFar[len-1];
		}
	
}