package com.leetcode;

import java.util.HashMap;

public class Two_Sum_1 {

	public static void main(String[] args) {

	}

	public static int[] twoSum_accepted(int[] nums, int target) {
		HashMap<Integer, Integer> maping = new HashMap<Integer, Integer>();

		int[] re = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if(maping.containsKey(target-nums[i])){
				re[0] = maping.get(target-nums[i]);
				re[1] = i+1;
				break;
			}else{
				maping.put(nums[i], i+1);
			}
		}

		return re;
	}
}
