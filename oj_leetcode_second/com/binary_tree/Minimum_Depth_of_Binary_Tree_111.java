package com.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Minimum_Depth_of_Binary_Tree_111 {

	public static void main(String[] args) {

	}

}

class Solution_Minimum_Depth_of_Binary_Tree_111 {
	// 递归，易于想到一点
	public static int minDepth_3(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return minDepth_3(root.right) + 1;
		if (root.right == null)
			return minDepth_3(root.left) + 1;
		return Math.min(minDepth_3(root.left), minDepth_3(root.right)) + 1;
	}

	// 递归用法，很精巧
	public int minDepth_2(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		// 若left或right为0，则只有一个了； 当两个都存在的时候才取min
		// 不可以去掉
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}

	// 活用二叉树的层序遍历，既可以求最大深度，也可以求最小深度
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Deque<TreeNode> qu = new ArrayDeque<TreeNode>();
		qu.add(root);

		int ceng = 0;
		int cur;
		int count;
		while (!qu.isEmpty()) {
			ceng++;
			cur = 0;
			count = qu.size();
			while (cur < count) {
				TreeNode p = qu.getFirst();
				qu.pop();

				if (p.left == null && p.right == null) {
					return ceng;
				}

				if (p.left != null) {
					qu.add(p.left);
				}
				if (p.right != null)
					qu.add(p.right);
				cur++;
			}
		}

		return ceng;
	}
}