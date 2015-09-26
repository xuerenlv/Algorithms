package com.array_question;

import java.util.Arrays;

public class Plus_One_66 {

	public static void main(String[] args) {
		int[] digits = { 1, 0 };
		

		int[] re = new Solution_Plus_One_66().plusOne(digits);

		System.out.println(Arrays.toString(re));
	}

}

class Solution_Plus_One_66 {
	public int[] plusOne(int[] digits) {
		int[] re = new int[digits.length + 1];

		int jin_wei = 0;
		int jia;
		for (int i = digits.length - 1; i >= 0; i--) {
			if(i==digits.length - 1){
				jia = digits[i] + jin_wei + 1;
			}else{
				jia = digits[i] + jin_wei;
			}
			re[i + 1] = jia % 10;
			jin_wei = jia / 10;
		}

		
		if (jin_wei == 0) {
			System.arraycopy(re, 1, digits, 0, digits.length);
			return digits;
		} else {
			re[0] = jin_wei;
			return re;
		}
	}
}