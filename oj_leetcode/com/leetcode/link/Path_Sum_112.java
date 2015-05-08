package com.leetcode.link;

public class Path_Sum_112 {

	public static void main(String[] args) {
	}

}

class Solution_Path_Sum_112 {
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