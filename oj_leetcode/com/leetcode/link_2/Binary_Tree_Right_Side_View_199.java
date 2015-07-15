package com.leetcode.link_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Binary_Tree_Right_Side_View_199 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Right_Side_View_199 {
	// accepted
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> re = new ArrayList<Integer>();
		if (root == null)
			return re;
		Deque<TreeNode> qu = new ArrayDeque<TreeNode>();

		qu.add(root);
		int cur;
		int count;

		while (!qu.isEmpty()) {
			cur = 0;
			count = qu.size();
			while (cur < count - 1) {
				TreeNode p = qu.getFirst();
				qu.pop();

				if (p.left != null) {
					qu.add(p.left);
				}
				if (p.right != null)
					qu.add(p.right);
				cur++;
			}
			TreeNode p = qu.getFirst();
			qu.pop();

			re.add(p.val);

			if (p.left != null) {
				qu.add(p.left);
			}
			if (p.right != null)
				qu.add(p.right);
		}

		return re;
	}
}