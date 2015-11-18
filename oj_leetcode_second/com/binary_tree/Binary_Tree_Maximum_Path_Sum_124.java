package com.binary_tree;

public class Binary_Tree_Maximum_Path_Sum_124 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Maximum_Path_Sum_124 {

	// 别人的代码
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	// helper returns the max branch
	// plus current node's value
	int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);

		max = Math.max(max, root.val + left + right);

		return root.val + Math.max(left, right);
	}
}