package com.leetcode.link;

public class Palindrome_Linked_List_234 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		System.out.println(new Solution_Palindrome_Linked_List_234().isPalindrome(head));
	}

}

class Solution_Palindrome_Linked_List_234 {
//	public boolean isPalindrome_2(ListNode head) {
//		 //如果链表为空或者仅有一个元素那么肯定是回文链表  
//	    if (!head || !head->next) {  
//	        return true;  
//	    }  
//	    //快慢指针法，寻找链表中心  
//	    ListNode * slow, *fast;  
//	    slow = fast = head;  
//	    while (fast && fast->next) {  
//	        slow = slow->next;  
//	        fast = fast->next->next;  
//	    }  
//	    if (fast) {  
//	        //链表元素奇数个  
//	        slow->next = reverseList(slow->next);  
//	        slow = slow->next;  
//	    }else{  
//	         //链表元素偶数个  
//	        slow = reverseList(slow);  
//	    }  
//	    while (slow) {  
//	        if (head->val != slow->val) {  
//	            return false;  
//	        }  
//	        slow = slow->next;  
//	        head = head->next;  
//	    }  
//	    return true;  
//		if (head == null || head.next == null)
//			return true;
//
//		ListNode slow, faster;
//		slow = faster = head;
//		while (faster != null && faster.next != null) {
//			slow = slow.next;
//			faster = faster.next.next;
//		}
//		
//		
//	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode new_head = new ListNode(-1);
		ListNode p = head, s;
		while (p != null) {
			s = new ListNode(p.val);
			p = p.next;
			s.next = new_head.next;
			new_head.next = s;
		}
		p = head;
		s = new_head.next;
		while (p != null) {
			if (p.val != s.val)
				return false;
			p = p.next;
			s = s.next;
		}
		return true;
	}
}