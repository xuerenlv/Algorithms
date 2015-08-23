package com.leetcode.link;

import java.util.ArrayDeque;
import java.util.Queue;

public class Partition_List_86 {

	public static void main(String[] args) {

	}

}

class Solution_Partition_List_86 {
	public ListNode partition(ListNode head, int x) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;
		ListNode p = head, s;
		Queue<ListNode> queue = new ArrayDeque<>();
		while (p != null) {
			if (p.val < x) {
				s = p;
				p = p.next;
				s.next = null;
				new_tail.next = s;
				new_tail = s;
			} else {
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