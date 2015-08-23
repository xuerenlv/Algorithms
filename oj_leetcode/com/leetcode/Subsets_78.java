package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> re = new Solution_Subsets_78().subsets(nums);
		for(List<Integer> in:re){
			System.out.println(in.toString());
		}
	}

}
class Solution_Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
    	List<Integer> in = new ArrayList<>();
    	List<List<Integer>> re = new ArrayList<>();
    	
    	Arrays.sort(nums);
    	tran(nums, 0, nums.length, in, re);
    	
    	return re;
    }
    
    void tran(int[] nums,int start,int end,List<Integer> in,List<List<Integer>> re){
    	if(start==end){
    		re.add(new ArrayList<>(in));
    		return;
    	}
    	
    	List<Integer> in_2 = new ArrayList<>(in);
    	in.add(nums[start]);
    	tran(nums, start+1, end, in, re);
    	tran(nums, start+1, end, in_2, re);
    }
}