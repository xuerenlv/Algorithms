package com.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_1 {

	public static void main(String[] args) {

	}

}

class Solution_Two_Sum_1 {
	
	// 使用map存放位置,速度确实会快一些
	public int[] twoSum_map(int[] nums, int target) {
		HashMap<Integer, Integer> maping = new HashMap<Integer, Integer>();

		int[] re = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if(maping.containsKey(target-nums[i])){
				re[0] = maping.get(target-nums[i])+1;
				re[1] = i+1;
				break;
			}else{
				maping.put(nums[i], i);
			}
		}

		return re;
	}

	// 精简，还不用使用 map 来保存位序
	public int[] twoSum_hash(int[] nums, int target) {
		ArrayList<Integer> already_visited = new ArrayList<>();
		for(int i=0;i<nums.length;i++){
			if(already_visited.contains(target-nums[i])){
				int index_1 = already_visited.indexOf((Integer)(target-nums[i]));
				return new int[]{index_1+1,i+1};
			}else{
				already_visited.add(nums[i]);
			}
		}
		return new int[2];
	}

	// 排序，双指针；因为返回的是位序，所以还要在原序列中找
	// 竟然也可以accepted，没有超时，说明这个题目要求低了一些
	public int[] twoSum_two_pointer(int[] nums, int target) {
		int[] ori = new int[nums.length];
		System.arraycopy(nums, 0, ori, 0, nums.length);

		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int[] n_num = new int[2];
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				n_num[0] = nums[start];
				n_num[1] = nums[end];
				break;
			} else if (nums[start] + nums[end] > target) {
				end--;
			} else {
				start++;
			}
		}

		int count = 0;
		int[] re = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (ori[i] == n_num[0] || ori[i] == n_num[1]) {
				re[count] = i + 2;
				count++;
			}
			if (count == 2)
				break;
		}
		return re;
	}
}