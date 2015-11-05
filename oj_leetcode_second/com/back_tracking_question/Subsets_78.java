package com.back_tracking_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> re = new Solution_Subsets_78().subsets(nums);
		for (List<Integer> in : re) {
			System.out.println(in.toString());
		}
	}

}

class Solution_Subsets_78 {
	// 基于迭代的
	public List<List<Integer>> subsets_2(int[] S) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());

		Arrays.sort(S);
		for (int i : S) {
			// tmp用于存放加入当前元素的
			List<List<Integer>> tmp = new ArrayList<>();
			for (List<Integer> sub : res) {
				List<Integer> a = new ArrayList<>(sub);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
		}
		return res;
	}

	// 基于回溯的算法
	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> in = new ArrayList<>();
		List<List<Integer>> re = new ArrayList<>();

		Arrays.sort(nums);
		tran(nums, 0, nums.length, in, re);

		return re;
	}

	void tran(int[] nums, int start, int end, List<Integer> in, List<List<Integer>> re) {
		if (start == end) {
			re.add(new ArrayList<>(in));
			return;
		}

		// 不加当前元素
		List<Integer> in_2 = new ArrayList<>(in);
		tran(nums, start + 1, end, in_2, re);

		// 加入当前元素
		in.add(nums[start]);
		tran(nums, start + 1, end, in, re);

	}
}