package com.binary_tree;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {

	public static void main(String[] args) {

	}

}

class Solution_Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
	// 235 236 都可以使用
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q) // p，q 有一个就返回
			return root;
		TreeNode L = lowestCommonAncestor(root.left, p, q);
		TreeNode R = lowestCommonAncestor(root.right, p, q);
		if (L != null && R != null) // 两边各有一个
			return root;
		return L != null ? L : R;
	}

	// 使用与235同样的代码，超时
	public TreeNode lowestCommonAncestor_overtime(TreeNode root, TreeNode p, TreeNode q) {
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

	boolean does_have_one(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return does_have_one(root.left, p) || does_have_one(root.right, p);
	}
}