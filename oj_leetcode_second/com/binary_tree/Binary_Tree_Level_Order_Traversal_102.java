package com.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Level_Order_Traversal_102 {

	public List<List<Integer>> levelOrder_3(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		levelHelper(res, root, 0);
		return res;
	}

	// 二叉树的先序 递归算法，用于层次遍历，因为传下去一个高度，所以可用
	public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
		if (root == null)
			return;
		if (height >= res.size()) {
			res.add(new LinkedList<Integer>());
		}
		res.get(height).add(root.val);
		levelHelper(res, root.left, height + 1);
		levelHelper(res, root.right, height + 1);
	}

	// *****************************************************************
	public List<List<Integer>> levelOrder_2(TreeNode root) {
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
			wrapList.add(subList);
		}
		return wrapList;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<>();
		if (root == null)
			return re;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int cur = 0;
			int count = queue.size();
			List<Integer> in = new ArrayList<>();// 一层
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