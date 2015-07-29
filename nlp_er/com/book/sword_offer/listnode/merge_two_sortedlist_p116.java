package com.book.sword_offer.listnode;

public class merge_two_sortedlist_p116 {

	public static void main(String[] args) {

	}

}

class solution_p116 {
	ListNode merge_2(ListNode head_1, ListNode head_2) {
		if (head_1 == null) {
			return head_2;
		}
		if (head_2 == null) {
			return head_1;
		}

		ListNode new_head = null;
		if (head_1.val <= head_2.val) {
			new_head = head_1;
			new_head.next = merge(head_1.next, head_2);
		} else {
			new_head = head_2;
			new_head.next = merge(head_1, head_2.next);
		}

		return new_head;
	}

	ListNode merge(ListNode head_1, ListNode head_2) {
		if (head_1 == null) {
			return head_2;
		}
		if (head_2 == null) {
			return head_1;
		}

		ListNode new_head = new ListNode(-1);
		ListNode P_new_head = new_head;
		ListNode p_head_1 = head_1;
		ListNode p_head_2 = head_2;

		ListNode s;
		while (p_head_1 != null && p_head_2 != null) {
			if (p_head_1.val <= p_head_2.val) {
				s = new ListNode(p_head_1.val);
				P_new_head.next = s;
				P_new_head = s;
				p_head_1 = p_head_1.next;
			} else {
				s = new ListNode(p_head_2.val);
				P_new_head.next = s;
				P_new_head = s;
				p_head_2 = p_head_2.next;
			}
		}

		while (p_head_1 != null) {
			s = new ListNode(p_head_1.val);
			P_new_head.next = s;
			P_new_head = s;
			p_head_1 = p_head_1.next;
		}
		while (p_head_2 != null) {
			s = new ListNode(p_head_2.val);
			P_new_head.next = s;
			P_new_head = s;
			p_head_2 = p_head_2.next;
		}

		return new_head.next;
	}
}