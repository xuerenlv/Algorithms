package com.back_tracking_question;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence_60 {

	public static void main(String[] args) {
		System.out.println(new Solution_Permutation_Sequence_60().getPermutation(3, 5));
	}

}

class Solution_Permutation_Sequence_60 {
	public String getPermutation(int n, int k) {
		int[] nums = new int[n];
		int pCount = 1;
		for (int i = 0; i < n; ++i) {
			nums[i] = i + 1;
			pCount *= (i + 1);
		}

		k--;
		String res = "";
		for (int i = 0; i < n; i++) {
			pCount = pCount / (n - i);
			int selected = k / pCount;
			res += (char) ('0' + nums[selected]);

			for (int j = selected; j < n - i - 1; j++)
				nums[j] = nums[j + 1];
			k = k % pCount;
		}
		return res;
	}

	// my
//	public String getPermutation_my(int n, int k) {
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++)
//			arr[i] = i + 1;
//		int[] k_arr = new int[1];
//		k_arr[0] = k;
//		return perm_n(arr, 0, n - 1, k_arr);
//	}
//
//	public String perm_n(int[] arr, int start, int end, int[] k_arr) {
//		if (start == end) {
//			if (k_arr[0] == 1) {
//				String re = "";
//				for (int i = 0; i < arr.length; i++)
//					re += arr[i];
//				return re;
//			} else {
//				k_arr[0]--;
//			}
//		} else {
//			for (int i = start; i <= end; i++) {
//				int temp;
//				temp = arr[i];
//				arr[i] = arr[start];
//				arr[start] = temp;
//
//				perm_n(arr, start + 1, end, k_arr);
//
//				temp = arr[i];
//				arr[i] = arr[start];
//				arr[start] = temp;
//			}
//		}
//	}
}