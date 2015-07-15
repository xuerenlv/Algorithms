package com.leetcode.link_2;

public class Maximum_Depth_of_Binary_Tree_104 {

	public static void main(String[] args) {

	}

}


class Solution_Maximum_Depth_of_Binary_Tree_104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}