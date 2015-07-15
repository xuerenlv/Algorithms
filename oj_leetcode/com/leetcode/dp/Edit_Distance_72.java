package com.leetcode.dp;

public class Edit_Distance_72 {

	public static void main(String[] args) {
		String s1="dinitrophenylhydrazine";
		String s2="benzalphenylhydrazone";
		
		System.out.println(new Solution_Edit_Distance_72().minDistance_overtime(s1, s2));
	}

}


class Solution_Edit_Distance_72 {
	
	//递归的算法，不好
    public int minDistance_overtime(String word1, String word2) {
        return min_d(word1, word1.length()-1, word2, word2.length()-1);
    }
    
    int min_d(String s1,int end1,String s2,int end2){
    	if(end1 <=0 )
    		return end2+1;
    	if(end2 <=0 )
    		return end1+1;
    	
    	if(s1.charAt(end1)==s2.charAt(end2)){
    		return min_d(s1, end1-1, s2, end2-1);
    	}
    	if(end1-1>=0 && end2-1>=0 && s1.charAt(end1)==s2.charAt(end2-1) && s1.charAt(end1-1)==s2.charAt(end2)){
    		return 1+Math.min(Math.min(min_d(s1, end1-2, s2, end2-2),min_d(s1, end1-1, s2, end2) ), min_d(s1, end1, s2, end2-1));
    	}
    	
    	return 1+Math.min(Math.min(min_d(s1, end1-1, s2, end2-1), min_d(s1, end1-1, s2, end2)), min_d(s1, end1, s2, end2-1));
    }
    
    
}