package com.leetcode.link_2;

public class Sum_Root_to_Leaf_Numbers_129 {

	public static void main(String[] args) {

	}

}

class Solution_Sum_Root_to_Leaf_Numbers_129 {
	// accepted
	public int sumNumbers(TreeNode root) {
		int root_sum = 0;
		return gen_sum(root, root_sum);
	}

	int gen_sum(TreeNode root, int root_sum) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root_sum * 10 + root.val;
		} else if (root.left != null && root.right != null) {
			return gen_sum(root.left, root_sum * 10 + root.val) + gen_sum(root.right, root_sum * 10 + root.val);
		} else if (root.left != null && root.right == null) {
			return gen_sum(root.left, root_sum * 10 + root.val);
		} else {
			return gen_sum(root.right, root_sum * 10 + root.val);
		}

	}
}