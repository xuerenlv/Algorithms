package com.leetcode;

public class First_Missing_Positive_41 {

	public static void main(String[] args) {
		int[] nums= {3,4,-1,1};
		System.out.println(new Solution_First_Missing_Positive_41().firstMissingPositive(nums));
	}

}

class Solution_First_Missing_Positive_41 {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if (len < 0)
			return 1;
		int pos = 0;
		while (pos < len) {
			if (nums[pos] > 0 && nums[pos] != pos + 1 && nums[pos] - 1 < len && nums[pos] != nums[nums[pos] - 1]) {
				int temp = nums[pos];
				nums[pos] = nums[temp - 1];
				nums[temp - 1] = temp;
			} else{
				++pos;
			}
		}
		for (int i = 0; i < len; ++i) {
			if (i + 1 != nums[i])
				return i + 1;
		}
		return len + 1;
	}
}