package com.leetcode.link;

public class Reorder_List_143 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(4);

		for (p = head; p != null; p = p.next) {
			System.out.print(p.val + "   ");
		}
		System.out.println();

		new Solution_Reorder_List_143().reorderList(head);

		System.out.println("next______________");
		for (p = head; p != null; p = p.next) {
			System.out.print(p.val + "   ");
		}
		System.out.println();

	}

}

class Solution_Reorder_List_143 {

	// 不明白为何不可以返回
	public void reorderList(ListNode head) {
		int len = 0;
		for (ListNode p = head; p != null; p = p.next) {
			len++;
		}
		if (len <= 1)
			return;

		ListNode re_list = null, s = null;
		ListNode p = head;
		while (p != null) {
			s = new ListNode(p.val);
			p = p.next;
			s.next = re_list;
			re_list = s;
		}

		ListNode re = new ListNode(0);
		ListNode re_tail = re;
		p = head;
		while (true) {
			re_tail.next = new ListNode(p.val);
			p = p.next;
			re_tail = re_tail.next;
			len--;
			if (len == 0)
				break;
			re_tail.next = new ListNode(re_list.val);
			re_list = re_list.next;
			re_tail = re_tail.next;
			len--;
			if (len == 0)
				break;
		}

		System.out.println("next______________aaas");
		for (p = re.next; p != null; p = p.next) {
			System.out.print(p.val + "   ");
		}
		System.out.println();

		head = re.next;
	}
}