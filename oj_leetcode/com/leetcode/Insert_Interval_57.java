package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57 {

	public static void main(String[] args) {

	}

}

class Solution_Insert_Interval_57 {
	//看人家的
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> re = new ArrayList<>();

		for (Interval in : intervals) {
			// 从前向后
			if (newInterval == null || in.end < newInterval.start) {
				re.add(in);
			} else if (in.start > newInterval.end) {
				re.add(newInterval);
				re.add(in);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, in.start);
				newInterval.end = Math.max(newInterval.end, in.end);
			}
		}

		if (newInterval != null) {
			re.add(newInterval);
		}

		return re;
	}
}