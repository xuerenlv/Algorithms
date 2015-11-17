package com.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

	public static void main(String[] args) {

	}

}

class Solution_Convert_Sorted_Array_to_Binary_Search_Tree_108 {
	public TreeNode sortedArrayToBST_3(int[] nums) {

		final int len = nums.length;
		if (len == 0) {
			return null;
		}

		// 0 as a placeholder
		final TreeNode head = new TreeNode(0);

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {
			{
				push(head);
			}
		};
		Deque<Integer> leftIndexStack = new LinkedList<Integer>() {
			{
				push(0);
			}
		};
		Deque<Integer> rightIndexStack = new LinkedList<Integer>() {
			{
				push(len - 1);
			}
		};

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid = left + (right - left) / 2; // avoid overflow
			currNode.val = nums[mid];
			if (left <= mid - 1) {
				currNode.left = new TreeNode(0);
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid - 1);
			}
			if (mid + 1 <= right) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid + 1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}

	// **********************************************************************************
	public TreeNode sortedArrayToBST_2(int[] num) {
		if (num.length == 0) {
			return null;
		}
		TreeNode head = helper(num, 0, num.length - 1);
		return head;
	}

	public TreeNode helper(int[] num, int low, int high) {
		if (low > high) { // Done
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = helper(num, low, mid - 1);
		node.right = helper(num, mid + 1, high);
		return node;
	}

	// ********************************************************************************
	// 这种是基于回溯的方法
	public TreeNode sortedArrayToBST(int[] nums) {
		ArrayList<TreeNode> treenodes = new ArrayList<TreeNode>();
		for (int i = 0; i < nums.length; i++) {
			treenodes.add(new TreeNode(nums[i]));
		}

		return gen_BST(0, treenodes.size() - 1, treenodes);
	}

	public TreeNode gen_BST(int start, int end, ArrayList<TreeNode> nodes) {
		if (start > end)
			return null;
		if (start == end)
			return nodes.get(start);
		// 这里注释掉，也是可行的
		// if (start + 1 == end) {// 只有两个节点的时候，也符合退出条件
		// nodes.get(start).right = nodes.get(end);
		// return nodes.get(start);
		// }
		int mid = (start + end) / 2;
		TreeNode root = nodes.get(mid);
		root.right = gen_BST(mid + 1, end, nodes);
		root.left = gen_BST(start, mid - 1, nodes);
		return root;
	}
}