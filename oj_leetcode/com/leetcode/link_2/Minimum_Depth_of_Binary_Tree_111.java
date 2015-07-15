package com.leetcode.link_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Minimum_Depth_of_Binary_Tree_111 {

	public static void main(String[] args) {

	}

}

class Solution_Minimum_Depth_of_Binary_Tree_111 {
	// 活用二叉树的层序遍历
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Deque<TreeNode> qu = new ArrayDeque<TreeNode>();
		qu.add(root);

		int ceng = 0;
		int cur;
		int count;
		while (!qu.isEmpty()) {
			ceng++;
			cur = 0;
			count = qu.size();
			while (cur < count) {
				TreeNode p = qu.getFirst();
				qu.pop();
				
				if(p.left == null && p.right == null){
				    return ceng;
				}

				if (p.left != null) {
					qu.add(p.left);
				}
				if (p.right != null)
					qu.add(p.right);
				cur++;
			}
		}

		return ceng;
	}
}