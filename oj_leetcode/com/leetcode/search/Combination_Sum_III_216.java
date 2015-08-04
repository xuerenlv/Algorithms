package com.leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III_216 {

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> re = new Solution_Combination_Sum_III_216().combinationSum3(k, n);
		for (List<Integer> in : re) {
			System.out.println(in.toString());
		}
	}

}

class Solution_Combination_Sum_III_216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> in = new ArrayList<>();
		List<List<Integer>> re = new ArrayList<>();

		find(9, 1, k, in, re, n);
		return re;
	}

	void find(int n, int start, int k, List<Integer> in, List<List<Integer>> re, int target) {
		if (target <= 0) {
			if (k == 0 && target == 0)
				re.add(new ArrayList<>(in));
			return;
		}
		for (int i = start; i <= n; i++) {
			in.add(i);
			find(n, i + 1, k - 1, in, re, target - i);
			in.remove((Integer) i);
		}
	}
}