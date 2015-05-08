package com.leetcode.link;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {

	public static void main(String[] args) {

	}

}

class Solution_Path_Sum_II_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> outer_list = new ArrayList<List<Integer>>();

		while (root != null) {
			List<Integer> inner_list = new ArrayList<Integer>();
			inner_list.add(root.val);
			
			
			
		}

		return outer_list;
	}
}