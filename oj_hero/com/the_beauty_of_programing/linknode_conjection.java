package com.the_beauty_of_programing;

public class linknode_conjection {

	public static void main(String[] args) {

	}

}

class solution_linknode_conjection {

	// 判断一个链表是否有环
	boolean does_hoop(ListNode head) {
		if (head == null)
			return false;
		ListNode p_slow = head;
		ListNode p_fast = head.next;

		while (p_fast != null && p_fast.next != null && p_fast.next.next != null && p_fast != p_slow) {
			p_fast = p_fast.next.next;
			p_slow = p_slow.next;
		}

		if (p_fast == null)
			return false;

		return p_fast == p_slow;
	}

	// 获得两个链表相交的第一个节点
	ListNode first_con_node(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null)
			return null;
		int len1 = 0;
		int len2 = 0;
		ListNode p1 = head1;
		ListNode p2 = head2;
		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}
		ListNode shorter, longer;
		int cha_ju;
		if (len1 >= len2) {
			shorter = head2;
			longer = head1;
			cha_ju = len1 - len2;
		} else {
			shorter = head1;
			longer = head2;
			cha_ju = len2 - len1;
		}

		while (cha_ju != 0) {
			longer = longer.next;
			cha_ju--;
		}

		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return shorter;
	}

	// 判断两个链表是否相交
	boolean does_conjection(ListNode head1, ListNode head2) {
		ListNode p1 = head1;
		ListNode p2 = head2;

		if (p1 == null || p2 == null)
			return false;
		while (p1.next != null)
			p1 = p1.next;
		while (p2.next != null)
			p2 = p2.next;

		return p1 == p2;
	}

}