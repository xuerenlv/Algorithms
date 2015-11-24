package com.greedy;

public class Gas_Station_134 {

	public static void main(String[] args) {
		int[] gas = { 3 };
		int[] cost = { 2 };
		System.out.println(new Solution_Gas_Station_134().canCompleteCircuit_2(gas, cost));
		System.out.println(new Solution_Gas_Station_134().canCompleteCircuit_1(gas, cost));
	}

}

class Solution_Gas_Station_134 {

	// 深入分析题目
	public int canCompleteCircuit_3(int[] gas, int[] cost) {
		int len = gas.length;
		if (len == 0 || len != cost.length)
			return -1;
		int sum = 0;
		int total = 0;
		int start = 0;
		for (int i = 0; i < len; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				start = (i + 1) % len;
				sum = 0;
			}
		}

		if (total < 0)
			return -1;
		else
			return start;

	}

	// overtime
	public int canCompleteCircuit_2(int[] gas, int[] cost) {
		int len = gas.length;
		if (len == 0 || len != cost.length)
			return -1;
		for (int j = 0; j < len; j++) {
			int tank = 0;
			boolean work = true;
			int i = j;
			do {
				tank += gas[i] - cost[i];
				if (tank < 0) {
					work = false;
					break;
				}
				i = (i + 1) % len;
			} while (i != j);
			if (work) {
				return j;
			}
		}
		return -1;
	}

	public int canCompleteCircuit_1(int[] gas, int[] cost) {
		int len = gas.length;
		if (len == 0 || len != cost.length)
			return -1;
		int tank = 0;
		int begin = 0;
		int end = 0;
		int i = 0;
		for (int n = 0; n < len - 1; n++) {
			tank += gas[i] - cost[i];
			if (tank > 0) {
				end++;
				if (end >= len) {
					end = 0;
				}
				i = end;
			} else {
				begin--;
				if (begin < 0) {
					begin = len - 1;
				}
				i = begin;
			}
		}
		tank += gas[i] - cost[i];
		if (tank >= 0) {
			return begin;
		} else {
			return -1;
		}
	}
}