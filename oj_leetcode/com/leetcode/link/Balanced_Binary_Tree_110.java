package com.leetcode.link;

public class Balanced_Binary_Tree_110 {

	public static void main(String[] args) {

	}

}

class Solution_Balanced_Binary_Tree_110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(get_max_depth(root.left) - get_max_depth(root.right)) < 2 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	int get_max_depth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(get_max_depth(root.left), get_max_depth(root.right)) + 1;
	}
}