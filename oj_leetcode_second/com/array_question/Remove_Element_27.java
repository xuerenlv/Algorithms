package com.array_question;

public class Remove_Element_27 {

	public static void main(String[] args) {

	}

}

class Solution_Remove_Element_27 {
	public int removeElement(int[] nums, int val) {
		int count=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i] != val){
				nums[count++]=nums[i];
			}
		}
		return count;
	}
}