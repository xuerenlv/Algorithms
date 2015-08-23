package com.leetcode.link;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Level_Order_Traversal_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<>();
		if (root == null)
			return re;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int cur = 0;
			int count = queue.size();
			List<Integer> in = new ArrayList<>();
			while (cur < count) {
				TreeNode p = queue.remove();
				in.add(p.val);

				if (p.left != null) {
					queue.add(p.left);
				}
				if (p.right != null)
					queue.add(p.right);
				cur++;
			}
			re.add(in);
		}
		return re;
	}
}