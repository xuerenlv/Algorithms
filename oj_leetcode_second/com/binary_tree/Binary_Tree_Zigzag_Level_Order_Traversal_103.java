package com.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Zigzag_Level_Order_Traversal_103 {

	public List<List<Integer>> zigzagLevelOrder_3(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> li = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return res;
		boolean lToR = true;
		int level = 1;

		queue.add(root);
		while (queue.size() != 0) {
			TreeNode node = queue.poll();
			if (lToR)
				li.add(node.val);
			else
				li.add(0, node.val);

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			if (--level == 0) {
				level = queue.size();
				res.add(new ArrayList<Integer>(li));
				li.clear();
				lToR = !lToR;
			}
		}
		return res;
	}

	// ****************************************************************************************
	public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
		List<List<Integer>> sol = new ArrayList<>();
		travel(root, sol, 0);
		return sol;
	}

	private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
		if (curr == null)
			return;

		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			sol.add(newLevel);
		}

		List<Integer> collection = sol.get(level);
		if (level % 2 == 0) // 偶数高度，添加在后面
			collection.add(curr.val);
		else// 奇数高度，田间在前面
			collection.add(0, curr.val);

		travel(curr.left, sol, level + 1);
		travel(curr.right, sol, level + 1);
	}

	// ****************************************************************************************
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