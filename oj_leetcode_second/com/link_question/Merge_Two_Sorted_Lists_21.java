package com.link_question;

public class Merge_Two_Sorted_Lists_21 {

	public static void main(String[] args) {

	}

}

class Solution_Merge_Two_Sorted_Lists_21 {

	// This function is from Merge Two Sorted Lists.
	// 使用递归的 merge
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	public ListNode mergeTwoLists_accepted_2(ListNode one, ListNode two) {
		ListNode new_head = new ListNode(-1);

		ListNode tail = new_head;
		while (one != null && two != null) {
			if (one.val < two.val) {
				tail.next = one;
				one = one.next;
			} else {
				tail.next = two;
				two = two.next;
			}
			tail = tail.next;
		}

		tail.next = one != null ? one : two;
		return new_head.next;
	}

	// 一遍过
	// 还是这种感觉舒服
	public ListNode mergeTwoLists_accepted(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode head_tail = head;

		ListNode p = l1;
		ListNode q = l2;
		ListNode s;
		while (p != null && q != null) {
			if (p.val < q.val) {
				s = p;
				p = p.next;
				s.next = null;
				head_tail.next = s;
				head_tail = s;
			} else {
				s = q;
				q = q.next;
				s.next = null;
				head_tail.next = s;
				head_tail = s;
			}
		}

		if (p != null) {
			head_tail.next = p;
		}
		if (q != null) {
			head_tail.next = q;
		}

		return head.next;
	}
}