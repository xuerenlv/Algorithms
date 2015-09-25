package com.link_question;

public class Add_Two_Numbers_2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);

		ListNode l3 = new Solution_Add_Two_Numbers_2().addTwoNumbers_accepted(l1, l2);

		if (l3 != null)
			System.out.println(l3.val);
	}

}

class Solution_Add_Two_Numbers_2_second {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode p = head;

		int jinwei = 0;
		int sum = 0;
		while (l1 != null && l2 != null) {
			sum = l1.val + l2.val + jinwei;
			jinwei = sum>9 ? 1:0;
			p.next = new ListNode(sum%10);
			p = p.next;
			sum = 0;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null){
			sum = l1.val + jinwei;
			jinwei = sum>9 ? 1:0;
			p.next = new ListNode(sum%10);
			p = p.next;
			sum = 0;
			l1 = l1.next;
		}
		
		while (l2 != null){
			sum = l2.val + jinwei;
			jinwei = sum>9 ? 1:0;
			p.next = new ListNode(sum%10);
			p = p.next;
			sum = 0;
			l2 = l2.next;
		}
		
		if(jinwei!=0)
			p.next = new ListNode(jinwei);
		return head.next;
	}
}

class Solution_Add_Two_Numbers_2 {
	public ListNode addTwoNumbers_accepted(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode p = head;

		int jinwei = 0;
		int sum = 0;
		while (l1 != null && l2 != null) {
			sum = l1.val + l2.val + jinwei;
			if (sum > 9) {
				sum %= 10;
				jinwei = 1;
			} else {
				jinwei = 0;
			}
			p.next = new ListNode(sum);
			p = p.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			sum = l1.val + jinwei;
			if (sum > 9) {
				sum %= 10;
				jinwei = 1;
			} else {
				jinwei = 0;
			}
			p.next = new ListNode(sum);
			p = p.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			sum = l2.val + jinwei;
			if (sum > 9) {
				sum %= 10;
				jinwei = 1;
			} else {
				jinwei = 0;
			}
			p.next = new ListNode(sum);
			p = p.next;
			l2 = l2.next;
		}
		if (jinwei == 1) {
			p.next = new ListNode(jinwei);
		}
		System.out.println("****" + head.next.val);
		return head.next;
	}
}
