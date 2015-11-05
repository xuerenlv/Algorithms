package com.back_tracking_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {

	public static void main(String[] args) {

	}

}

class Solution_Subsets_II_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<Integer> in = new ArrayList<>();
		List<List<Integer>> re = new ArrayList<>();

		Arrays.sort(nums);
		tran(nums, 0, nums.length, in, re);

		return re;
	}

	void tran(int[] nums, int start, int end, List<Integer> in, List<List<Integer>> re) {
		if (start == end) {
			// 当有了重复元素之后，子集可能会发生重复
			if (!re.contains(in))
				re.add(new ArrayList<>(in));
			return;
		}

		List<Integer> in_2 = new ArrayList<>(in);
		in.add(nums[start]);
		tran(nums, start + 1, end, in, re);
		tran(nums, start + 1, end, in_2, re);
	}
}