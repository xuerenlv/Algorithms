package com.array_question;

import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle_118 {

	public static void main(String[] args) {
		List<List<Integer>> re = new Solution_Pascal_s_Triangle_118().generate(100);
		for(List<Integer> in_a :re){
			System.out.println(in_a.toString());
		}
	}

}

class Solution_Pascal_s_Triangle_118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if(numRows<=0){
			return re;
		}
		List<Integer> in_a = new ArrayList<Integer>();
		in_a.add(1);
		re.add(in_a);
		
		for(int i=2;i<=numRows;i++){
			in_a = new ArrayList<Integer>();
			in_a.add(1);
			for(int j=0;j<i-2;j++){
				in_a.add(re.get(i-2).get(j)+re.get(i-2).get(j+1));
			}
			in_a.add(1);
			re.add(in_a);
		}
		
		return re;
	}
}