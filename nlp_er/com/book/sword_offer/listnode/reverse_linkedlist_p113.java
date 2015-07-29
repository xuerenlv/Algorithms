package com.book.sword_offer.listnode;

public class reverse_linkedlist_p113 {

	public static void main(String[] args) {

	}

}

class solution_p113 {

	ListNode reverse(ListNode head) {
		ListNode p = head;
		if (p == null || p.next == null) {
			return head;
		}

		ListNode new_head = new ListNode(-1);
		ListNode s;
		while (p != null) {
			s = new ListNode(p.val);
			s.next = new_head.next;
			new_head.next = s;

			p = p.next;
		}

		return new_head.next;
	}
}