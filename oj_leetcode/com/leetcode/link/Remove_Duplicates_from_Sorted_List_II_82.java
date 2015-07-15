package com.leetcode.link;


public class Remove_Duplicates_from_Sorted_List_II_82 {

	public static void main(String[] args) {
	}

}

class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode h = new ListNode(-11);
		h.next = new ListNode(head.val);
		ListNode tail = h.next;

		ListNode p = head.next;
		ListNode pre = head;
		boolean dele_pre = false;
		while (p != null) {
			if (p.val != pre.val) {
				if (dele_pre) {
					ListNode dele_tail = h;
					while (dele_tail.next != tail) {
						dele_tail = dele_tail.next;
					}
					tail = dele_tail;
				}
				tail.next = new ListNode(p.val);
				tail = tail.next;
				dele_pre = false;
			} else {
				dele_pre = true;
			}
			pre = p;
			p = p.next;
		}
		if(dele_pre){
 			ListNode dele_tail = h;
 			while(dele_tail.next != tail){
 				dele_tail = dele_tail.next;
 			}
 			dele_tail.next = null;
 		}
		return h.next;
	}
}