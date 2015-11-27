package com.data_structer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRU_Cache_146 {

	public static void main(String[] args) {

	}

}

///////////////////////////////////////////// 双向链表 ///////////////// good
///////////////////////////////////////////// accepted
class Pair {
	int key, val;
	Pair next;
	Pair pre;

	public Pair(int key, int val) {
		this.key = key;
		this.val = val;
		next = null;
		pre = null;
	}
}

class LRUCache {
	Map<Integer, Pair> key_to_point; // 存放节点信息
	Pair head;
	Pair tail;
	int size;
	int capacity;

	public LRUCache(int capacity) {
		head = new Pair(0, 0);
		tail = new Pair(0, 0);
		head.next = tail;
		tail.pre = head;
		size = 0;
		this.capacity = capacity;
		key_to_point = new HashMap<>();
	}

	public int get(int key) {
		if (key_to_point.containsKey(key)) {
			Pair cur = key_to_point.get(key);
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			put_to_head(cur);
			return cur.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		Pair cur;
		if (key_to_point.containsKey(key)) {
			cur = key_to_point.get(key);
			cur.val = value; // 更新节点的值
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			put_to_head(cur);
			return;
		}

		cur = new Pair(key, value);
		key_to_point.put(key, cur);
		put_to_head(cur);
		size++;
		if (size > capacity) {
			cur = tail.pre;
			key_to_point.remove(cur.key);
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			size--;
		}
	}

	// 加入到开头
	private void put_to_head(Pair cur) {
		cur.next = head.next;
		cur.pre = head;
		cur.next.pre = cur;
		head.next = cur;
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// class Pair {
// int key, val;
//
// public Pair(int key, int val) {
// this.key = key;
// this.val = val;
// }
// }
//
// class LRUCache___overtime {
// List<Pair> container = new LinkedList<>();
// int capacity = 0;
//
// public LRUCache___overtime(int capacity) {
// this.capacity = capacity;
// }
//
// public int get(int key) {
// if (capacity == 0 || container.isEmpty())
// return -1;
// Pair one = null;
//
// for (int i = container.size() - 1; i >= 0; i--) {
// Pair cur = container.get(i);
// if (key == cur.key) {
// one = cur;
// break;
// }
// }
//
// if (one != null) {
// container.remove(one);
// container.add(one);
// return one.val;
// } else {
// return -1;
// }
// }
//
// public void set(int key, int value) {
// if (this.capacity == container.size())
// container.remove(0);
// container.add(new Pair(key, value));
// }
// }