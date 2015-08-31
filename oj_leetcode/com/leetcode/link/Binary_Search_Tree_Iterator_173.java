package com.leetcode.link;

public class Binary_Search_Tree_Iterator_173 {

	public static void main(String[] args) {

	}

}

class BSTIterator {
	TreeNode it;
	
	public BSTIterator(TreeNode root) {
		this.it = root;
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return it.left == null;
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		
	}
}