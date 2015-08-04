package com.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_39 {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> re = new Solution_Combination_Sum_39().combinationSum(candidates, target);
		for(List<Integer> in : re){
			System.out.println(in.toString());
		}
	}

}

class Solution_Combination_Sum_39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> in = new ArrayList<>();
		List<List<Integer>> re = new ArrayList<>();
		Arrays.sort(candidates);
		find_list(candidates, 0, candidates.length - 1, re, in, target);
		return re;
	}

	void find_list(int[] candidates, int start, int end, List<List<Integer>> re, List<Integer> in, int target) {
		if (target <= 0 || start > end) {
			if (target == 0) {
				List<Integer> in_new = new ArrayList<Integer>(in); 
				re.add(in_new);
			}
			return;
		}

		for (int i = start; i <= end; i++) {
			in.add(candidates[i]);
			find_list(candidates, i, end, re, in, target-candidates[i]);
			in.remove(in.size()-1);
		}
	}
}