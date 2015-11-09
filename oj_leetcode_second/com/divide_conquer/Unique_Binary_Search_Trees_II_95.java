package com.divide_conquer;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II_95 {

	public static void main(String[] args) {

		List<TreeNode> re = new Solution_Unique_Binary_Search_Trees_II_95().generateTrees(4);

		// 还没有很多null的，有趣
		for (int i = 0; i < re.size(); i++) {
			if (re.get(i) == null)
				System.out.print("  null  ");
			else
				System.out.print(re.get(i).val + " ");
		}
	}

}

class Solution_Unique_Binary_Search_Trees_II_95 {
	// 看人家的，看来递归的使用还是很奇妙的。
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	// 感觉使用的是回溯法,是分治法
	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		if (start > end) {// start可以等于end，表明当前只处理一个 节点
			trees.add(null);
			return trees;
		}

		for (int rootValue = start; rootValue <= end; rootValue++) {
			List<TreeNode> leftSubTrees = generateTrees(start, rootValue - 1);
			List<TreeNode> rightSubTrees = generateTrees(rootValue + 1, end);

			for (TreeNode leftSubTree : leftSubTrees) {
				for (TreeNode rightSubTree : rightSubTrees) {
					TreeNode root = new TreeNode(rootValue);
					root.left = leftSubTree;
					root.right = rightSubTree;
					trees.add(root);
				}
			}
		}
		return trees;
	}
}