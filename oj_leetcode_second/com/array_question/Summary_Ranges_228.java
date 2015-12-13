package com.array_question;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges_228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Summary_Ranges_228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> re = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return re;

		int start = 0;
		int end = 0;
		while (end < nums.length) {
			if (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
				end++;
			} else {
				if (start == end) {
					re.add(new Integer(nums[start]).toString());
				} else {
					re.add(new Integer(nums[start]).toString() + "->" + new Integer(nums[end]).toString());
				}
				end++;
				start = end;
			}
		}

		return re;
	}
}