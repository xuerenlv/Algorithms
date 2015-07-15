package com.leetcode.link_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal_145 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		
		List<Integer> pos = new Solution_Binary_Tree_Postorder_Traversal_145().postorderTraversal(root);
		
		System.out.println(Arrays.toString(pos.toArray()));
	}

}

class Solution_Binary_Tree_Postorder_Traversal_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> re = new ArrayList<Integer>();
//		digui(root, re);
		fei_digui(root, re);
		return re;
	}

	// 后序非递归
	void fei_digui(TreeNode root, List<Integer> re) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = null;
		TreeNode pre = null;
		if(root==null){
			return;
		}else{
			stack.push(root);
		}
		while (!stack.empty()) {
			cur = stack.peek();
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				re.add(cur.val); // 如果当前结点没有孩子结点或者孩子节点都已被访问过
				stack.pop();
				pre = cur;
			} else {
				if (cur.right != null)
					stack.add(cur.right);
				if (cur.left != null){
					stack.push(cur.left);
				}
			}
		}
	}

	void digui(TreeNode root, List<Integer> re) {
		if (root == null)
			return;
		digui(root.left, re);
		digui(root.right, re);
		re.add(root.val);
	}

}