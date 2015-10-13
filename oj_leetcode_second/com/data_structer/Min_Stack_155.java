package com.data_structer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Min_Stack_155 {

	public static void main(String[] args) {

	}

}

class MinStack_better {
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();

	public void push(int x) {
		if (x <= min) { // 当比min小的时候，先存储 min，再存储 相应的值
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.peek() == min) {
			stack.pop();
			min = stack.peek();
			stack.pop();
		} else {
			stack.pop();
		}
		if (stack.empty()) {
			min = Integer.MAX_VALUE;
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}

class MinStack {
	List<Integer> container;
	int min_val;

	public MinStack() {
		container = new ArrayList<>();
		min_val = Integer.MAX_VALUE;
	}

	public void push(int x) {
		container.add(x);
		if (x < min_val)
			min_val = x;
	}

	public void pop() {
		int x = container.remove(container.size() - 1);
		if (x == min_val) {
			if (container.contains(min_val))
				return;
			if (container.size() == 0) {
				min_val = Integer.MAX_VALUE;
				return;
			}
			if (container.size() == 1) {
				min_val = container.get(0);
				return;
			}
			min_val = container.get(0);
			for (int z : container) {
				if (z < min_val)
					min_val = z;
			}
		}
	}

	public int top() {
		return container.get(container.size() - 1);
	}

	public int getMin() {
		return min_val;
	}
}
