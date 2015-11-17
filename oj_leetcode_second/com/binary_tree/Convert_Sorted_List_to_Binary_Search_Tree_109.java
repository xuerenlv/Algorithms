package com.binary_tree;

import java.util.ArrayList;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

	public static void main(String[] args) {

	}

}

// 对于已排序的单链表，生成二叉查找树
class Solution_Convert_Sorted_List_to_Binary_Search_Tree_109 {
	private ListNode node;

	public TreeNode sortedListToBST_2(ListNode head) {
		if (head == null) {
			return null;
		}

		int size = 0;
		ListNode runner = head;
		node = head;

		while (runner != null) {
			runner = runner.next;
			size++;
		}

		return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode left = inorderHelper(start, mid - 1);

		TreeNode treenode = new TreeNode(node.val);
		treenode.left = left;
		node = node.next;

		TreeNode right = inorderHelper(mid + 1, end);
		treenode.right = right;

		return treenode;
	}

	// ***********************************************************************
	public TreeNode sortedListToBST(ListNode head) {
		ArrayList<TreeNode> treenodes = new ArrayList<TreeNode>();
		for (ListNode node = head; node != null; node = node.next) {
			treenodes.add(new TreeNode(node.val));
		}

		return gen_BST(0, treenodes.size() - 1, treenodes);
	}

	public TreeNode gen_BST(int start, int end, ArrayList<TreeNode> nodes) {
		if (start > end)
			return null;
		if (start == end)
			return nodes.get(start);
		if (start + 1 == end) {
			nodes.get(start).right = nodes.get(end);
			return nodes.get(start);
		}
		int mid = (start + end) / 2;
		TreeNode root = nodes.get(mid);
		root.right = gen_BST(mid + 1, end, nodes);
		root.left = gen_BST(start, mid - 1, nodes);
		return root;
	}
}