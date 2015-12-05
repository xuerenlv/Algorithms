package com.binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Binary_Search_Tree_Iterator_173 {

	public static void main(String[] args) {

	}

}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode(int x) {
//		val = x;
//	}
//}

// second version
// 就是把中序遍历分开操作
class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();
	int next_min;

	public BSTIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		if (!stack.isEmpty()) {
			TreeNode top = stack.pop();
			next_min = top.val;

			TreeNode cur = top.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			return true;
		}
		return false;
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		return next_min;
	}
}

// one_version
class BSTIterator_1 {
	Queue<Integer> min_queue = new ArrayDeque<>();

	public BSTIterator_1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode t = root;
		while (t != null || !stack.isEmpty()) {
			while (t != null) {
				stack.add(t);
				t = t.left;
			}
			if (!stack.isEmpty()) {
				t = stack.pop();
				min_queue.add(t.val);
				t = t.right;
			}
		}
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !min_queue.isEmpty();
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		return min_queue.remove();
	}
}