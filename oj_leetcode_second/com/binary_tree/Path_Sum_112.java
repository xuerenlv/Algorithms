package com.binary_tree;

import java.util.Stack;

public class Path_Sum_112 {

	public static void main(String[] args) {
	}

}

class Solution_Path_Sum_112 {
	public boolean hasPathSum_2(TreeNode root, int sum) {
		// iteration method
		if (root == null) {
			return false;
		}
		Stack<TreeNode> path = new Stack<>();
		Stack<Integer> sub = new Stack<>();
		path.push(root);
		sub.push(root.val);
		while (!path.isEmpty()) {
			TreeNode temp = path.pop();
			int tempVal = sub.pop();
			if (temp.left == null && temp.right == null) {
				if (tempVal == sum)
					return true;
			} else {
				if (temp.left != null) {
					path.push(temp.left);
					sub.push(temp.left.val + tempVal);
				}
				if (temp.right != null) {
					path.push(temp.right);
					sub.push(temp.right.val + tempVal);
				}
			}
		}
		return false;
	}

	// ***************************************************************************************
	// 存在一个路径，权值之和与给定的值相等
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (sum == root.val)
				return true;
			else
				return false;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

}