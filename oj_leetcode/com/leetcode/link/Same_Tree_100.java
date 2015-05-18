package com.leetcode.link;

public class Same_Tree_100 {

	public static void main(String[] args) {

	}

}

class Solution_Same_Tree_100 {
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