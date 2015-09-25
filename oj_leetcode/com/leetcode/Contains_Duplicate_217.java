package com.leetcode;

import java.util.HashMap;

public class Contains_Duplicate_217 {

	public static void main(String[] args) {

	}

}


class Solution_Contains_Duplicate_217 {
    public boolean containsDuplicate(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int num =0;
       for(int i=0;i<nums.length;i++){
    	   num = nums[i];
    	   if(map.containsKey(num)){
    		   return true;
    	   }else{
    		   map.put(num, 1);
    	   }
       }
       return false;
    }
}