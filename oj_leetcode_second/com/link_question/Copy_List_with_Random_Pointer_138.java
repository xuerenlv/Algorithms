package com.link_question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	// 通过深度优先遍历进行copy
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		Map<Integer, RandomListNode> map = new HashMap<>();
		Stack<RandomListNode> stack = new Stack<RandomListNode>();

		stack.add(head);
		while (!stack.isEmpty()) {
			RandomListNode temp_node = stack.pop();
			if (!map.containsKey(temp_node.label)) {
				map.put(temp_node.label, new RandomListNode(temp_node.label));
				if (temp_node.next != null) {
					stack.push(temp_node.next);
				}
				if (temp_node.random != null) {
					stack.push(temp_node.random);
				}
			}
		}

		stack.add(head);
		List<Integer> visited_list = new ArrayList<>();
		while (!stack.isEmpty()) {
			RandomListNode temp_node = stack.pop();
			if (!visited_list.contains(temp_node.label)) {
				RandomListNode existing_node = map.get(temp_node.label);
				if (temp_node.next != null) {
					stack.add(temp_node.next);
					existing_node.next = map.get(temp_node.next.label);
				}
				if (temp_node.random != null) {
					stack.add(temp_node.random);
					existing_node.random = map.get(temp_node.random.label);
				}
				visited_list.add(temp_node.label);
			}
		}

		return map.get(head.label);
	}
}