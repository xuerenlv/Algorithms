package com.sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 32, 34, 66, 2, 12, 43, 54, 7, 8, 66, 87, 34, 78 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] nums) {
		buildMaxHeap(nums); // 建立大根堆

		int swap;
		for (int i = nums.length - 1; i >= 1; i--) {
			swap = nums[0]; // 最大值
			nums[0] = nums[i];
			nums[i] = swap;

			maxHeap(nums, i, 0); // 重构大根堆
		}
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		int swap;
		if (index != largest) {
			swap = array[index];
			array[index] = array[largest];
			array[largest] = swap;

			maxHeap(array, heapSize, largest);
		}
	}
}
