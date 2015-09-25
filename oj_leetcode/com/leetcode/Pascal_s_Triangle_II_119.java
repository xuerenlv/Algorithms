package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle_II_119 {

	public static void main(String[] args) {
		List<Integer> in = new Solution_Pascal_s_Triangle_II_119().getRow(5);
		System.out.println(in.toString());
	}

}

class Solution_Pascal_s_Triangle_II_119 {
    public List<Integer> getRow(int rowIndex) {
    	rowIndex++;
    	List<Integer> in_a = new ArrayList<Integer>();
    	List<Integer> in_b = new ArrayList<Integer>();
    	if(rowIndex==0)
    		return in_a;
		in_a.add(1);
		if(rowIndex==1)
			return in_a;
		for(int i=2;i<=rowIndex;i++){
			in_b = new ArrayList<Integer>();
			in_b.add(1);
			for(int j=0;j<i-2;j++){
				in_b.add(in_a.get(j)+in_a.get(j+1));
			}
			in_b.add(1);
			in_a= in_b;
		}
		return in_a;
    }
}