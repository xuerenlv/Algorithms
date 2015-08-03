package com.leetcode.search;

public class Search_a_2D_Matrix_II_240 {

	public static void main(String[] args) {

	}

}

class Solution_Search_a_2D_matrixrix_II_240 {
	public boolean searchmatrixrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int row = 0;
		int col = cols-1;
		while(row<rows && col>=0){
			if(matrix[row][col] == target){
				return true;
			}
			if(matrix[row][col] > target){
				col--;
				continue;
			}
			if(matrix[row][col] < target){
				row++;
				continue;
			}
		}
		return false;
	}
}