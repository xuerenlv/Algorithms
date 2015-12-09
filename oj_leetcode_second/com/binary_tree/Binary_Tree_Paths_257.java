package com.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Paths_257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> re = new ArrayList<>();
		if (root == null)
			return re;
		String houxuan = "";
		tran_tree(root, houxuan, re);
		return re;
	}

	// 递归
	void tran_tree(TreeNode root, String houxuan, List<String> re) {
		if (houxuan.length() == 0) {
			houxuan = new Integer(root.val).toString();
		} else {
			houxuan += "->" + new Integer(root.val).toString();
		}
		if (root.left == null && root.right == null) {
			re.add(houxuan);
			return;
		}
		if (root.left != null) {
			tran_tree(root.left, houxuan, re);
		}
		if (root.right != null) {
			tran_tree(root.right, houxuan, re);
		}
	}
}