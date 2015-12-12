package com.binary_tree;


public class Kth_Smallest_Element_in_a_BST_230 {

	public static void main(String[] args) {

	}

}

class Solution_Kth_Smallest_Element_in_a_BST_230 {
	public int kthSmallest(TreeNode root, int k) {
		int left = calc(root.left);
		if (k == left + 1)
			return root.val;
		if (k <= left) {
			return kthSmallest(root.left, k);
		}
		return kthSmallest(root.right, k - left - 1);
	}

	// 计算一个二叉树中节点的数量
	private int calc(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + calc(root.left) + calc(root.right);
	}
}