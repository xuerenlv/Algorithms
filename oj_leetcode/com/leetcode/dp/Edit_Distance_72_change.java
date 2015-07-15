package com.leetcode.dp;

public class Edit_Distance_72_change {

	public static void main(String[] args) {
		System.out.println(new Solution_Edit_Distance_72_change().minDistance("x", "x"));
		System.out.println(new Solution_Edit_Distance_72_change().minDistance("s", "x"));
	}

}

class Solution_Edit_Distance_72_change {

	public int minDistance(String word1, String word2) {
		int len1 = word1.length()+1;
		int len2 = word2.length()+1;

		int[][] mark = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				mark[i][j] = Integer.MAX_VALUE;
			}
		}
		
		mark[0][0] = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if(i>0) mark[i][j] = Math.min(mark[i][j],mark[i-1][j]+1); //delete  
                if(j>0) mark[i][j] = Math.min(mark[i][j],mark[i][j-1]+1);//insert  
  
                //substitute  
                if(i>0 && j>0)  
                {  
                    if(word1.charAt(i-1)!=word2.charAt(j-1))  
                    	// leetcode 在这个地方表现为加1才accepted，感觉不对
                    	mark[i][j] = Math.min(mark[i][j],mark[i-1][j-1]+2);  
                    else  
                    	mark[i][j] = Math.min(mark[i][j],mark[i-1][j-1]);  
                }  
			}
		}

		return mark[len1-1][len2-1];
	}
}