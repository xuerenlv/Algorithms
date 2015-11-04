package com.array_question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Insert_Interval_57 {

	public static void main(String[] args) {

	}

}

class Solution_Insert_Interval_57 {

	// 更加直观
	public List<Interval> insert_2(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));

		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval( // we could mutate newInterval here also
					Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		result.add(newInterval); // add the union of intervals we got
		// add all the rest
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;
	}

	// 看人家的
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> re = new ArrayList<>();

		for (Interval in : intervals) {
			// 有两种情况可以直接合并
			if (newInterval == null || in.end < newInterval.start) { // 1，in在newInterval前面
				re.add(in);
			} else if (in.start > newInterval.end) {// 2， in在newInterval后面
				re.add(newInterval);
				re.add(in);
				newInterval = null;
			} else {// in与newInterval有交叉
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