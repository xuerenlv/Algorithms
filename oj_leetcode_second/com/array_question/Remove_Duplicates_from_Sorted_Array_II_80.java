package com.array_question;


public class Remove_Duplicates_from_Sorted_Array_II_80 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,2,2};
		System.out.println(new Solution_Remove_Duplicates_from_Sorted_Array_II_80().removeDuplicates(nums));
		
	}

}

class Solution_Remove_Duplicates_from_Sorted_Array_II_80 {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		
		int count = 1;
		int flag = 1;
		for(int i=1;i<len;i++){
			if(nums[i] != nums[i-1]){
				nums[count++] = nums[i];
				flag = 1;
			}else{
				if(flag==1){
					nums[count++] = nums[i];
				}
				flag++;
			}
		}
		
		return count;
	}
}