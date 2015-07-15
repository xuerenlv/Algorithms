package com.leetcode.link;

import java.util.ArrayList;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

	public static void main(String[] args) {

	}

}

class Solution_Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
		ArrayList<TreeNode> treenodes = new ArrayList<TreeNode>();
		for (int i=0;i<nums.length;i++) {
			treenodes.add(new TreeNode(nums[i]));
		}

		return gen_BST(0, treenodes.size() - 1, treenodes);
    }
    
    public TreeNode gen_BST(int start, int end, ArrayList<TreeNode> nodes) {
		if (start > end)
			return null;
		if (start == end)
			return nodes.get(start);
		if (start + 1 == end) {
			nodes.get(start).right = nodes.get(end);
			return nodes.get(start);
		}
		int mid = (start + end) / 2;
		TreeNode root = nodes.get(mid);
		root.right = gen_BST(mid + 1, end, nodes);
		root.left = gen_BST(start, mid - 1, nodes);
		return root;
	}
}