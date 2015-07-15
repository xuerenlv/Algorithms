package com.leetcode.link;

public class Remove_Duplicates_from_Sorted_List_83 {

	public static void main(String[] args) {

	}

}

class Solution_Remove_Duplicates_from_Sorted_List_83 {
	
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
        	return null;
        }
        
        ListNode h = new ListNode(head.val);
        ListNode tail = h;
        ListNode p = head.next;
        ListNode pre = h;
        while(p!=null){
        	if(p.val != pre.val){
        		tail.next = new ListNode(p.val);
        		tail = tail.next;
        	}
        	pre = p;
        	p = p.next;
        }
    	
    	return h;
    }
}