package com.graph;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_51 {

	public static void main(String[] args) {

		List<List<String>> re = new Solution_N_Queens_51().solveNQueens(10);
		for(List<String> in : re){
			System.out.println(in.toString());
		}
	}

}

class Solution_N_Queens_51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> re = new ArrayList<List<String>>();
		int[] arr = new int[n];
		n_queens(arr, n, 0, re);
		return re;
	}

	void printN(int[] arr, List<List<String>> re) {
		List<String> in=new ArrayList<String>();
		int n = arr.length;
		for(int i=0;i<n;i++){
			String str="";
			for(int j=0;j<n;j++){
				if(j!=arr[i]){
					str+='.';
				}else{
					str+='Q';
				}
			}
			in.add(str);
		}
		re.add(in);
	}

	void n_queens(int[] arr, int n, int index, List<List<String>> re) {
		for (int i = 0; i < n; i++) {
			if (isValid(arr, index, i)) {
				arr[index] = i;
				if (index == n - 1) {
					printN(arr, re);
					arr[index] = 0;
					return;
				}
				n_queens(arr, n, index + 1, re);
				arr[index] = 0;
			}

		}
	}

	// 在第row行，放置在col列是否合适
	boolean isValid(int[] arr, int row, int col) {
		for (int i = 0; i < row; i++) {
			int i_col = arr[i];
			if (i_col == col)
				return false;
			if (i_col - col == i - row)
				return false;
			if (i_col - col == row - i)
				return false;
		}
		return true;
	}
}