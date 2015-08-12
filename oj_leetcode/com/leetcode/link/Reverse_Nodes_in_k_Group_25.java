package com.leetcode.link;

public class Reverse_Nodes_in_k_Group_25 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val+"  ");
			p = p.next;
		}
		System.out.println();

		
		ListNode new_h = new Solution_Reverse_Nodes_in_k_Group_25().reverseKGroup(head, 3);
		
		p = new_h;
		while (p != null) {
			System.out.print(p.val+"  ");
			p = p.next;
		}
	}

}

class Solution_Reverse_Nodes_in_k_Group_25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode p = head;
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}

		int duan = len / k;
		if (duan == 0)
			return head;

		p = head;
		ListNode s;
		int i = k;
		while (true) {
			if (i == 0) {
				while (new_tail.next != null) {
					new_tail = new_tail.next;
				}
				i = k;
				duan--;
				if (duan == 0)
					break;
			}
			s = p;
			p = p.next;
			s.next = new_tail.next;
			new_tail.next = s;
			i--;
		}

		if (p != null) {
			new_tail.next = p;
		}

		return new_head.next;
	}
}