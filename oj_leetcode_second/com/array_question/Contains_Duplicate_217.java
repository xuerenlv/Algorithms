package com.array_question;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_217 {

	public static void main(String[] args) {

	}

}

class Solution_Contains_Duplicate_217 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> distinct = new HashSet<Integer>();// 用set更合适
		// HashMap<Integer, Integer> map = new HashMap<>();
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i];
			if (distinct.contains(num)) {
				return true;
			} else {
				distinct.add(num);
			}
		}
		return false;
	}
}