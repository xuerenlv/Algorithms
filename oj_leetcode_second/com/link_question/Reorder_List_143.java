package com.link_question;

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

	public void reorderList(ListNode head) {
		int len = 0;
		for (ListNode p = head; p != null; p = p.next) {
			len++;
		}
		if (len <= 1)
			return;

		// 逆转list
		ListNode re_list = null, s = null;
		ListNode p = head;
		while (p != null) {
			s = new ListNode(p.val);
			p = p.next;
			s.next = re_list;
			re_list = s;
		}

		ListNode re = head;
		ListNode re_tail = re;
		p = head;
		while (true) {
			// 插入原有的节点
			if (p != head) {
				re_tail.next = new ListNode(p.val);
				re_tail = re_tail.next;
			}
			p = p.next;
			len--;
			if (len == 0)
				break;
			// 插入逆转的节点
			re_tail.next = new ListNode(re_list.val);
			re_list = re_list.next;
			re_tail = re_tail.next;
			len--;
			if (len == 0)
				break;
		}
	}
}