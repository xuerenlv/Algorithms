package com.array_question;

public class Maximum_Subarray_53 {

	public static void main(String[] args) {
//		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		 int[] nums = { -84, -87, -78, -16, -94, -36, -87, -93, -50, -22, -63, -28, -91, -60, -64, -27, -41, -27, -73, -37, -12,
		 -69, -68, -30, -83, -31, -63, -24, -68, -36, -30, -3, -23, -59, -70, -68, -94, -57, -12, -43, -30, -74, -22, -20,
		 -85, -38, -99, -25, -16, -71, -14, -27, -92, -81, -57, -74, -63, -71, -97, -82, -6, -26, -85, -28, -37, -6, -47,
		 -30, -14, -58, -25, -96, -83, -46, -15, -68, -35, -65, -44, -51, -88, -9, -77, -79, -89, -85, -4, -52, -55, -100,
		 -33, -61, -77, -69, -40, -13, -27, -87, -95, -40 };

		System.out.println(new Solution_Maximum_Subarray_53().maxSubArray(nums));
	}

}

class Solution_Maximum_Subarray_53 {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int sum = A[0];

		// 前面取得所有数之中加上我自身，如果比我自身大，那就要，否则不如不要，因为它让我变小
		for (int i = 1; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			max = Math.max(max, sum);
		}
		return max;
	}
	// Time Limit Exceeded
	public int maxSubArray_overtime(int[] nums) {
		int[] get = new int[1];
		get[0] = Integer.MIN_VALUE;
		max_in(nums, 0, nums.length - 1, get);
		return get[0];
	}

	void max_in(int[] nums, int start, int end, int[] get) {
		if (start > end)
			return;
		if (start < 0 || end > nums.length - 1)
			return;

		while (start < end) {
			int souyi = 0;
			for (int k = start; k <= end; k++) {
				souyi += nums[k];
			}
			get[0] = Math.max(get[0], souyi);

			if (nums[start] > nums[end]) {
				end--;
			} else if (nums[start] > nums[end]) {
				start++;
			} else {
				int s = start++;
				int e = end--;
				max_in(nums, s, end, get);
				max_in(nums, start, e, get);
			}
		}

	}
}