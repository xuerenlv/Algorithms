package com.book.sword_offer;

public class find_one_num_p38 {

	public static void main(String[] args) {
		int[][] mat ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		System.out.println(find_int(mat, 7));
//		System.out.println(find_int(mat, 20));
		System.out.println(find_int(mat, 0));
	}

	static boolean find_int(int[][] mat,int num){
		int rows = mat.length;
		int cols = mat[0].length;
		
		int row = 0;
		int col = cols-1;
		while(row<rows && col>=0){
//			System.out.println(row +"  "+col);
			if(mat[row][col] == num){
				return true;
			}
			if(mat[row][col] > num){
				col--;
				continue;
			}
			if(mat[row][col] < num){
				row++;
				continue;
			}
		}
		return false;
	}
}


