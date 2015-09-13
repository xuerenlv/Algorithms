package com.leetcode.failed;

import java.util.LinkedList;
import java.util.List;

public class LRU_Cache_146 {

	public static void main(String[] args) {

	}

}





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Pair {
	int key, val;

	public Pair(int key, int val) {
		this.key = key;
		this.val = val;
	}
}

class LRUCache___overtime {
	List<Pair> container = new LinkedList<>();
	int capacity = 0;

	public LRUCache___overtime(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (capacity == 0 || container.isEmpty())
			return -1;
		Pair one = null;

		for (int i = container.size() - 1; i >= 0; i--) {
			Pair cur = container.get(i);
			if (key == cur.key) {
				one = cur;
				break;
			}
		}

		if (one != null) {
			container.remove(one);
			container.add(one);
			return one.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (this.capacity == container.size())
			container.remove(0);
		container.add(new Pair(key, value));
	}
}