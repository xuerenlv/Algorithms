package com.structure;

import java.util.Stack;

public class Implement_Queue_using_Stacks_232 {

	public static void main(String[] args) {

	}

}

class MyQueue {
	Stack<Integer> stack_f;
	Stack<Integer> stack_s;

	public MyQueue() {
		stack_f = new Stack<>();
		stack_s = new Stack<>();
	}

	// Push element x to the back of queue.
	public void push(int x) {
		stack_f.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (stack_s.size() != 0) {
			stack_s.pop();
		} else {
			while (stack_f.size() != 0) {
				stack_s.push(stack_f.pop());
			}
			if (stack_s.size() != 0) {
				stack_s.pop();
			}
		}
	}

	// Get the front element.
	public int peek() {
		if (stack_s.size() != 0) {
			return stack_s.peek();
		} else {
			while (stack_f.size() != 0) {
				stack_s.push(stack_f.pop());
			}
			if (stack_s.size() != 0) {
				return stack_s.peek();
			} else {
				return -1;
			}
		}
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack_f.isEmpty() && stack_s.isEmpty();
	}
}