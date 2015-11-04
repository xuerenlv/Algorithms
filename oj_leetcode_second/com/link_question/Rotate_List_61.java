package com.link_question;

public class Rotate_List_61 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(4);

		head = new Solution_Rotate_List_61().rotateRight(head, 2);

		for (p = head; p != null; p = p.next) {
			System.out.print(p.val + "   ");
		}
		System.out.println();

	}

}

class Solution_Rotate_List_61 {
	// 基于逆转的也可以

	// 使用 双指针
	public ListNode rotateRight_2(ListNode head, int k) {
		if (k == 0 || head == null)
			return head;

		ListNode p = head;
		ListNode q = head, s;

		int len = 1;
		while (q.next != null) {
			len++;
			q = q.next;
		}

		if (len == 1)
			return head;
		if (k >= len)
			k = k % len;
		if (k == 0)
			return head;
		// 双指针
		q = head;
		int gap = 0;
		while (gap < k) {
			q = q.next;
			gap++;
		}
		while (q.next != null) {
			p = p.next;
			q = q.next;
		}
		s = p.next;
		p.next = null;
		q.next = head;
		return s;
	}

	// 模拟 ， 先是尾插法，然后是头插法（逆序）
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null)
			return head;

		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		ListNode p = head;
		ListNode s, tail = head;

		int len = 1;
		while (tail.next != null) {
			len++;
			tail = tail.next;
		}

		if (len == 1)
			return head;
		if (k >= len)
			k = k % len;

		int left = len - k;
		while (left > 0) {
			s = p;
			p = p.next;
			s.next = null;
			new_tail.next = s;
			new_tail = s;
			left--;
		}
		if (p != null) {
			new_tail = new_head;
			tail.next = new_tail.next;
			new_tail.next = p;
		}

		return new_head.next;
	}
}