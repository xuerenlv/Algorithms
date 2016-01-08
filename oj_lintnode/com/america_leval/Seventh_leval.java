package com.america_leval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Seventh_leval {

	public static void main(String[] args) {

	}

}

// 二叉树的序列化和反序列化
class Solution_Seventh_leval_9 {
	/**
	 * This method will be invoked first, you should design your own algorithm
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
	public String serialize(TreeNode root) {
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
	}
}

// 二叉查找树中搜索区间
class Solution_Seventh_leval_8 {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param k1
	 *            and k2: range k1 to k2.
	 * @return: Return all keys that k1<=key<=k2 in ascending order.
	 */
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> re = new ArrayList<>();
		// 中序遍历非递归，使用 栈
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) { // 左分支全部进栈
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();

				if (p.val > k2)
					return re;
				if (p.val >= k1)
					re.add(p.val);

				p = p.right;// 处理过根节点之后，处理右分支
			}
		}

		return re;

	}
}

// 二叉树的层次遍历
class Solution_Seventh_leval_7 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: Level order a list of lists of integer
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<>();
		if (root == null)
			return re;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int cheng_num = 0;
		TreeNode p;
		while (!queue.isEmpty()) {
			ArrayList<Integer> in = new ArrayList<>();
			cheng_num = queue.size();
			while (cheng_num > 0) {
				p = queue.poll();
				in.add(p.val);
				if (p.left != null)
					queue.add(p.left);
				if (p.right != null)
					queue.add(p.right);
				cheng_num--;
			}
			re.add(in);
		}
		return re;
	}
}

// 前序遍历和中序遍历树构造二叉树
class Solution_Seventh_leval_6 {
	/**
	 * @param preorder
	 *            : A list of integers that preorder traversal of a tree
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	TreeNode buildTree(int[] preorder, int pre_s, int pre_e, int[] inorder, int in_s, int in_e) {
		if (pre_e < pre_s)
			return null;
		if (pre_e == pre_s) {// 只有一个值的时候
			return new TreeNode(preorder[pre_e]);
		}

		int root_val = preorder[pre_s];
		int i;// 需要用到这个位序，所以放外面
		for (i = in_s; i <= in_e; i++) {
			if (inorder[i] == root_val)
				break;
		}
		TreeNode root = new TreeNode(root_val);
		root.left = buildTree(preorder, pre_s + 1, pre_s + i - in_s, inorder, in_s, i - 1);
		root.right = buildTree(preorder, pre_s + i - in_s + 1, pre_e, inorder, i + 1, in_e);
		return root;
	}
}

// 平衡二叉树
class Solution_Seventh_leval_5 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}

// 验证二叉查找树
class Solution_Seventh_leval_4 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {

		return isValidBst_with_qujian(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean isValidBst_with_qujian(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (!(min < root.val && root.val < max))
			return false;

		return isValidBst_with_qujian(root.left, min, root.val) && isValidBst_with_qujian(root.right, root.val, max);
	}
}

// 二叉树的前序遍历
class Solution_Seventh_leval_3 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> re = new ArrayList<>();
		if (root == null)
			return re;

		TreeNode p = root;
		Stack<TreeNode> con_stack = new Stack<>();
		while (p != null || !con_stack.isEmpty()) {
			while (p != null) {
				re.add(p.val);
				con_stack.add(p.right);
				p = p.left;
			}
			if (!con_stack.isEmpty())
				p = con_stack.pop();

		}

		return re;

	}
}

// 在二叉查找树中插入节点
class Solution_Seventh_leval_2 {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param node:
	 *            insert this node into the binary search tree
	 * @return: The root of the new binary search tree.
	 */
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;

		if (node.val < root.val) {
			if (root.left == null) {
				root.left = node;
			} else {
				insertNode(root.left, node);
			}
		} else {
			if (root.right == null) {
				root.right = node;
			} else {
				insertNode(root.right, node);
			}
		}
		return root;
	}
}

// 二叉树的最大深度
class Solution_Seventh_leval_1 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}