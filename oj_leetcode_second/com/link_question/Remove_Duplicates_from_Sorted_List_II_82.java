package com.link_question;

public class Remove_Duplicates_from_Sorted_List_II_82 {

	public static void main(String[] args) {
	}

}

class Solution {

	// 在原来的链表上做操作，更优雅
	public ListNode deleteDuplicates_2(ListNode head) {
		if (head == null)
			return null;
		ListNode FakeHead = new ListNode(0);
		FakeHead.next = head;
		ListNode pre = FakeHead;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			// 对当前这个节点的处理
			if (pre.next == cur) {// 前一个节点与后一个节点不同
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return FakeHead.next;
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode new_head = new ListNode(-11);
		new_head.next = new ListNode(head.val);
		ListNode tail = new_head.next;

		ListNode p = head.next;
		ListNode pre = head;
		boolean dele_pre = false;// 要不要删除前一个节点
		while (p != null) {
			if (p.val != pre.val) {
				if (dele_pre) {
					// 遍历到新链表尾节点的前一个节点，去掉尾节点
					ListNode dele_tail = new_head;
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
		if (dele_pre) {
			ListNode dele_tail = new_head;
			while (dele_tail.next != tail) {
				dele_tail = dele_tail.next;
			}
			dele_tail.next = null;
		}
		return new_head.next;
	}
}