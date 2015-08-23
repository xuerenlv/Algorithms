package com.leetcode.link;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II_107 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Level_Order_Traversal_II_107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

		List<List<Integer>> re_1 = new ArrayList<>();
		for (int i = re.size() - 1; i >= 0; i--) {
			re_1.add(re.get(i));
		}
		return re_1;
	}
}