package com.link_question;

public class Reverse_Linked_List_II_92 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		head = new Solution_Reverse_Linked_List_II_92().reverseBetween(head, 1, 3);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}

class Solution_Reverse_Linked_List_II_92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;

		int i = 1;
		ListNode start = new ListNode(-1);
		ListNode new_tail = start;

		ListNode p = head;
		ListNode s;
		while (i < m) {
			s = p;
			p = p.next;
			s.next = null;
			new_tail.next = s;
			new_tail = s;
			i++;
		}

		// 尾插法
		while (m != n + 1) {
			s = p;
			p = p.next;
			s.next = new_tail.next;
			new_tail.next = s;
			m++;
		}

		while (new_tail.next != null) {
			new_tail = new_tail.next;
		}
		new_tail.next = p;
		return start.next;
	}
}