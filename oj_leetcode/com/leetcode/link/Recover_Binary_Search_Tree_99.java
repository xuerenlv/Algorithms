package com.leetcode.link;

public class Recover_Binary_Search_Tree_99 {

	public static void main(String[] args) {

	}

}

class Solution_Recover_Binary_Search_Tree_99 {
	TreeNode mis_1;
	TreeNode mis_2;
	TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		recursive(root);
		if (mis_1 != null && mis_2 != null) {
			int temp = mis_1.val;
			mis_1.val = mis_2.val;
			mis_2.val = temp;
		}
	}

	void recursive(TreeNode root) {
		if (root == null)
			return;

		recursive(root.left);

		if (pre != null && root.val < pre.val) {
			if (mis_1 == null) {
				mis_1 = pre;
				mis_2 = root;
			} else {
				mis_2 = root;
			}
		}
		pre = root;
		recursive(root.right);
	}

}