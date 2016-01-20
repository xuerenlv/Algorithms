package com.link_question;

import java.util.ArrayList;
import java.util.List;

public class Merge_k_Sorted_Lists_23 {

	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<>();
	}

	// 别人的 分治法
	public static ListNode mergeKLists(ListNode[] lists) {
		return partion(lists, 0, lists.length - 1);
	}

	// 这是一种基于归并的思想，来自k sorted list 合并的算法
	public static ListNode partion(ListNode[] lists, int s, int e) {
		if (s == e)
			return lists[s];
		if (s < e) {
			int q = (s + e) / 2;
			ListNode l1 = partion(lists, s, q);
			ListNode l2 = partion(lists, q + 1, e);
			return merge(l1, l2);
		} else
			return null;
	}

	// This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
}

class Solutio_Merge_k_Sorted_Lists_23 {

	// 还是有错误，没有解决
	public ListNode mergeKLists_2(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode head_tail = head;

		ListNode p, s;
		ArrayList<ListNode> contain = new ArrayList<>();

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null) {
				continue;
			} else {
				contain.add(lists[i]);
				lists[i] = lists[i].next;
			}
		}
		build_min_heap(contain);
		while (!contain.isEmpty()) {
			p = contain.get(0);
			contain.remove(0);
			s = p;
			p = p.next;
			s.next = null;
			if (p != null) {
				contain.add(0, p);
			}
			min_heap(contain, contain.size(), 0);
			head_tail.next = s;
			head_tail = head_tail.next;
		}

		return head.next;
	}

	// build min heap
	void build_min_heap(ArrayList<ListNode> contain) {
		if (contain.size() <= 1) {
			return;
		}

		int half = contain.size() / 2;
		for (int i = half; i >= 0; i--) {
			min_heap(contain, contain.size(), i);
		}
	}

	// adjust min heap
	void min_heap(ArrayList<ListNode> contain, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int min = index;
		if (left < heapSize && contain.get(left).val < contain.get(index).val) {
			min = left;
		}

		if (right < heapSize && contain.get(right).val < contain.get(min).val) {
			min = right;
		}

		int swap;
		if (index != min) {
			swap = contain.get(index).val;
			contain.get(index).val = contain.get(min).val;
			contain.get(min).val = swap;

			min_heap(contain, heapSize, min);
		}
	}

	// 合并多个已排好序的单链表
	// 超时
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode p = head;

		while (true) {
			int min = -1;
			int min_val = 0;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null)
					continue;
				if (min == -1) {
					min = i;
					min_val = lists[i].val;
				} else {
					if (lists[i].val < min_val) {
						min = i;
						min_val = lists[i].val;
					}
				}
			}
			if (min == -1) {
				break;
			} else {
				p.next = new ListNode(min_val);
				p = p.next;
				lists[min] = lists[min].next;
			}
		}

		return head.next;
	}
}
