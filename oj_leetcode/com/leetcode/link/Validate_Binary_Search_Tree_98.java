package com.leetcode.link;

import java.util.ArrayList;

public class Validate_Binary_Search_Tree_98 {

	public static void main(String[] args) {

	}

}

class Solution_Validate_Binary_Search_Tree_98 {
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

	void priview(TreeNode root, ArrayList<Integer> container) {
		if (root == null)
			return;
		priview(root.left, container);

		container.add(root.val);

		priview(root.right, container);
	}

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