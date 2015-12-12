package com.array_question;

import java.util.HashMap;

public class Contains_Duplicate_III_220 {

	public static void main(String[] args) {
		int[] arr = {-1,2147483647};
		int k= 1;
		int t= 2147483647;
		System.out.println(new Solution_Contains_Duplicate_III_220().containsNearbyAlmostDuplicate(arr, k, t));
		
	}

}

class Solution_Contains_Duplicate_III_220 {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        int len = nums.length;
        if(k<=500){
        	for(int i=0;i <len;i++){
          	   num = nums[i];
          	   for(int j =(i-k<=0)?0:(i-k);j<i;j++){
          		   if(map.containsKey(j) && Math.abs(map.get(j)-num)-t<=0){
          			   return true;
          		   }
          	   }
          	   map.put(i, num);
             }
        }else{
    		for (int i = 0; i < nums.length; i++) {
    			num = nums[i];
    			for (int key = num - t; key <= num + t; key++) {
    				if (map.containsKey(key)) {
    					if (i - map.get(key) <= k) {
    						return true;
    					}
    				}
    			}
    			map.put(num, i);
    		}
        }
        return false;
	}

	public boolean containsNearbyAlmostDuplicate_overtime3(int[] nums, int k, int t) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int num = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			num = nums[i];
			for (int j = (i - k <= 0) ? 0 : (i - k); j < i; j++) {
				if (map.containsKey(j) && Math.abs(map.get(j) - num) <= t) {
					return true;
				}
			}
			map.put(i, num);
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate_overtime2(int[] nums, int k, int t) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i];
			for (int key = num - t; key <= num + t; key++) {
				if (map.containsKey(key)) {
					if (i - map.get(key) <= k) {
						return true;
					}
				}
			}
			map.put(num, i);
		}
		return false;
	}

	// 未知错误
	public boolean containsNearbyAlmostDuplicate_overtime(int[] nums, int k, int t) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i];
			for (int j = i; j >= 0 && i - j <= k; j--) {
				if (map.containsKey(j) && Math.abs(map.get(j) - num) <= t) {
					return true;
				}
			}
			if (i > k) {
				map.remove(i - k);
			}
			map.put(i, num);
		}
		return false;
	}
}