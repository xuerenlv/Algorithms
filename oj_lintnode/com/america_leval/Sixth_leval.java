package com.america_leval;

public class Sixth_leval {

	public static void main(String[] args) {

	}

}

// 复制带随机指针的链表
class Solution_Sixth_leval_8 {
	/**
	 * @param head:
	 *            The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		
		
		
		
		
	}
}

// 排序列表转换为二分查找树
class Solution_Sixth_leval_7 {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: a tree node
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ListNode mid = find_mid(head);
		TreeNode root = new TreeNode(mid.val);

		root.right = sortedListToBST(mid.next);
		if (head != mid) {
			ListNode p = head;
			while (p.next != mid)
				p = p.next;
			p.next = null;

			root.left = sortedListToBST(head);
		}
		return root;
	}

	ListNode find_mid(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}

// 旋转链表
class Solution_Sixth_leval_6 {
	/**
	 * @param head:
	 *            the List
	 * @param k:
	 *            rotate to the right k places
	 * @return: the list after rotation
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}

		k %= len;
		if (k == 0)
			return head;

		ListNode fast = head, slow = head;
		while (k >= 0) {
			fast = fast.next;
			k--;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		p = slow;
		while (p.next != null)
			p = p.next;
		p.next = head;

		p = slow;
		slow = slow.next;
		p.next = null;

		return slow;
	}
}

// 翻转链表
class Solution_Sixth_leval_5 {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		ListNode new_head = new ListNode(-1);

		ListNode p = head, s;
		while (p != null) {
			s = p;
			p = p.next;

			s.next = new_head.next;
			new_head.next = s;
		}
		return new_head.next;
	}
}

// 链表划分
class Solution_Sixth_leval_4 {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param x:
	 *            an integer
	 * @return: a ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode big_head = new ListNode(-1);
		ListNode small_head = new ListNode(-1);
		ListNode big_tail = big_head;
		ListNode small_tail = small_head;

		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				small_tail.next = p;
				p = p.next;
				small_tail = small_tail.next;
				small_tail.next = null;
			} else {
				big_tail.next = p;
				p = p.next;
				big_tail = big_tail.next;
				big_tail.next = null;
			}
		}

		small_tail.next = big_head.next;
		return small_head.next;
	}
}

// 删除排序链表中的重复元素
class Solution_Sixth_leval_3 {
	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		ListNode p = head;
		while (p != null) {
			if (p.next == null || (p.val != p.next.val)) {
				new_tail.next = new ListNode(p.val);
				new_tail = new_tail.next;
			}
			p = p.next;
		}
		return new_head.next;
	}
}

// 合并两个排序链表
class Solution_Sixth_leval_2 {
	/**
	 * @param ListNode
	 *            l1 is the head of the linked list
	 * @param ListNode
	 *            l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				new_tail.next = new ListNode(l1.val);
				l1 = l1.next;
				new_tail = new_tail.next;
			} else {
				new_tail.next = new ListNode(l2.val);
				l2 = l2.next;
				new_tail = new_tail.next;
			}
		}

		new_tail.next = l1 == null ? l2 : l1;
		return new_head.next;
	}
}

// 删除链表中倒数第n个节点
class Solution_Sixth_leval_1 {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param n:
	 *            An integer.
	 * @return: The head of linked list.
	 */
	ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head;

		while (n > 0 && fast != null) {
			fast = fast.next;
			n--;
		}

		// 异常
		if (n != 0)
			return null;

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		if (slow.next != null) {
			slow.val = slow.next.val;
			slow.next = slow.next.next;
		} else {
			if (head == slow) {
				return head.next;
			} else {
				fast = head;
				while (fast.next != slow)
					fast = fast.next;
				fast.next = fast.next.next;
			}
		}
		return head;
	}
}

// Definition for ListNode.
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

// Definition of TreeNode:
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

// Definition for singly-linked list with a random pointer.
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};