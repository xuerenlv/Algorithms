package com.binary_tree;

import java.util.Stack;

public class Same_Tree_100 {

	public static void main(String[] args) {

	}

}

class Solution_Same_Tree_100 {
	
	// iteration method
	public boolean isSameTree_2(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		Stack<TreeNode> stackP = new Stack<>();
		Stack<TreeNode> stackQ = new Stack<>();
		stackP.add(p);
		stackQ.add(q);
		while (!stackP.isEmpty() && !stackQ.isEmpty()) {
			TreeNode tmpP = stackP.pop();
			TreeNode tmpQ = stackQ.pop();
			if (tmpP.val != tmpQ.val)
				return false;

			// 对 left 节点的处理
			if (tmpP.left != null && tmpQ.left != null) {
				stackP.push(tmpP.left);
				stackQ.push(tmpQ.left);
			} else if (tmpP.left == null && tmpQ.left == null) {
			} else {
				return false;
			}

			// 对 right 节点的处理
			if (tmpP.right != null && tmpQ.right != null) {
				stackP.push(tmpP.right);
				stackQ.push(tmpQ.right);
			} else if (tmpP.right == null && tmpQ.right == null) {
			} else {
				return false;
			}
		}
		if (!stackP.isEmpty() || !stackQ.isEmpty())
			return false;
		return true;
	}

	// OK
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p != null && q != null) {
			if (p.val != q.val) {
				return false;
			} else {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
		}
		return false;
	}
}