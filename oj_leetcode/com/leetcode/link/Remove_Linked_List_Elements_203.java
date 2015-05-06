package com.leetcode.link;

public class Remove_Linked_List_Elements_203 {

	public static void main(String[] args) {

	}

	/**
	 * Definition for singly-linked list.
	 */
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class Solution_Remove_Linked_List_Elements_203 {
		// Remove all elements from a linked list of integers that have value val.
		public ListNode removeElements_accepted(ListNode head, int val) {
			while (head != null && head.val == val)
				head = head.next;
			if (head == null)
				return null;

			ListNode p = head;
			ListNode pre = p;
			while (p != null) {
				if (p.val != val) {
					pre = p;
					p = p.next;
				} else {
					p = p.next;
					pre.next = p;
				}
			}

			return head;
		}
	}
}
