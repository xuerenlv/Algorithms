package com.math_question;

public class Reverse_Bits_190 {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(90));
	}

	/*
	 * Reverse bits of a given 32 bits unsigned integer.
	 * 
	 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
	 * (represented in binary as 00111001011110000010100101000000).
	 * 
	 * Follow up: If this function is called many times, how would you optimize it?
	 */
	
	// you need treat n as an unsigned value
	/*
	 * uint32_t reverseBits(uint32_t n) {
        uint32_t result;
        
        for(int i=0;i<32;i++){
            result = (result<<1) | (n&1);
            n>>=1;
        }
        
        return result;
    }
	 */
	
    public static int reverseBits(int n) {
        char source[] = Integer.toBinaryString(n).toCharArray();
        int i=0,j=source.length-1;
        char swap;
        while(i<j){
        	swap = source[i];
        	source[i] = source[j];
        	source[j] = swap;
        	i++;j--;
        }
        return Integer.valueOf(new String(source));
    }
}
