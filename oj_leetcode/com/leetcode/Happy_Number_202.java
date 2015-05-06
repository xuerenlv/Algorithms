package com.leetcode;

import java.util.ArrayList;

public class Happy_Number_202 {

	public static void main(String[] args) {

		System.out.println(new Solution_Happy_Number_202().isHappy(19));
	}

}

class Solution_Happy_Number_202 {
	public boolean isHappy(int n) {
		ArrayList<Integer> loop = new ArrayList<Integer>();
		
		while(true){
			int power = sum_the_power(n);
			if(loop.contains(power)){
				if(power==1)
					return true;
				else 
					return false;
			}
			
			loop.add(power);
			n=power;
		}
	}

	public int sum_the_power(int num) {
		int sum = 0;
		while (num != 0) {
			int digit = num % 10;
			sum += digit * digit;
			num /= 10;
		}
		return sum;
	}
}