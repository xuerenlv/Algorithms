package com.link_question;

public class Intersection_of_Two_Linked_Lists_160 {

	public static void main(String[] args) {

	}

}

class Solution_Intersection_of_Two_Linked_Lists_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode shorter;
		ListNode longer;

		int len_a = len(headA);
		int len_b = len(headB);
		if (len_a > len_b) {
			longer = headA;
			shorter = headB;
		} else {
			longer = headB;
			shorter = headA;
		}

		// 长的，先把多出的走完
		int cha = Math.abs(len_a - len_b);
		while (cha > 0) {
			longer = longer.next;
			cha--;
		}

		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}

		return longer;
	}

	// 获取链表的长度
	int len(ListNode head) {
		if (head == null)
			return 0;
		int count = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
		return count;
	}
}