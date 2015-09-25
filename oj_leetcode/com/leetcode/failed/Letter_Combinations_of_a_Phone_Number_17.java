package com.leetcode.failed;


import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number_17 {

	public static void main(String[] args) {

	}

}

class Solution_Letter_Combinations_of_a_Phone_Number_17 {
    public List<String> letterCombinations(String digits) {
        int len =digits.length();
        List<String> re = new ArrayList<>();
        
        
        if(len==0){
        	return re;
        }else{
        	gen_combine(re, digits, 0, len-1);
        	return re;
        }
    }
    
    void gen_combine(List<String> re,String digits,int start,int end){
    	if(start==end){
    		for(int i=0;i<re.size();i++){
    			
    		}
    	}
    	
    }
}