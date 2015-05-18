package com.leetcode.link;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

	public static void main(String[] args) {
		
	}

}

// 利用先序序列，中序序列，构造二叉树
class Solution_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
	// 一遍过，好，虽然是递归算法
	public TreeNode buildTree_accepted(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	TreeNode buildTree(int[] preorder, int pre_s, int pre_e, int[] inorder, int in_s, int in_e) {
		if (pre_e < pre_s)
			return null;
		if (pre_e == pre_s) {
			return new TreeNode(preorder[pre_e]);
		}

		int r = preorder[pre_s];
		int i;
		for (i = in_s; i <= in_e; i++) {
			if (inorder[i] == r)
				break;
		}
		TreeNode root = new TreeNode(r);
		root.left = buildTree(preorder, pre_s + 1, pre_s + i - in_s, inorder, in_s, i - 1);
		root.right = buildTree(preorder, pre_s + i - in_s + 1, pre_e, inorder, i + 1, in_e);
		return root;
	}
}