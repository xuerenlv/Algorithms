package com.binary_tree;

public class Recover_Binary_Search_Tree_99 {

	public static void main(String[] args) {

	}

}

class Solution_Recover_Binary_Search_Tree_99 {

	public void recoverTree_2(TreeNode root) {
		TreeNode first = null; // first node need to be swap
		TreeNode second = null; // second node need to be swap
		TreeNode pre = new TreeNode(Integer.MIN_VALUE); // previous node.

		while (root != null) {
			TreeNode node = root.left;

			// If left is not null, we need to find the rightmost node of left
			// subtree,
			// Set its right child to current node
			if (node != null) {

				// find the rightmost
				while (node.right != null && node.right != root) {
					node = node.right;
				}

				// There are two cases,
				// null: first time we access current, set node.right to current
				// and move to left child of current and continue;
				// current: we accessed current before, thus we've finished
				// traversing left subtree, set node.right back to null;
				if (node.right == null) {
					node.right = root;
					root = root.left;
					continue;
				} else {
					node.right = null;
				}
			}

			// compare current node with previous node
			if (root.val < pre.val) {
				// first time we enconter reversed order, we set previous node
				// to first
				if (first == null) {
					first = pre;
				}
				// In case that two nodes are successive, we set second to
				// current every time.
				second = root;
			}
			pre = root;
			root = root.right;
		}

		// swap the value;
		int temp = second.val;
		second.val = first.val;
		first.val = temp;
	}

	// *****************************************************************
	TreeNode mis_1;
	TreeNode mis_2;
	TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		recursive(root);
		if (mis_1 != null && mis_2 != null) {
			int temp = mis_1.val;
			mis_1.val = mis_2.val;
			mis_2.val = temp;
		}
	}

	void recursive(TreeNode root) {
		if (root == null)
			return;

		recursive(root.left);

		if (pre != null && root.val < pre.val) {
			if (mis_1 == null) {
				mis_1 = pre;
				mis_2 = root;
			} else {
				mis_2 = root;
			}
		}
		pre = root;
		recursive(root.right);
	}

}