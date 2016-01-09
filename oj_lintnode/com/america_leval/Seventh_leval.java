package com.america_leval;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Seventh_leval {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.left.left = new TreeNode(3);
		p.left.left.left = new TreeNode(4);
		System.out.println(new Solution_Seventh_leval_9().serialize(p));
	}

}

// 二叉树的锯齿形层次遍历
class Solution_Seventh_leval_14 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: A list of lists of integer include the zigzag level order
	 *          traversal of its nodes' values
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<>();
		if (root == null)
			return re;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		boolean left_to_right = true;
		while (!queue.isEmpty()) {
			int cur = 0;
			int count = queue.size();
			ArrayList<Integer> in = new ArrayList<>();
			while (cur < count) {
				TreeNode p = queue.remove();
				if (left_to_right) {
					in.add(p.val);
				} else {
					in.add(0, p.val);
				}
				if (p.left != null) {
					queue.add(p.left);
				}
				if (p.right != null)
					queue.add(p.right);
				cur++;
			}
			left_to_right = !left_to_right;
			re.add(in);
		}
		return re;
	}
}

// 中序遍历和后序遍历树构造二叉树
class Solution_Seventh_leval_13 {
	/**
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @param postorder
	 *            : A list of integers that postorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	TreeNode buildTree(int[] inorder, int in_s, int in_e, int[] postorder, int p_s, int p_e) {
		if (p_s > p_e)
			return null;
		if (p_s == p_e)
			return new TreeNode(postorder[p_s]);

		int ch = postorder[p_e];
		int i;
		for (i = in_s; i <= in_e; i++) {
			if (inorder[i] == ch) {
				break;
			}
		}
		TreeNode root = new TreeNode(ch);
		// 先序，后序，这个地方的处理，还是不一样的
		root.left = buildTree(inorder, in_s, i - 1, postorder, p_s, p_s + i - in_s - 1);
		root.right = buildTree(inorder, i + 1, in_e, postorder, p_s + i - in_s, p_e - 1);
		return root;
	}
}

class Solution_Seventh_leval_12 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: Inorder in ArrayList which contains node values.
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
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
				re.add(p.val);
				p = p.right;// 处理过根节点之后，处理右分支
			}
		}
		return re;
	}
}

// 二叉树的最小深度
class Solution_Seventh_leval_11 {
	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left != null && root.right != null)
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		if (root.left != null)
			return minDepth(root.left) + 1;
		if (root.right != null)
			return minDepth(root.right) + 1;
		return 0;
	}
}

// 删除二叉查找树的节点
class Solution_Seventh_leval_10 {
	/**
	 * @param root:
	 *            The root of the binary search tree.
	 * @param value:
	 *            Remove the node with given value.
	 * @return: The root of the binary search tree after removal.
	 */
	public TreeNode removeNode(TreeNode root, int value) {
		if (root == null)
			return null;
		if (root.val == value) {
			if (root.left == null && root.right == null)
				return null;
			if (root.right != null && root.left != null) {
				// 把最右子节点删除
				TreeNode pre = root.left, cur = root.left;
				while (cur.right != null) {
					pre = cur;
					cur = cur.right;
				}

				root.val = cur.val;
				if (pre == cur) {
					root.left = cur.left;
				} else {
					pre.right = cur.left;
				}
			} else if (root.left != null) {
				return root.left;
			} else {
				return root.right;
			}

		} else {
			if (value > root.val) {
				root.right = removeNode(root.right, value);
			} else {
				root.left = removeNode(root.left, value);
			}
		}
		return root;
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
		String re = "{";
		if (root == null)
			return re + "}";
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode p;
		re += root.val + ",";
		while (!queue.isEmpty()) {
			p = queue.poll();
			if (p.left == null) {
				re += "#,";
			} else {
				re += new Integer(p.left.val).toString() + ",";
			}
			if (p.right == null) {
				re += "#,";
			} else {
				re += new Integer(p.right.val).toString() + ",";
			}
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);
		}
		re = re.substring(0, re.length() - 1);
		while (re.substring(re.lastIndexOf(",") + 1, re.length()).equals("#")) {
			re = re.substring(0, re.lastIndexOf(","));
		}

		return re + "}";
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		String[] values = data.substring(1, data.length() - 1).split(",");
		if (values.length == 0)
			return null;
		return construct_bin_tree(values, 0);
	}

	TreeNode construct_bin_tree(String[] data, int start) {
		if (data.length < 1 || start < 0 || data.length <= start || data[start].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(new Integer(data[start]));
		root.left = construct_bin_tree(data, start * 2 + 1);
		root.right = construct_bin_tree(data, start * 2 + 2);
		return root;
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