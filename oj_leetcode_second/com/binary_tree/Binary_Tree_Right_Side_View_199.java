package com.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_199 {

	public static void main(String[] args) {

	}

}

class Solution_Binary_Tree_Right_Side_View_199 {

	// 可以更简洁一些
	public List<Integer> rightSideView_2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == size - 1) {
					// last element in current level
					result.add(node.val);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return result;
	}

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
			// 对最后一个向里面添加的单独处理
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