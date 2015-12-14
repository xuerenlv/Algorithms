package com.need_think;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class The_Skyline_Problem_218 {

	public static void main(String[] args) {

	}

}

class Solution_The_Skyline_Problem_218 {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> re = new ArrayList<>();

		// 递减，序列
		PriorityQueue<Integer> priority_queue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		List<int[]> con_li = new ArrayList<int[]>();
		for (int i = 0; i < buildings.length; i++) {
			int[] b = buildings[i];
			con_li.add(new int[] { b[0], b[2] });
			con_li.add(new int[] { b[1], -b[2] });
		}

		Collections.sort(con_li, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o2[1] - o1[1];
				}
			}
		});

		int pre = 0;
		int cur = 0;
		for (int i = 0; i < con_li.size(); i++) {
			int[] now = con_li.get(i);
			if (now[1] > 0) {
				priority_queue.add(now[1]);
				cur = priority_queue.peek();
			} else {
				priority_queue.remove(-now[1]);
				cur = (priority_queue.peek() == null) ? 0 : priority_queue.peek();
			}
			if (cur != pre) {
				re.add(new int[] { now[0], cur });
				pre = cur;
			}
		}

		return re;
	}
}