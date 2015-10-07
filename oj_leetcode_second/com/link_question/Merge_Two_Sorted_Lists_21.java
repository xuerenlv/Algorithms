package com.link_question;

public class Merge_Two_Sorted_Lists_21 {

	public static void main(String[] args) {

	}

}

class Solution_Merge_Two_Sorted_Lists_21 {
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