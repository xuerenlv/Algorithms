package com.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = new TreeNode(2);
		rootNode.right = null;

		List<List<Integer>> outer_list = new Solution_Path_Sum_II_113().pathSum(rootNode, 3);
		System.out.println(outer_list.size());
		List<Integer> in = outer_list.get(0);
		System.out.println();
		for (int i = 0; i < in.size(); i++) {
			System.out.print(in.get(i) + "   ");
		}
	}

}

class Solution_Path_Sum_II_113 {
//	public List<List<Integer>> pathSum_2(TreeNode root, int sum) {
//		List<List<Integer>> outer_list = new ArrayList<List<Integer>>();
//		List<Integer> in_list = new ArrayList<Integer>();
//		pre_tree_1(root, in_list, sum, outer_list);
//		return outer_list;
//	}
//
//	这样是不行的
//	// 前序遍历，容器在原有基础上递增
//	void pre_tree_1(TreeNode root, List<Integer> in_list, int sum, List<List<Integer>> outer_list) {
//		if (root == null)
//			return;
//
//		in_list.add(root.val);
//
//		if (root.right == null && root.left == null) {
//			int in_sum = 0;
//			for (int i = 0; i < in_list.size(); i++) {
//				in_sum += in_list.get(i);
//			}
//			if (sum == in_sum) {
//				outer_list.add(new ArrayList<>(in_list));
//			}
//		}
//		in_list.remove((Integer)root.val);
//		pre_tree(root.left, in_list, sum, outer_list);
//		pre_tree(root.right, in_list, sum, outer_list);
//	}

	// **********************************************************************
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> outer_list = new ArrayList<List<Integer>>();
		List<Integer> in_list = new ArrayList<Integer>();
		pre_tree(root, in_list, sum, outer_list);
		return outer_list;
	}

	// 前序遍历，容器在原有基础上递增
	void pre_tree(TreeNode root, List<Integer> in_list, int sum, List<List<Integer>> outer_list) {
		if (root == null)
			return;

		List<Integer> new_in = new ArrayList<Integer>(in_list);
		new_in.add(root.val);
		// System.out.println("***" + root.val);

		if (root.right == null && root.left == null) {
			int in_sum = 0;
			for (int i = 0; i < new_in.size(); i++) {
				in_sum += new_in.get(i);
			}
			if (sum == in_sum) {
				outer_list.add(new_in);
			}
		}

		pre_tree(root.left, new_in, sum, outer_list);
		pre_tree(root.right, new_in, sum, outer_list);
	}

}