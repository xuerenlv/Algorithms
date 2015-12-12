package com.binary_tree;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {

	public static void main(String[] args) {

	}

}

class Solution_Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
	// 更加好的做法，，改写成迭代的形式
	public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (root.val > p.val && root.val > q.val)
				root = root.left;
			else if (root.val < p.val && root.val < q.val)
				root = root.right;
			else
				return root;
		}
	}

	// 更好的做法
	public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q)
			return root;
		boolean left = does_has_both(root.left, p, q);
		boolean right = does_has_both(root.right, p, q);

		if (!left && !right)
			return root;
		if (left)
			return lowestCommonAncestor(root.left, p, q);
		else
			return lowestCommonAncestor(root.right, p, q);
	}

	boolean does_has_both(TreeNode root, TreeNode p, TreeNode q) {
		return does_have_one(root, p) && does_have_one(root, q);
	}

	// root中是否包含当前节点
	boolean does_have_one(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return does_have_one(root.left, p) || does_have_one(root.right, p);
	}
}