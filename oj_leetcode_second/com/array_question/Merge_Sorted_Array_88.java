package com.array_question;

import java.util.Arrays;

public class Merge_Sorted_Array_88 {

	public static void main(String[] args) {
		int[] a1 = {};
		int[] a2 = { 1 };

		new Solution_Merge_Sorted_Array_88().merge(a1, 0, a2, 1);

		System.out.println(Arrays.toString(a1));
	}

}

class Solution_Merge_Sorted_Array_88 {
	// 其实这个题目本身有问题
	// You may assume that nums1 has enough space
	// 所以在本地运行会出错
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}

		while (i >= 0) {
			nums1[index--] = nums1[i--];
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}

	public void merge_wrong(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {
			if (n == 0) {
				return;
			} else {
				nums1 = nums2;
				return;
			}
		}
		System.out.println(Arrays.toString(nums1));
		int[] nums = new int[m + n];
		int index = 0;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				nums[index++] = nums1[i++];
			} else {
				nums[index++] = nums2[j++];
			}
		}

		if (i != m) {
			while (i < m) {
				nums[index++] = nums1[i++];
			}
		}
		if (j != n) {
			while (j < n) {
				nums[index++] = nums2[j++];
			}
		}

		nums1 = nums;
	}
}