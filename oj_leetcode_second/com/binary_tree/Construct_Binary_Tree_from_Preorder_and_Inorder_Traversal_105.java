package com.binary_tree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

	public static void main(String[] args) {

	}

}

// 利用先序序列，中序序列，构造二叉树
class Solution_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
	// 没有理解
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
		stack.push(root);
		int i = 0, j = 0;
		TreeNode node = null;
		TreeNode cur = root;
		while (j < inorder.length) {
			if (stack.peek().val == inorder[j]) {
				node = stack.pop();
				j++;
			} else if (node != null) {
				cur = new TreeNode(preorder[i]);
				node.right = cur;
				node = null;
				stack.push(cur);
				i++;
			} else {
				cur = new TreeNode(preorder[i]);
				stack.peek().left = cur;
				stack.push(cur);
				i++;
			}
		}
		return root.left;
	}

	// ************************************************************************************************
	// 一遍过，好，虽然是递归算法
	public TreeNode buildTree_accepted(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	TreeNode buildTree(int[] preorder, int pre_s, int pre_e, int[] inorder, int in_s, int in_e) {
		if (pre_e < pre_s)
			return null;
		if (pre_e == pre_s) {// 只有一个值的时候
			return new TreeNode(preorder[pre_e]);
		}

		int root_val = preorder[pre_s];
		int i;// 需要用到这个位序，所以放外面
		for (i = in_s; i <= in_e; i++) {
			if (inorder[i] == root_val)
				break;
		}
		TreeNode root = new TreeNode(root_val);
		root.left = buildTree(preorder, pre_s + 1, pre_s + i - in_s, inorder, in_s, i - 1);
		root.right = buildTree(preorder, pre_s + i - in_s + 1, pre_e, inorder, i + 1, in_e);
		return root;
	}
}