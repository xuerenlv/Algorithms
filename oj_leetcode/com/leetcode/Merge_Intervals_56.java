package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals_56 {

	public static void main(String[] args) {

	}

}

class Solution_Merge_Intervals_56 {

	//
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> re = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Interval pre = null;
		for (Interval in : intervals) {
			if (pre == null || pre.end < in.start) {
				re.add(in);
				pre = in;
			} else if (pre.end < in.end) {
				// 修改已在re中的元素
				pre.end = in.end;
			}
		}

		return re;
	}
}