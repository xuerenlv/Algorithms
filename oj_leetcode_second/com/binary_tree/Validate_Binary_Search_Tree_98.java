package com.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Validate_Binary_Search_Tree_98 {

	public static void main(String[] args) {

	}

}

class Solution_Validate_Binary_Search_Tree_98 {

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
	// *****************************************************************************

	// 非常好，这种解法很清晰
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	// **************************************************************************
	// 二叉查找树的中序遍历序列，是递增有序的
	public boolean isValidBST_accepted(TreeNode root) {
		ArrayList<Integer> con_pri = new ArrayList<Integer>();
		priview(root, con_pri);
		boolean flag = true;
		for (int i = 0; i < con_pri.size() - 1; i++) {
			if (con_pri.get(i) >= con_pri.get(i + 1)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	// 递归中序遍历
	void priview(TreeNode root, ArrayList<Integer> container) {
		if (root == null)
			return;
		priview(root.left, container);
		container.add(root.val);
		priview(root.right, container);
	}

	// ***************************************************************************
	// 错误，是不是bst，还与整体有关
	public boolean isValidBST_wrong(TreeNode root) {
		if (root == null)
			return true;
		boolean flag = true;
		if (root.left != null && root.left.val >= root.val) {
			flag = false;
		}
		if (root.right != null && root.right.val <= root.val) {
			flag = false;
		}

		if (flag) {
			boolean left = true;
			if (root.left != null)
				left = isValidBST_wrong(root.left);
			if (!left)
				return false;
			boolean right = true;
			if (root.right != null)
				right = isValidBST_wrong(root.right);
			if (!right)
				return false;

			return true;
		} else {
			return flag;
		}
	}
}