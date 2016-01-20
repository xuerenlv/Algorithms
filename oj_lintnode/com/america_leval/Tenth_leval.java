package com.america_leval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Tenth_leval {

	public static void main(String[] args) {

	}

}

// 中位数 II
class Solution_Tenth_leval_7 {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: the median of numbers
	 */
	public int[] medianII(int[] nums) {

		return new int[8];
	}
}

// 直方图最大矩形覆盖
class Solution_Tenth_leval_6 {
	/**
	 * @param height:
	 *            A list of integer
	 * @return: The area of largest rectangle in the histogram
	 */
	public int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;

	}
}

// 单词搜索 II
class Solution_Tenth_leval_5 {
	/**
	 * @param board:
	 *            A list of lists of character
	 * @param words:
	 *            A list of string
	 * @return: A list of string
	 */

	// Set<String> res = new HashSet<String>();
	//
	// public ArrayList<String> wordSearchII(char[][] board, ArrayList<String>
	// words) {
	// Trie trie = new Trie();
	// for (String word : words) {
	// trie.insert(word);
	// }
	//
	// int m = board.length;
	// int n = board[0].length;
	// boolean[][] visited = new boolean[m][n];
	// for (int i = 0; i < m; i++) {
	// for (int j = 0; j < n; j++) {
	// dfs(board, visited, "", i, j, trie);
	// }
	// }
	//
	// return new ArrayList<String>(res);
	// }
	//
	// public void dfs(char[][] board, boolean[][] visited, String str, int x,
	// int y, Trie trie) {
	// if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
	// return;
	// if (visited[x][y])
	// return;
	//
	// str += board[x][y];
	// if (!trie.startsWith(str)) // 没有以这个为前缀的
	// return;
	//
	// if (trie.search(str)) {
	// res.add(str);
	// }
	//
	// visited[x][y] = true;
	// dfs(board, visited, str, x - 1, y, trie);
	// dfs(board, visited, str, x + 1, y, trie);
	// dfs(board, visited, str, x, y - 1, trie);
	// dfs(board, visited, str, x, y + 1, trie);
	// visited[x][y] = false;
	// }

}

// 丑数
class Solution_Tenth_leval_4 {
	/**
	 * @param k:
	 *            The number k.
	 * @return: The kth prime number as description.
	 */
	public long kthPrimeNumber(int n) {
		long[] re = new long[n + 1];
		re[0] = 1;

		long factor_3 = 3;
		long factor_5 = 5;
		long factor_7 = 7;
		int index_3 = 0;
		int index_5 = 0;
		int index_7 = 0;

		long min_val;
		for (int i = 1; i <= n; i++) {
			min_val = Math.min(Math.min(factor_3, factor_5), factor_7);
			re[i] = min_val;
			if (min_val == factor_3)
				factor_3 = 3 * re[++index_3];
			if (min_val == factor_5)
				factor_5 = 5 * re[++index_5];
			if (min_val == factor_7)
				factor_7 = 7 * re[++index_7];
		}

		return re[n];
	}
};

class MinStack {

	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();

	public void push(int x) {
		if (x <= min) { // 当比min小的时候，先存储 min，再存储 相应的值
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public int pop() {
		int re = -1;
		if (stack.peek() == min) {
			re = stack.pop();
			min = stack.peek();
			stack.pop();
		} else {
			re = stack.pop();
		}
		if (stack.empty()) {
			min = Integer.MAX_VALUE;
		}
		return re;
	}

	public int min() {
		return min;
	}
}

class Queue_solution {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public Queue_solution() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int element) {
		stack1.add(element);
	}

	public int pop() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			while (!stack1.isEmpty())
				stack2.add(stack1.pop());
			return stack2.pop();
		}
	}

	public int top() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		} else {
			while (!stack1.isEmpty())
				stack2.add(stack1.pop());
			return stack2.peek();
		}
	}
}

// 这个使用 ArrayList 作为容器
class Small_Heap_2 {
	ArrayList<Integer> container;

	public Small_Heap_2() {
		container = new ArrayList<>();
	}

	// 插入一个元素
	public void insert(int ele) {
		container.add(0, ele);
		maxHeap(container, container.size(), 0);
	}

	// 删除一个元素（取最小值）
	public int dele_smallest() {
		if (container.size() == 0)
			return -1;

		int re = container.get(0);
		if (container.size() == 1) {
			container.clear();
			return re;
		}
		container.set(0, container.get(container.size() - 1));
		container.remove(container.size() - 1);
		maxHeap(container, container.size(), 0);
		return re;
	}

	// 判断是否为空
	public boolean empty() {
		return container.isEmpty();
	}

	// heapsize 为堆的长度
	// index 为调整的开始位置
	// 从上向下调整
	void maxHeap(ArrayList<Integer> container, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int small = index;
		if (left < heapSize && container.get(left) < container.get(index)) {
			small = left;
		}

		if (right < heapSize && container.get(right) < container.get(small)) {
			small = right;
		}

		int swap;
		if (index != small) {
			swap = container.get(index);
			container.set(index, container.get(small));
			container.set(small, swap);

			maxHeap(container, heapSize, small);
		}
	}
}

// 合并k个排序链表
class Solution_Tenth_leval_2 {

	ListNode mergeKLists_2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		return partion(lists, 0, lists.size() - 1);
	}

	// 这是一种基于归并的思想，来自k sorted list 合并的算法
	public ListNode partion(List<ListNode> lists, int s, int e) {
		if (s == e)
			return lists.get(s);
		if (s < e) {
			int q = (s + e) / 2;
			ListNode l1 = partion(lists, s, q);
			ListNode l2 = partion(lists, q + 1, e);
			return merge(l1, l2);
		} else
			return null;
	}

	// This function is from Merge Two Sorted Lists.
	public ListNode merge(ListNode l1, ListNode l2) {
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

	/**
	 * @param lists:
	 *            a list of ListNode
	 * @return: The head of one sorted list.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode new_head = new ListNode(-1);
		ListNode new_tail = new_head;

		Small_Heap_2 small_Heap_2 = new Small_Heap_2();

		ArrayList<ListNode> null_remember = new ArrayList<>();
		Map<Integer, ListNode> int_map = new HashMap<>();
		for (ListNode head : lists) {
			small_Heap_2.insert(head.val);
			int_map.put(head.val, head);
			if (head.next == null) {
				null_remember.add(head);
			} else {
				head = head.next;
			}
		}
		while (true) {

			int small_val = small_Heap_2.dele_smallest();
			new_tail.next = new ListNode(small_val);
			ListNode cur = int_map.get(small_val);
			if (cur.next == null) {
				null_remember.add(cur);
			} else {
				for (ListNode head : lists) {
					if (head == cur) {
						head = head.next;
					}
				}
			}

		}
	}
}

// 最长连续序列
class Solution_Tenth_leval_1 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return an integer
	 */
	public int longestConsecutive(int[] nums) {
		List<Integer> container = new ArrayList<Integer>();
		for (int i : nums) {
			container.add(i);
		}

		int res = 0;
		int l1, l2;
		while (!container.isEmpty()) {
			int num = container.remove(0);
			l1 = num + 1;
			l2 = num - 1;
			while (container.contains(l1)) {
				container.remove((Integer) l1);
				l1++;
			}
			while (container.contains(l2)) {
				container.remove((Integer) l2);
				l2--;
			}
			res = Math.max(res, l1 - l2 - 1);
		}

		return res;
	}
}