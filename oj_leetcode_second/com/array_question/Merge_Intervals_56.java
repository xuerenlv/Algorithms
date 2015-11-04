package com.array_question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals_56 {

	public static void main(String[] args) {

	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class Solution_Merge_Intervals_56 {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> re = new ArrayList<Interval>();
		// 主要就是一个排序过程
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Interval pre = null;
		for (Interval in : intervals) {
			// 因为已经进行排序了，所以对于前一个，只有end有用，因为start一定是小于等于
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