package com.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II_107 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Level_Order_Traversal_II_107 {

	public List<List<Integer>> levelOrderBottom_3(TreeNode root) {
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		levelMaker(wrapList, root, 0);
		return wrapList;
	}

	public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null)
			return;
		if (level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level + 1);
		levelMaker(list, root.right, level + 1);
		// 从后向前的获得
		list.get(list.size() - level - 1).add(root.val);
	}

	public List<List<Integer>> levelOrderBottom_2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if (root == null)
			return wrapList;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			// 其实不需要在最后加一个逆序，只需要 LinkedList的从前面加
			wrapList.add(0, subList);
		}
		return wrapList;
	}

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

		// 只是在最后加了一个逆序，没什么实际的改变
		List<List<Integer>> re_1 = new ArrayList<>();
		for (int i = re.size() - 1; i >= 0; i--) {
			re_1.add(re.get(i));
		}
		return re_1;
	}
}