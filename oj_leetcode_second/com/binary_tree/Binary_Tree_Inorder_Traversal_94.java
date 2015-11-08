package com.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Inorder_Traversal_94 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> re = new ArrayList<>();
		// bin_inorder_with_recresion(root, re);
		bin_inorder_with_iterative(root, re);
		return re;

	}

	// 中序遍历非递归
	void bin_inorder_with_iterative(TreeNode root, List<Integer> re) {
		// 中序遍历非递归，使用 栈
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) { // 左分支全部进栈
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				re.add(p.val);
				p = p.right;// 处理过根节点之后，处理右分支
			}
		}
	}

	// 递归不重要
	void bin_inorder_with_recresion(TreeNode root, List<Integer> re) {
		if (root == null)
			return;
		if (root.left != null) {
			bin_inorder_with_recresion(root.left, re);
		}
		re.add(root.val);
		if (root.right != null) {
			bin_inorder_with_recresion(root.right, re);
		}
	}
}