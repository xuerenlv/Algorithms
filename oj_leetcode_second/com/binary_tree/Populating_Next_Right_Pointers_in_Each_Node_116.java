package com.binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Populating_Next_Right_Pointers_in_Each_Node_116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

class Solution_Populating_Next_Right_Pointers_in_Each_Node_116 {

	// 基于递归的算法，也很有趣
	public void connect_3(TreeLinkNode root) {
		if (root == null)
			return;

		TreeLinkNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				cur.left.next = (cur.right != null) ? cur.right : getNext(cur);
			}

			if (cur.right != null) {
				cur.right.next = getNext(cur);
			}

			cur = cur.next;
		}

		connect(root.left);
		connect(root.right);
	}

	private TreeLinkNode getNext(TreeLinkNode root) {
		TreeLinkNode temp = root.next;

		while (temp != null) {
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;

			temp = temp.next;
		}

		return null;
	}

	// **********************************************************************
	// 不是很明白
	public void connect_2(TreeLinkNode root) {

		TreeLinkNode head = null; // head of the next level
		TreeLinkNode prev = null; // the leading node on the next level
		TreeLinkNode cur = root; // current node of current level

		while (cur != null) {

			while (cur != null) { // iterate on the current level
				// left child
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				// right child
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				// move to next node
				cur = cur.next;
			}

			// move to next level
			cur = head;
			head = null;
			prev = null;
		}

	}

	// 二叉树的层序遍历
	// 本解法对于116与117，均成立
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Deque<TreeLinkNode> qu = new ArrayDeque<TreeLinkNode>();

		qu.add(root);
		int cur;
		int count;
		while (!qu.isEmpty()) {
			cur = 0;
			count = qu.size();
			while (cur < count) {
				TreeLinkNode p = qu.getFirst();
				qu.pop();
				if (cur + 1 < count) {
					p.next = qu.getFirst();
				} else if (cur + 1 == count) {
					p.next = null;
				}
				if (p.left != null) {
					qu.add(p.left);
				}
				if (p.right != null)
					qu.add(p.right);
				cur++;
			}
		}

	}
}