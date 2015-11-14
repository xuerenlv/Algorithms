package com.binary_tree;

import java.util.Stack;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

	public static void main(String[] args) {
		int[] in = { 2, 1 };
		int[] p = { 2, 1 };

		new Solution_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106().buildTree(in, p);
	}

}

class Solution_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
	// 非递归构造
	public TreeNode buildTree_iteration(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0)
			return null;
		int ip = inorder.length - 1;
		int pp = postorder.length - 1;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		TreeNode root = new TreeNode(postorder[pp]);
		stack.push(root);
		pp--;

		while (pp >= 0) {
			while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
				prev = stack.pop();
				ip--;
			}
			TreeNode newNode = new TreeNode(postorder[pp]);
			if (prev != null) {
				prev.left = newNode;
			} else if (!stack.isEmpty()) {
				TreeNode currTop = stack.peek();
				currTop.right = newNode;
			}
			stack.push(newNode);
			prev = null;
			pp--;
		}

		return root;
	}

	// ***************************************************************************************************
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	TreeNode buildTree(int[] inorder, int in_s, int in_e, int[] postorder, int p_s, int p_e) {
		if (p_s > p_e)
			return null;
		if (p_s == p_e)
			return new TreeNode(postorder[p_s]);

		int ch = postorder[p_e];
		int i;
		for (i = in_s; i <= in_e; i++) {
			if (inorder[i] == ch) {
				break;
			}
		}
		TreeNode root = new TreeNode(ch);
		// 先序，后序，这个地方的处理，还是不一样的
		root.left = buildTree(inorder, in_s, i - 1, postorder, p_s, p_s + i - in_s - 1);
		root.right = buildTree(inorder, i + 1, in_e, postorder, p_s + i - in_s, p_e - 1);
		return root;
	}
}