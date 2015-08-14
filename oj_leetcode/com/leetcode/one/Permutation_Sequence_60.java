package com.leetcode.one;

public class Permutation_Sequence_60 {

	public static void main(String[] args) {
		System.out.println(new Solution_Permutation_Sequence_60().getPermutation(3, 5));
	}

}

class Solution_Permutation_Sequence_60 {
	public String getPermutation(int n, int k) {
		int[] nums = new int[n];
        int pCount = 1;  
        for(int i = 0 ; i < n; ++i) {  
            nums[i] = i + 1;  
            pCount *= (i + 1);  
        }  
  
        k--;  
        String res = "";  
        for(int i = 0 ; i < n; i++) {  
            pCount = pCount/(n-i);  
            int selected = k / pCount;  
            res += (char)('0' + nums[selected]);  

            for(int j = selected; j < n-i-1; j++)  
                nums[j] = nums[j+1];  
            k = k % pCount;  
        }  
        return res;  
	}
}