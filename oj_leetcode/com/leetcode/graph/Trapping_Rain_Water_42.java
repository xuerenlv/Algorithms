package com.leetcode.graph;

public class Trapping_Rain_Water_42 {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2 };
		System.out.println(new Solution_Trapping_Rain_Water_42().trap(nums));
	}

}

class Solution_Trapping_Rain_Water_42 {
	public int trap(int[] height) {
		int len = height.length;
		if (len < 3)
			return 0;

		int ans = 0;
		int l = 0;
		int r = len - 1;

		while (l < r) {
			while (l < r && height[l] == 0)
				l++;
			while (l < r && height[r] == 0)
				r--;

			int temp = 0;
			int min = Math.min(height[l], height[r]);
			for (int i = l; i <= r; i++) {
				if (height[i] >= min) {
					height[i] -= min;
				} else {
					temp += min-height[i];
					height[i] = 0;
				}
			}
			ans += temp;
		}

		return ans;
	}
}