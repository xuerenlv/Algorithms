package com.link_question;

public class Sort_List_148 {

	public static void main(String[] args) {

	}

}

class Solution_Sort_List_148 {
	// 基于归并排序的链表排序
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode middle = get_mid(head);
		ListNode next = middle.next;
		middle.next = null;
		return merge(sortList(head), sortList(next));
	}

	// 使用快慢指针来获取链表的中间节点
	ListNode get_mid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// 两个链表的合并
	ListNode merge(ListNode one, ListNode two) {
		ListNode new_head = new ListNode(-1);

		ListNode tail = new_head;
		while (one != null && two != null) {
			if (one.val < two.val) {
				tail.next = one;
				one = one.next;
			} else {
				tail.next = two;
				two = two.next;
			}
			tail = tail.next;
		}

		tail.next = one != null ? one : two;
		return new_head.next;
	}
}