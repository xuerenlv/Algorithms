package com.binary_tree;

import java.util.Stack;

public class Symmetric_Tree_101 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(5);

		System.out.println(new Solution_Symmetric_Tree_101().isSymmetric(root));
	}

}

class Solution_Symmetric_Tree_101 {

	// 非递归
	// 这里用栈可以，感觉用队列也是可以的
	public boolean isSymmetric_2(TreeNode root) {
		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left, right;
		if (root.left != null) {
			if (root.right == null)
				return false;
			stack.push(root.left);
			stack.push(root.right);
		} else if (root.right != null) {
			return false;
		}

		while (!stack.empty()) {
			// if (stack.size() % 2 != 0) 不需要
			// return false;
			right = stack.pop();
			left = stack.pop();
			if (right.val != left.val)
				return false;

			if (left.left != null) {
				if (right.right == null)
					return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if (right.right != null) {
				return false;
			}

			if (left.right != null) {
				if (right.left == null)
					return false;
				stack.push(left.right);
				stack.push(right.left);
			} else if (right.left != null) {
				return false;
			}
		}

		return true;
	}

	// *******************************************************************
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return is_sym(root.left, root.right);
	}

	// 就是要模拟镜子的映射
	boolean is_sym(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		} else {
			if (a != null && b != null && a.val == b.val) {
				return is_sym(a.left, b.right) && is_sym(a.right, b.left);
			} else {
				return false;
			}
		}
	}
}