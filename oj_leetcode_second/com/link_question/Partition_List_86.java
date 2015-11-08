package com.link_question;

import java.util.ArrayDeque;
import java.util.Queue;

public class Partition_List_86 {

	public static void main(String[] args) {

	}

}

class Solution_Partition_List_86 {

	// OK very good
	public ListNode partition_2(ListNode head, int x) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		ListNode new_head_2 = new ListNode(-1);
		ListNode new_tail_2 = new_head_2;

		ListNode p = head, s;
		while (p != null) {
			if (p.val < x) { // 比 x 小则放入 新链表中
				s = p;
				p = p.next;
				s.next = null;
				new_tail.next = s;
				new_tail = s;
			} else {// 比 x 大则加入另一个链表中
				s = p;
				p = p.next;
				s.next = null;
				new_tail_2.next = s;
				new_tail_2 = s;

			}
		}
		new_tail.next = new_head_2.next;
		return new_head.next;
	}

	public ListNode partition(ListNode head, int x) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;
		ListNode p = head, s;
		Queue<ListNode> queue = new ArrayDeque<>();
		while (p != null) {
			if (p.val < x) { // 比 x 小则放入 新链表中
				s = p;
				p = p.next;
				s.next = null;
				new_tail.next = s;
				new_tail = s;
			} else {// 比 x 大则加入队列中
				s = p;
				p = p.next;
				s.next = null;
				queue.add(s);
			}
		}

		while (!queue.isEmpty()) {
			s = queue.remove();
			new_tail.next = s;
			new_tail = s;
		}

		return new_head.next;
	}
}