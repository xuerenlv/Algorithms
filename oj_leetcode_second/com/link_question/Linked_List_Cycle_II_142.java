package com.link_question;

public class Linked_List_Cycle_II_142 {

	public static void main(String[] args) {

	}

}

class Solution_Linked_List_Cycle_II_142 {

	// 这个还需要思考，为什么可以这样做
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode p_slow = head;
		ListNode p_fast = head;

		do {
			if (p_fast != null && p_fast.next != null && p_fast.next.next != null) {
				p_slow = p_slow.next;
				p_fast = p_fast.next.next;
			} else {
				return null;
			}

		} while (p_fast != p_slow);

		p_slow = head;
		while (p_slow != p_fast) {
			p_slow = p_slow.next;
			p_fast = p_fast.next;
		}
		return p_slow;
	}
}