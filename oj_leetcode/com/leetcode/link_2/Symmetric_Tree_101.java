package com.leetcode.link_2;

public class Symmetric_Tree_101 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(5);

		System.out.println(new Solution_Symmetric_Tree_101().isSymmetric(root));
	}

}

class Solution_Symmetric_Tree_101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return is_sym(root.left, root.right);
	}

	boolean is_sym(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		} else {
			if (a != null && b != null && a.val == b.val) {
				return is_sym(a.left, b.right) && is_sym(a.right, b.left);
			} else {
				return false;
			}
		}
	}
}