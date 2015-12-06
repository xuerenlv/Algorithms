package com.math_question;

public class Number_of_1_Bits_191 {
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(12));
		
	}
	/*
	 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming
	 * weight).
	 * 
	 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should
	 * return 3.
	 */
	
	// you need to treat n as an unsigned value
	//accepted
    public static int hammingWeight(int n) {
  // 注意这里使用无符号移位就OK了
//    	int i=0;
//    	while(n!=0){
//    		if((n&1)==1) i++;
//    		n=n>>>1;
//    	}
//    
//    	return i;
    	
    	String str=Integer.toBinaryString(n);
    	int sum=0;
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)=='1') sum++;
    	}
    	return sum;
    }
    
}
