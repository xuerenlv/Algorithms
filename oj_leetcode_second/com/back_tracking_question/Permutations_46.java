package com.back_tracking_question;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };

		List<List<Integer>> re_list = new Solution_Permutations_46().permute(nums);
		for (List<Integer> in_list : re_list) {
			System.out.println(in_list.toString());
		}
	}

}

class Solution_Permutations_46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> re_list = new ArrayList<List<Integer>>();
		perm(nums, 0, nums.length - 1, re_list);
		return re_list;
	}

	public void perm(int[] arr, int start, int end, List<List<Integer>> re) {
		if (start == end) {
			List<Integer> in_list = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				in_list.add(arr[i]);
			}
			re.add(in_list);
		} else {
			for (int i = start; i <= end; i++) {
				int temp;
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;

				perm(arr, start + 1, end, re);

				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
			}
		}
	}
}