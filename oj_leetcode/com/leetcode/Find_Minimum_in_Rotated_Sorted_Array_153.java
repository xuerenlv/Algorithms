package com.leetcode;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {

	public static void main(String[] args) {
		int[] nums={3,1};
		System.out.println(new Solution_Find_Minimum_in_Rotated_Sorted_Array_153().findMin(nums));
	}

}


class Solution_Find_Minimum_in_Rotated_Sorted_Array_153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len==0){
        	return 0;
        }
        if(len==1){
        	return nums[0];
        }
        int st = 0;
        int end = len-1;
        
        
        while(st < end){
        	if(end-st==1){
        		return Math.min(nums[st], nums[end]);
        	}
        	int mid = (st+end)/2;
        	if(nums[st] < nums[end]){
        		return nums[st];
        	}else{
        		if(nums[mid] >= nums[st]){
        			st = mid;
        		}else{
        			end = mid;
        		}
        	}
        }
        
        return nums[st];
    }
}