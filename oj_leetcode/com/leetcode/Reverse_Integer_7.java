package com.leetcode;

public class Reverse_Integer_7 {

	public static void main(String[] args) {

		System.out.println(new Solution_Reverse_Integer_7().reverse(901000));
		
//		System.out.println(new Solution_Reverse_Integer_7().reverse(-123));
	}

}

class Solution_Reverse_Integer_7 {
	public int reverse(int x) {
		int signal;
		signal = x > 0 ? 1 : -1;
		x = x > 0 ? x : -x;

		String str="";
		String str1="";
		int wei;
		while(x!=0){
			wei=x%10;
			str+=wei;
			str1+=(wei==0 && str1.isEmpty())? "":wei;
			x=x/10;
		}
		int sum=0;
		for(int i=0;i<str.length();i++){
			sum = sum*10 + (str.charAt(i)-'0');
		}
		
		String str2="";
		x=sum;
		while(x!=0){
			str2+=x%10;
			x=x/10;
		}
		
		int i=0;
//		System.out.println(str +"  "+str1+"   "+str2);
		while(i<str1.length() && i<str2.length()){
			if(str1.charAt(i) != str2.charAt(str2.length()-i-1)){
				return 0;
			}
			i++;
		}
		
		return sum*signal;
	}
}