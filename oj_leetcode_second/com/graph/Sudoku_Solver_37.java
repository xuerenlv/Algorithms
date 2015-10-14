package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku_Solver_37 {

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
		
//		System.out.println(board[4][0]);
//		System.out.println(board[5][0]);
//		System.out.println(new Solution_Valid_Sudoku_36().isValidSudoku(board));
		
		new Solution_Sudoku_Solver_37().solveSudoku(board_2);
		
		
	}

}

class Solution_Sudoku_Solver_37 {
	// 你的做法是错的，因为你只是按照规则去解题
	// 实际上，在某个位置可能需要假设，在假设的基础上去验证
    public void solveSudoku(char[][] board) {
    	boolean flag = true; 
    	while(flag){
    		flag = false;
    		for(int i=0;i<9;i++){
        		for(int j=0;j<9;j++){
        			if(board[i][j]=='.'){
        				char re = resolve(board, i, j);
//        				System.out.println(re);
        				if(re != 'n'){
        					board[i][j] = re;
        				}else{
        					flag = true;
        				}
        			}
        		}
    		}
    		print(board);
    	}
    	return;
    }
    
    void print(char[][] board){
    	System.out.println("*************************start****************************");
    	for(int i=0;i<9;i++){
    		System.out.println(Arrays.toString(board[i]));
    	}
    	System.out.println("**************************end*****************************");
    }
    
    char resolve(char[][] board,int row,int col){
    	ArrayList<Integer> container = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.') {
				int num = (int) (board[row][i] - '0');
				container.add(num);
				
				
			}
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.') {
				int num = (int) (board[i][col] - '0');
				container.add(num);
				
//				System.out.println(i+" "+col+"   "+board[i][col]+" "+num);
			}
		}
//		if(row==0 && col==0)
//			System.out.println(row+" "+col+" "+Arrays.toString(container.toArray()));
		
		int row_st = (int)(row/3)*3;
		int col_st = (int)(col/3)*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row_st + i][col_st + j] != '.') {
					int num = (int) (board[row_st + i][col_st + j] - '0');
					container.add(num);
				}
			}
		}
		
//		System.out.println(row+" "+col+" "+Arrays.toString(container.toArray()));
		
		ArrayList<Integer> re = new ArrayList<Integer>();
		for(int i=1;i<10;i++){
			if(!container.contains(i)){
				re.add(i);
			}
		}
		
		if(re.size()==1){
			return (char) (re.get(0)+'0');
		}else{
			return 'n';
		}
    }
}
