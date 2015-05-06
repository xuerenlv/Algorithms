package com.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 32, 34, 66, 2, 12, 43, 54, 7, 8, 66, 87, 34, 78 };

		System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
	}

	// 归并排序 当只有一个元素的时候进行独立返回
	public static int[] mergeSort(int[] nums, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			int[] arr_f = mergeSort(nums, start, mid);
			int[] arr_s = mergeSort(nums, mid + 1, end);
			return mergeArray(arr_f, arr_s);
		} else {
			return new int[] { nums[start] };
		}
	}

	// 合并两个数组 在O（n）的情况之下
	public static int[] mergeArray(int[] arr1, int[] arr2) {
		int[] re = new int[arr1.length + arr2.length];

		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				re[k++] = arr1[i++];
			} else {
				re[k++] = arr2[j++];
			}
		}
		while (i < arr1.length) {
			re[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			re[k++] = arr2[j++];
		}

		return re;
	}

}
