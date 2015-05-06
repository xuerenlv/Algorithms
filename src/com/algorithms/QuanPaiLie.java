package com.algorithms;

import java.util.Arrays;

public class QuanPaiLie {

	public static void main(String[] args) {
		// int[] nums = { 1, 2, 3 };
		//
		// perm(nums, 0, nums.length - 1);

		int[] nums = { 1, 2, 1, 1 };
		Arrays.sort(nums);
		perm_same(nums, 0, nums.length - 1);
	}

	// 有元素相同
	public static void perm_same(int[] arr, int start, int end) {
		if (start == end) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = start; i <= end; i++) {
				// System.out.println(arr[start] + " first  " + arr[i]);

				int temp;
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;

				perm(arr, start + 1, end);

				// System.out.println(arr[start] + " second  " + arr[i]);
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;

			}
		}
	}

	// 每一个元素都唯一
	public static void perm(int[] arr, int start, int end) {
		if (start == end) {
			System.out.println(Arrays.toString(arr));
		} else {
			for (int i = start; i <= end; i++) {
				// System.out.println(arr[start] + " first  " + arr[i]);
				int temp;
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;

				perm(arr, start + 1, end);

				// System.out.println(arr[start] + " second  " + arr[i]);
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
			}
		}
	}

}
