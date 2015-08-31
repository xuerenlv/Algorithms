package com.leetcode.link;

import java.util.ArrayList;
import java.util.List;

public class Min_Stack_155 {

	public static void main(String[] args) {

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
