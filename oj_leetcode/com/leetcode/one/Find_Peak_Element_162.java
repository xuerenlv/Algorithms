package com.leetcode.one;

public class Find_Peak_Element_162 {

	public static void main(String[] args) {

	}

}


class Solution_Find_Peak_Element_162 {
	// O(lg(n)) 更好
	public int findPeakElement_better(int[] nums) {
		int i = 0;
		int j = nums.length-1;
		while(i<=j){
			if(i==j){
				return i;
			}
			int mid = (i+j)/2;
			if(nums[mid]<nums[mid+1]){
				i = mid+1;
			}else{
				j = mid;
			}
		}
		return i;
	}
    public int findPeakElement(int[] nums) {
    	int max=0;
    	int max_val = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(nums[i]>max_val){
        		max_val = nums[i];
        		max = i;
        	}
        }
    	return max;
    }
}