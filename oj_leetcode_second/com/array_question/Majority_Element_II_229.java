package com.array_question;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II_229 {

	public static void main(String[] args) {

	}

}

class Solution_Majority_Element_II_229 {
	// 多加一个纪录就可以了
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> re = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return re;

		int val_1 = nums[0];
		int val_2 = nums[0];
		int count_1 = 0;
		int count_2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count_1 == 0 || nums[i] == val_1) {
				val_1 = nums[i];
				count_1++;
			} else if (count_2 == 0 || nums[i] == val_2) {
				val_2 = nums[i];
				count_2++;
			} else {
				count_1--;
				count_2--;
			}
		}

		count_1 = 0;
		count_2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val_1) {
				count_1++;
			}
			if (nums[i] == val_2) {
				count_2++;
			}
		}
		if (count_1 > nums.length / 3) {
			re.add(val_1);
		}
		if (count_2 > nums.length / 3) {
			if (val_2 != val_1) {
				re.add(val_2);
			}
		}
		return re;
	}
}