package com.leetcode.link_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Flatten_Binary_Tree_to_Linked_List_114 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = null;

		new Solution_Flatten_Binary_Tree_to_Linked_List_114().flatten(root);

		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}

}

class Solution_Flatten_Binary_Tree_to_Linked_List_114 {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

		vis_tree(root, queue);

		int i = 0;
		while (!(queue.isEmpty())) {

			TreeNode s = queue.pop();
			if (i == 0) {
				i++;
				continue;
			} else {
				root.right = s;
				root.left = null;
				root = root.right;
			}
		}

	}

	// 递归
	void vis_tree(TreeNode root, Deque<TreeNode> queue) {
		if (root == null) {
			return;
		} else {
			queue.add(new TreeNode(root.val));
			if (root.left != null) {
				vis_tree(root.left, queue);
			}
			if (root.right != null) {
				vis_tree(root.right, queue);
			}
		}
	}

	// 先序遍历，非递归
	public List<Integer> preorderTraversal(TreeNode node) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while (node != null) {
			list.add(node.val);
			if (node.right != null) {
				rights.push(node.right);
			}
			node = node.left;
			if (node == null && !rights.isEmpty()) {
				node = rights.pop();
			}
		}
		return list;
	}
}