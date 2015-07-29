package com.book.sword_offer.tree;

public class mirror_recursive_tree_p126 {

	public static void main(String[] args) {

	}

}

class solution_p126 {
	void mirror(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			return;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		if (root.left != null) {
			mirror(root.left);
		}
		if (root.right != null) {
			mirror(root.right);
		}
	}
}