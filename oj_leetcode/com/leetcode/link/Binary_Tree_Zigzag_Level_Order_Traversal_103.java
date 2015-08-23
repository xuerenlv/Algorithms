package com.leetcode.link;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Zigzag_Level_Order_Traversal_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<>();
		if (root == null)
			return re;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		boolean left_to_right = true;
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

			if (!left_to_right) {
				List<Integer> in_temp = new ArrayList<Integer>(in);
				in.clear();
				for (int i = in_temp.size() - 1; i >= 0; i--) {
					in.add(in_temp.get(i));
				}
			}
			left_to_right = !left_to_right;
			re.add(in);
		}
		return re;
	}
}