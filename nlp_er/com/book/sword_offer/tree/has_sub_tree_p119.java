package com.book.sword_offer.tree;

public class has_sub_tree_p119 {

	public static void main(String[] args) {

	}

}

class solution_has_sub_tree_p119 {
	// 判断root2是不是root1的子树
	boolean hasSubTree(TreeNode root1, TreeNode root2) {
		boolean re = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				re = does_contain(root1, root2);
			}
			if (!re) {
				re = hasSubTree(root1.left, root2);
			}
			if (!re) {
				re = hasSubTree(root1.right, root2);
			}
		}
		return re;
	}

	boolean does_contain(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}

		return does_contain(root1.left, root2.left) && does_contain(root1.right, root2.right);
	}
}