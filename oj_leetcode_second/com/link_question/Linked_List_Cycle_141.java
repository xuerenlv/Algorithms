package com.link_question;

public class Linked_List_Cycle_141 {

	public static void main(String[] args) {

	}

}

class Solution_Linked_List_Cycle_141 {
	// 快慢指针，又名乌龟跑
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode p_slow = head;
		ListNode p_fast = head.next;

		while (p_fast != null && p_fast.next != null && p_fast.next.next != null && p_fast != p_slow) {
			p_fast = p_fast.next.next;
			p_slow = p_slow.next;
		}

		return p_fast == p_slow;
	}
}