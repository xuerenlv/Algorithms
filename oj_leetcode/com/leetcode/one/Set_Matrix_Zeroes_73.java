package com.leetcode.one;

public class Set_Matrix_Zeroes_73 {

	public static void main(String[] args) {

	}

}


class Solution_Set_Matrix_Zeroes_73 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row==0){
        	return;
        }
        int col = matrix[0].length;
        
        boolean[] flag_row = new boolean[row];
        boolean[] flag_col = new boolean[col];
        
        
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(matrix[i][j]==0){
        			flag_row[i] = true;
        			flag_col[j] = true;
        		}
        	}
        }
        
        for(int i=0;i<row;i++){
        	if(flag_row[i]){
            	for(int j=0;j<col;j++){
            		matrix[i][j] = 0;
            	}
        	}
        }
        for(int j=0;j<col;j++){
        	if(flag_col[j]){
        		for(int i=0;i<row;i++){
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
}