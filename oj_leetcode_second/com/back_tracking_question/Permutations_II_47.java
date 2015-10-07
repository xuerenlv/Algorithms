package com.back_tracking_question;

import java.util.ArrayList;
import java.util.List;

public class Permutations_II_47 {

	public static void main(String[] args) {
		int[] nums = { 3, 3, 6, 3, 5, 6 };

		List<List<Integer>> re = new Solution_Permutations_II_47().permuteUnique(nums);
		for (int i = 0; i < re.size(); i++) {
			List<Integer> in_list = re.get(i);
			System.out.println(in_list.toString());
		}
	}

}

class Solution_Permutations_II_47 {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> re_list = new ArrayList<List<Integer>>();
		perm(nums, 0, nums.length - 1, re_list);
		return re_list;
	}

	public void perm(int[] arr, int start, int end, List<List<Integer>> re) {
		if (start == end) {
			List<Integer> in_list = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				in_list.add(i, arr[i]);
			}
			re.add(in_list);

		} else {
			for (int i = start; i <= end; i++) {
				if (ok_str(arr, start, i)) {
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

	// 对于arr，从start到i-1都与 arr［i］不同才返回true
	boolean ok_str(int[] arr, int start, int i) {
		for (int k = start; k < i; k++) {
			if (arr[k] == arr[i])
				return false;
		}
		return true;
	}

	// 可以使用 Time Limit Exceeded
	// 输入一列有重复的数字，输出所有的排列
	// public List<List<Integer>> permuteUnique_overtime(int[] nums) {
	// List<List<Integer>> re_list = new ArrayList<List<Integer>>();
	// perm(nums, 0, nums.length - 1, re_list);
	// return re_list;
	// }
	//
	// public void perm(int[] arr, int start, int end, List<List<Integer>> re) {
	// if (start == end) {
	// List<Integer> in_list = new ArrayList<Integer>();
	// for (int i = 0; i < arr.length; i++) {
	// in_list.add(i, arr[i]);
	// }
	// if (!re.contains(in_list)) {
	// re.add(in_list);
	// }
	// } else {
	// for (int i = start; i <= end; i++) {
	// int temp;
	// temp = arr[i];
	// arr[i] = arr[start];
	// arr[start] = temp;
	//
	// perm(arr, start + 1, end, re);
	//
	// temp = arr[i];
	// arr[i] = arr[start];
	// arr[start] = temp;
	// }
	// }
	// }

}