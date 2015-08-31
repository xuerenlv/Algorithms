package com.leetcode.failed;

public class Maximum_Product_Subarray_152 {

	public static void main(String[] args) {

	}

}


class Solution_Maximum_Product_Subarray_152 {
    public int maxProduct(int[] nums) {
        int re = Integer.MIN_VALUE;
        int i=0,j=0;
        
        while(true){
        	if(i+1 == nums.length){
        		if(i==j){
        			re = Math.max(re, nums[i]);
        		}else{
        			re = Math.max(re, ((nums[i]+nums[j])*(i-j+1))/2);
        		}
        		break;
        	}
        	
        	if(i==0){
        		i++;
        	}else{
        		if(nums[i+1]==nums[i]+1){
        			i++;
        		}else{
        			i=i+1;
        			j=i;
        		}
        	}
        }
        
        return re;
    }
}