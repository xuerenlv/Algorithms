package com.link_question;

public class Swap_Nodes_in_Pairs_24 {

	public static void main(String[] args) {

	}

}

class Solution_Swap_Nodes_in_Pairs_24 {
	// 基于模拟的成对，换序算法
	public ListNode swapPairs_inear(ListNode head) {
		if (head == null)
			return head;
		ListNode curr = head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		while (curr != null && curr.next != null) {
			ListNode temp = curr.next;
			curr.next = temp.next;
			temp.next = curr;
			prev.next = temp;

			prev = curr;
			curr = curr.next;
		}
		return dummy.next;
	}

	// 基于递归的成对，换序算法
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode rest = swapPairs(head.next.next), oldfirst = head, oldsecond = head.next;

		oldsecond.next = oldfirst;
		oldfirst.next = rest;

		return oldsecond;
	}
}