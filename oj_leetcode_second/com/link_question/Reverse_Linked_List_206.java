package com.link_question;

public class Reverse_Linked_List_206 {

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		head.next = new ListNode(32);

		for (ListNode p = head; p != null; p = p.next) {
			System.out.println(p.val);
		}

		head = new Solution_Reverse_Linked_List_206().reverseList(head);
		
		for (ListNode p = head; p != null; p = p.next) {
			System.out.println(p.val);
		}
	}

}

class Solution_Reverse_Linked_List_206 {

	//头插法 accepted
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode q;
		ListNode p = head;
		head = null;
		while (p != null) {
			q = p;
			p = p.next;
			q.next = head;
			head = q;
		}

		return head;
	}
}