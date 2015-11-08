package com.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal_144 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Preorder_Traversal_144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> re = new ArrayList<Integer>();
		// digui(root, re);
		fei_digui(root, re);
		return re;
	}

	// 前序非递归，也是使用栈，中序非递归同样是使用栈
	void fei_digui(TreeNode root, List<Integer> re) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				re.add(p.val);
				stack.add(p.right);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
			}
		}
	}

	// 递归，naive
	void digui(TreeNode root, List<Integer> re) {
		if (root == null)
			return;
		re.add(root.val);
		digui(root.left, re);
		digui(root.right, re);
	}
}