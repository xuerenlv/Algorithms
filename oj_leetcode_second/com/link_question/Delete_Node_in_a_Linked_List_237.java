package com.link_question;

public class Delete_Node_in_a_Linked_List_237 {

	public static void main(String[] args) {

	}
}

class Solution_Delete_Node_in_a_Linked_List_237 {
	public void deleteNode(ListNode node) {
		if (node != null && node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
}