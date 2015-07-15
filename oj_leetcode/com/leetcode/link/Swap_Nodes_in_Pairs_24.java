package com.leetcode.link;

public class Swap_Nodes_in_Pairs_24 {

	public static void main(String[] args) {

	}

}

class Solution_Swap_Nodes_in_Pairs_24 {
	public ListNode swapPairs_inear(ListNode head) {
	    if(head == null) return head;
	    ListNode curr = head;
	    ListNode dummy = new ListNode(-1);
	    dummy.next = head;
	    ListNode prev = dummy;
	    while(curr != null){
	        if(curr.next == null) break;
	        
	        ListNode temp = curr.next;
	        curr.next = temp.next;
	        temp.next = curr;
	        prev.next = temp;
	        
	        prev = curr;
	        curr = curr.next;
	    }
	    return dummy.next;
	}
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;

        ListNode rest = swapPairs(head.next.next), oldfirst = head, oldsecond = head.next;

        oldsecond.next = oldfirst;
        oldfirst.next = rest;

        return oldsecond;
    }
}