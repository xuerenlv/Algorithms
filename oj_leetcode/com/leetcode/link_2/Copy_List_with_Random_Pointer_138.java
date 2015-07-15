package com.leetcode.link_2;

import java.util.Stack;

public class Copy_List_with_Random_Pointer_138 {

	public static void main(String[] args) {

	}

}

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

class Solution_Copy_List_with_Random_Pointer_138 {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode re = null;
		if (head == null)
			return re;

		Stack<RandomListNode> stack = new Stack<RandomListNode>();

		re = new RandomListNode(0);
		RandomListNode q, p = re;

		q = head;

		return re;
	}
}