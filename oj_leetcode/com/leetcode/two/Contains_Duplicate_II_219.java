package com.leetcode.two;

import java.util.HashMap;

public class Contains_Duplicate_II_219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution_Contains_Duplicate_II_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<>();
        int num =0;
        for(int i=0;i<nums.length;i++){
     	   num = nums[i];
     	   if(map.containsKey(num)){
     		   if(i-map.get(num)<=k){
     			   return true;
     		   }else{
     			  map.put(num, i);
     		   }
     		   
     	   }else{
     		   map.put(num, i);
     	   }
        }
        return false;
    }
}