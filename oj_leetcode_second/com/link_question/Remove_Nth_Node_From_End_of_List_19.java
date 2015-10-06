package com.link_question;

public class Remove_Nth_Node_From_End_of_List_19 {

	public static void main(String[] args) {
		ListNode li = new ListNode(1);
		li.next = new ListNode(10);
		new Solution_Remove_Nth_Node_From_End_of_List_19().removeNthFromEnd(li, 1);
	}

}

class Solution_Remove_Nth_Node_From_End_of_List_19 {
	// 一次遍历，前后两个指针，很清晰
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		while (n > 0 && fast != null) {
			fast = fast.next;
			n--;
		}
		if (fast == null)
			if (n == 0)
				return head.next;
			else
				return head;

		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;
	}

	// 先求出长度，再从前向后遍历，需要两遍遍历
	public ListNode removeNthFromEnd_accepted_two(ListNode head, int n) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		int dele = len - n + 1;
		if (dele <= 0 || dele > len)
			return head;
		if (dele == 1) {
			return head.next;
		}

		p = head;
		int i = 1;
		while (i < dele - 1) {
			p = p.next;
			i++;
		}
		p.next = p.next.next;

		return head;
	}
}