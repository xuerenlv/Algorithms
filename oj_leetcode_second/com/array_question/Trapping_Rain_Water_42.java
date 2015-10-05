package com.array_question;

public class Trapping_Rain_Water_42 {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2 };
		System.out.println(new Solution_Trapping_Rain_Water_42().trap(nums));
	}

}

class Solution_Trapping_Rain_Water_42 {

	// 这个想法很有趣
	public int trap_2(int[] height) {
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];// 计算当前格的能装雨水的容量
				left++;
			} else {
				secHight = Math.max(height[right], secHight);
				area += secHight - height[right];
				right--;
			}
		}
		return area;
	}

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
					temp += min - height[i];
					height[i] = 0;
				}
			}
			ans += temp;
		}

		return ans;
	}
}