package com.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 32, 34, 66, 2, 12, 43, 54, 7, 8, 66, 87, 34, 78 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	// 在这里也可以看出java内涵与指针相似性质
	public static void quickSort(int[] nums, int start, int end) {
		if (start < end) {
			int i = partion(nums, start, end);
			quickSort(nums, start, i - 1);
			quickSort(nums, i + 1, end);
		}
	}

	// 划分函数
	public static int partion(int[] nums, int left, int right) {
		int i = left;
		int j = right;

		int x = nums[i]; // 取左边元素为划分元素
		while (i < j) {
			while (i < j && nums[j] > x) {
				j--;
			}
			if (i < j) {
				nums[i] = nums[j];
				i++;
			}
			while (i < j && nums[i] < x) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i] = x;
		return i;
	}
}
