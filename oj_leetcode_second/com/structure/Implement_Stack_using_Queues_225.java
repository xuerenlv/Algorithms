package com.structure;

import java.util.ArrayList;
import java.util.List;

public class Implement_Stack_using_Queues_225 {

	public static void main(String[] args) {

	}

}

class MyStack {
	List<Integer> queue;

	public MyStack() {
		queue = new ArrayList<>();
	}

	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (queue.size() == 0)
			return;
		queue.remove(queue.size() - 1);
	}

	// Get the top element.
	public int top() {
		if (queue.size() == 0)
			return -1;
		return queue.get(queue.size() - 1);
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.size() == 0;
	}
}