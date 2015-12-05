package com.math_question;

public class Excel_Sheet_Column_Title_168 {

	public static void main(String[] args) {
		System.out.println(new Solution_Excel_Sheet_Column_Title_168().convertToTitle(1));
		System.out.println(new Solution_Excel_Sheet_Column_Title_168().convertToTitle(26));
		System.out.println(new Solution_Excel_Sheet_Column_Title_168().convertToTitle(28));
	}

}

class Solution_Excel_Sheet_Column_Title_168 {
	
	public String convertToTitle(int n) {
		String re="";
		while(n!=0){
			re=(char)(((n-1)%26)+'A')+re;
			n=(n-1)/26;
		}
		return re;
	}
}
