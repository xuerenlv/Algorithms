package com.leetcode.one;

public class Invert_Binary_Tree_226 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(2);
		
		root = new Solution_Invert_Binary_Tree_226().invertTree(root);

		System.out.println(root.left.val);
	}

}

/**
 * Definition for a binary tree node. }
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution_Invert_Binary_Tree_226 {

	public TreeNode invertTree(TreeNode root) {
		if(root==null ||(root.left == null && root.right == null))
			return root;
		if(root.left != null && root.right != null){
			TreeNode temp = root.left;
			root.left = invertTree(root.right);
			root.right =invertTree(temp);
			return root;
		}
		if(root.left != null && root.right == null){
			System.out.println("hello");
			TreeNode temp = root.left;
			root.left = null;
			root.right = invertTree(temp);
			return root;
		}
		if(root.left == null && root.right != null){
			TreeNode temp = root.right;
			root.right = null;
			root.left = invertTree(temp);
			return root;
		}
		return root;
	}
	
	
}