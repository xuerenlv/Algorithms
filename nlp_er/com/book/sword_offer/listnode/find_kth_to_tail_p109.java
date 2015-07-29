package com.book.sword_offer.listnode;

public class find_kth_to_tail_p109 {

	public static void main(String[] args) {

	}

}

class solution_kth {
	ListNode find_kth(ListNode head, int k) {
		if(head==null || k<=0){
			return null;
		}
		ListNode p_ahead = head;
		ListNode p_behind = head;

		for (int i = 0; i < k - 1; i++) {
			if(p_ahead.next!=null){
				p_ahead = p_ahead.next;
			}else{
				return null;
			}
		}
		while (p_ahead.next != null) {
			p_ahead = p_ahead.next;
			p_behind = p_behind.next;
		}
		return p_behind;
	}
}
