package com.binary_tree;

public class Count_Complete_Tree_Nodes_222 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		System.out.println(new Solution_Count_Complete_Tree_Nodes_222().countNodes(root));
	}

}

class Solution_Count_Complete_Tree_Nodes_222 {
	// 计算一个完全二叉树的节点个数
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int left = get_left(root);
		int right = get_right(root);

		if (left == right) {
			return (2 << left) - 1;// 对于满二叉树
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	// 获取左边的最大深度
	int get_left(TreeNode root) {
		int count = 0;
		while (root.left != null) {
			count++;
			root = root.left;
		}
		return count;
	}

	// 获取右边的最大深度
	int get_right(TreeNode root) {
		int count = 0;
		while (root.right != null) {
			count++;
			root = root.right;
		}
		return count;
	}
}