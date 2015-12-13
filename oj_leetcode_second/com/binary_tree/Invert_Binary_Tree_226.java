package com.binary_tree;

public class Invert_Binary_Tree_226 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		root = new Solution_Invert_Binary_Tree_226().invertTree(root);

		System.out.println(root.left.val);
	}

}

class Solution_Invert_Binary_Tree_226 {
	// 更简化了一些
	public TreeNode invertTree_2(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmp);
		return root;
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		if (root.left != null && root.right == null) {
			TreeNode temp = root.left;
			root.left = null;
			root.right = invertTree(temp);// 递归进行
			return root;
		} else if (root.left == null && root.right != null) {
			TreeNode temp = root.right;
			root.right = null;
			root.left = invertTree(temp);
			return root;
		} else {
			TreeNode temp = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(temp);
			return root;
		}
	}

}