package com.link_question;

public class Insertion_Sort_List_147 {

	public static void main(String[] args) {

	}

}

class Solution_Insertion_Sort_List_147 {
	// 使用插入排序，排序链表
	// 对链表使用插入排序，实在是太优雅了
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode new_head = new ListNode(head.val);

		ListNode p = head.next;
		while (p != null) {
			ListNode s = new ListNode(p.val);
			p = p.next;
			if (s.val < new_head.val) {
				s.next = new_head;
				new_head = s;
			} else {
				ListNode q = new_head;
				while (q.next != null && s.val > q.next.val) {
					q = q.next;
				}
				if (q.next == null) {
					q.next = s;
				} else {
					s.next = q.next;
					q.next = s;
				}

			}
		}

		return new_head;
	}
}