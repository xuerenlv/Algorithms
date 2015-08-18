package com.leetcode.link;

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

		if(len==1)
			return head;
		if (k >= len)
			k=k%len;

		int left = len - k;
		while (left > 0) {
			s = p;
			p = p.next;
			s.next = null;
			new_tail.next = s;
			new_tail = s;
			left--;
		}
		if(p!=null){
			new_tail = new_head;
			tail.next = new_tail.next;
			new_tail.next = p;
		}

		return new_head.next;
	}
}