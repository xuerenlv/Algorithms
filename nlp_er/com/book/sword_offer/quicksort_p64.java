package com.book.sword_offer;

import java.util.Arrays;

public class quicksort_p64 {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 6, 7, 0, 4, 12, 2, 43, 1, 1, 1 };
		new solution_2().quick_sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}

class solution {
	void quick_sort(int[] arr, int start, int end) {
		int k = partion(arr, start, end);
		if (k > start) {
			quick_sort(arr, start, k - 1);
		}
		if (k < end) {
			quick_sort(arr, k + 1, end);
		}
	}

	int partion(int[] arr, int start, int end) {
		int i = start;
		int j = end;

		int k = arr[start];
		while (i < j) {
			while (i < j && arr[j] >= k) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && arr[i] <= k) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = k;
		return i;
	}
}

class solution_2 {

	void quick_sort(int[] arr, int start, int end) {
		int k = partion(arr, start, end);
		if (k > start) {
			quick_sort(arr, start, k - 1);
		}
		if (k < end) {
			quick_sort(arr, k + 1, end);
		}
	}

	int partion(int[] arr, int start, int end) {
		int pivotpos = start;
		int pivot = arr[start];
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < pivot && ++pivotpos != i) {
				int tmp = arr[i];
				arr[i] = arr[pivotpos];
				arr[pivotpos] = tmp;
			}
		}

		int tmp = arr[start];
		arr[start] = arr[pivotpos];
		arr[pivotpos] = tmp;

		return pivotpos;
	}
}