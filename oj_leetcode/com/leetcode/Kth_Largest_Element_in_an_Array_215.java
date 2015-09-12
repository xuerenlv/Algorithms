package com.leetcode;

import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array_215 {

	public static void main(String[] args) {

	}

}

class Solution_Kth_Largest_Element_in_an_Array_215 {
	public int findKthLargest(int[] nums, int k) {
		int[] k_num = new int[k];

		for (int i = 0; i < k; i++) {
			k_num[i] = nums[i];
		}

		Arrays.sort(k_num);
		int num;
		for (int i = k; i < nums.length; i++) {
			num = nums[i];
			if (num <= k_num[0])
				continue;
			insert(k_num, num);
		}

		reverse(k_num);
		return k_num[k - 1];
	}

	void insert(int[] nums, int num) {
		int len = nums.length;
		nums[0] = num;
		for (int i = 0; i < len-1; i++) {
			if(nums[i] > nums[i+1]){
				swap(nums,i,i+1);
			}
		}
	}
	
	void swap(int[] num,int i,int j){
		int temp;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	void reverse(int[] num) {
		int i = 0;
		int j = num.length - 1;
		int temp;
		while (i < j) {
			temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}
}