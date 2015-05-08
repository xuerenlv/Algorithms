package com.leetcode.link;

public class Merge_k_Sorted_Lists_23 {

	public static void main(String[] args) {

	}



	class Solution {
		// 合并多个已排好序的单链表
		// 超时
		public ListNode mergeKLists(ListNode[] lists) {
			ListNode head = new ListNode(0);
			ListNode p = head;

			while (true) {
				int min = -1;
				int min_val = 0;
				for (int i = 0; i < lists.length; i++) {
					if (lists[i] != null && min == -1) {
						min = i;
						min_val = lists[i].val;
					}
					if (lists[i] != null && min != -1) {
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
}
