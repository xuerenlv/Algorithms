package com.graph;

import java.util.Arrays;

public class Sudoku_Solver_37_changed {

	public static void main(String[] args) {
		char[][] board_1 = {{'5','3','.','.','7','.','.','.','.'},
						  	{'6','.','.','1','9','5','.','.','.'},
						  	{'.','9','8','.','.','.','.','6','.'},
						  	{'8','.','.','.','6','.','.','.','3'},
						  	{'4','.','.','8','.','3','.','.','1'},
						  	{'7','.','.','.','2','.','.','.','6'},
						  	{'.','6','.','.','.','.','2','8','.'},
						  	{'.','.','.','4','1','9','.','.','5'},
						  	{'.','.','.','.','8','.','.','7','9'}};
		
		
		char[][] board_2 = {{'.','.','9','7','4','8','.','.','.'},
				  			{'7','.','.','.','.','.','.','.','.'},
				  			{'.','2','.','1','.','9','.','.','.'},
				  			{'.','.','7','.','.','.','2','4','.'},
				  			{'.','6','4','.','1','.','5','9','.'},
				  			{'.','9','8','.','.','.','3','.','.'},
				  			{'.','.','.','8','.','3','.','2','.'},
				  			{'.','.','.','.','.','.','.','.','6'},
				  			{'.','.','.','2','7','5','9','.','.'}};
		
		
//		new Solution_Sudoku_Solver_37_changed().solveSudoku(board_1);
//		print(board_1);
		
		new Solution_Sudoku_Solver_37_changed().solveSudoku(board_2);
		print(board_2);
	}
	

    static void print(char[][] board){
    		System.out.println("*************************start****************************");
    		for(int i=0;i<9;i++){
    			System.out.println(Arrays.toString(board[i]));
    		}
    		System.out.println("**************************end*****************************");
    }
    

}

class Solution_Sudoku_Solver_37_changed {
	

	public void solveSudoku(char[][] board) {
    	try {
			resolve(board,0);
		} catch (Exception e) {			
		}
    }
    void resolve(char[][] board,int place) throws Exception  {
    	print(board);
    	int row=0,col=0;
    	for(int i=place;i<81;i++){
    		row = i/9;
    		col = i%9;
    		if(board[row][col] == '.')
    			break;
    		if(i==80){
    			// 为何抛出异常，目的是让程序全局停止
				throw new Exception("end");
				
//    			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//    			try {
//					System.class.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
    		}
    		
    	}
    	
    	for(int i=0;i<9;i++){
    		char test = (char)(i+'1');
    		if(is_ok(board, row, col, test)){
    			board[row][col] = test;
    			resolve(board, place+1);
    		}
    	}
    	board[row][col] = '.';
    }
    
    boolean is_ok(char[][] board,int row,int col,char fill){
    	for(int i=0;i<9;i++){
    		if(board[row][i]==fill || board[i][col]==fill){
    			return false;
    		}
    	}
    	
    	int row_st = (int)(row/3)*3;
		int col_st = (int)(col/3)*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row_st + i][col_st + j] ==fill) {
					return false;
				}
			}
		}
		
		return true;
    }
    
    void print(char[][] board){
		System.out.println("*************************start****************************");
		for(int i=0;i<9;i++){
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("**************************end*****************************");
    }
}
