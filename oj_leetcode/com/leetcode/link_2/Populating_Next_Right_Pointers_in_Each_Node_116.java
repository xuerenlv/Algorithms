package com.leetcode.link_2;

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