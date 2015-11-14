package com.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_of_Binary_Tree_104 {

	public static void main(String[] args) {

	}

}

class Solution_Maximum_Depth_of_Binary_Tree_104 {

	// 使用层序遍历，求取最大深度
	int maxDepth_2(TreeNode root) {
		int depth = 0;
		if (root == null)
			return depth;
		Queue<TreeNode> level = new LinkedList<>();
		level.add(root);
		while (!level.isEmpty()) {
			depth++;
			int n = level.size();
			for (int i = 0; i < n; i++) {
				TreeNode node = level.poll();
				if (node.left != null)
					level.add(node.left);
				if (node.right != null)
					level.add(node.right);
			}
		}
		return depth;
	}

	// ***********************************************************
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}