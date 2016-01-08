package com.america_leval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Sixth_leval {

	public static void main(String[] args) {

	}

}

// 带环链表 II
class Solution_Sixth_leval_16 {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: The node where the cycle begins. if there is no cycle, return
	 *          null
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return null;

		ListNode fast = head, slow = head;
		
		do {
			if (fast != null && fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			} else {
				return null;
			}

		} while (fast != slow);
		
		

		if (slow != fast)
			return null;

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}

// 翻转链表 II
class Solution_Sixth_leval_15 {
	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @oaram m and n
	 * @return: The head of the reversed ListNode
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		ListNode p = head, s;
		n = n - m;

		while (m > 1) {
			s = p;
			p = p.next;
			s.next = null;
			new_tail.next = s;
			new_tail = new_tail.next;
			m--;
		}

		while (n >= 0) {
			s = p;
			p = p.next;
			s.next = new_tail.next;
			new_tail.next = s;
			n--;
		}

		while (new_tail.next != null)
			new_tail = new_tail.next;
		new_tail.next = p;

		return new_head.next;
	}
}

// 删除排序链表中的重复数字 II
class Solution_Sixth_leval_14 {
	/**
	 * @param ListNode
	 *            head is the head of the linked list
	 * @return: ListNode head of the linked list
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		ListNode q = head, p = head.next;
		if (p == null) {
			return head;
		}

		if (q.val != p.val) {
			new_tail.next = new ListNode(q.val);
			new_tail = new_tail.next;
		}

		while (p != null) {
			if (p.val != q.val) {
				if (p.next != null) {
					if (p.val != q.val && p.val != p.next.val) {
						new_tail.next = new ListNode(p.val);
						new_tail = new_tail.next;
					}
				} else {
					if (p.val != q.val) {
						new_tail.next = new ListNode(p.val);
						new_tail = new_tail.next;
					}
				}
			}
			p = p.next;
			q = q.next;
		}

		return new_head.next;

	}
}

// 链表倒数第n个节点
class Solution_Sixth_leval_13 {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @param n:
	 *            An integer.
	 * @return: Nth to last node of a singly linked list.
	 */
	ListNode nthToLast(ListNode head, int n) {

		if (head == null || n == 0) {
			return head;
		}
		ListNode p = head;
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}

		n %= len;
		if (n == 0)
			return head;

		ListNode fast = head, slow = head;
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;

	}
}

// 链表求和
class Solution_Sixth_leval_12 {
	/**
	 * @param l1:
	 *            the first list
	 * @param l2:
	 *            the second list
	 * @return: the sum list of l1 and l2
	 */
	public ListNode addLists(ListNode l1, ListNode l2) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		int wei = 0, sum = 0;
		while (l1 != null && l2 != null) {
			sum = wei + l1.val + l2.val;
			new_tail.next = new ListNode(sum % 10);
			new_tail = new_tail.next;
			wei = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			sum = wei + l1.val;
			new_tail.next = new ListNode(sum % 10);
			new_tail = new_tail.next;
			wei = sum / 10;
			l1 = l1.next;
		}

		while (l2 != null) {
			sum = wei + l2.val;
			new_tail.next = new ListNode(sum % 10);
			new_tail = new_tail.next;
			wei = sum / 10;
			l2 = l2.next;
		}
		if (wei != 0)
			new_tail.next = new ListNode(wei);

		return new_head.next;
	}
}

// 链表排序
class Solution_Sixth_leval_11 {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = find_mid(head).next;
		ListNode p = head;
		while (p.next != mid)
			p = p.next;
		p.next = null;

		return mergeTwoLists(sortList(head), sortList(mid));
	}

	ListNode find_mid(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

// 重排链表
class Solution_Sixth_leval_10 {
	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: void
	 */
	public void reorderList(ListNode head) {
		if (head == null)
			return;

		ListNode p = find_mid(head);
		ListNode right_half = new ListNode(-1);
		ListNode q = p.next, s;
		p.next = null;

		while (q != null) {
			s = q;
			q = q.next;
			s.next = right_half.next;
			right_half.next = s;
		}

		p = head;
		q = right_half.next;
		ListNode tail = head;

		while (true) {

			if (tail != p) {
				s = p;
				p = p.next;
				s.next = null;
				tail.next = s;
				tail = tail.next;
			} else {
				p = p.next;
			}

			if (q != null) {
				s = q;
				q = q.next;
				s.next = null;
				tail.next = s;
				tail = tail.next;
			}

			if (p == null && q == null)
				return;
		}

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

// 带环链表
class Solution_Sixth_leval_9 {
	/**
	 * @param head:
	 *            The first node of linked list.
	 * @return: True if it has a cycle, or false
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode fast = head.next, slow = head;
		while (fast != null && fast.next != null && fast != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return fast == slow;
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

		Map<Integer, RandomListNode> map_con = new HashMap<>();
		Stack<RandomListNode> stack_view = new Stack<>();

		stack_view.add(head);
		RandomListNode temp;
		while (!stack_view.isEmpty()) {
			temp = stack_view.pop();
			if (!map_con.containsKey(temp.label)) {
				map_con.put(temp.label, new RandomListNode(temp.label));
				if (temp.next != null)
					stack_view.add(temp.next);
				if (temp.random != null)
					stack_view.add(temp.random);
			}
		}

		List<Integer> view_list = new ArrayList<>();
		stack_view.add(head);
		while (!stack_view.isEmpty()) {
			temp = stack_view.pop();
			if (!view_list.contains(temp.label)) {
				view_list.add(temp.label);

				if (temp.next != null) {
					stack_view.add(temp.next);
					map_con.get(temp.label).next = map_con.get(temp.next.label);
				}

				if (temp.random != null) {
					stack_view.add(temp.random);
					map_con.get(temp.label).random = map_con.get(temp.random.label);
				}

			}
		}

		return map_con.get(head.label);
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