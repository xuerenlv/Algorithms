package com.leetcode.failed;

import java.util.Arrays;

public class Course_Schedule_II_210 {

	public static void main(String[] args) {
		int[][] prerequisites = new int[2][2];
		prerequisites[0][0] = 0;
		prerequisites[0][1] = 1;
		prerequisites[1][0] = 2;
		prerequisites[1][1] = 0;

		int[] re = new Solution_Course_Schedule_II_210().findOrder(3, prerequisites);
		System.out.println(Arrays.toString(re));
	}

}

class Solution_Course_Schedule_II_210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		
		return  new int[1];
	}

	// Time Limit Exceeded
	// 可以使用，但是超时
	public int[] findOrder_overtime(int numCourses, int[][] prerequisites) {
		int[][] adj_vex = new int[numCourses][numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			adj_vex[prerequisites[i][0]][prerequisites[i][1]] = 1;
		}
		int[] re = new int[numCourses];
		int index = 0;
		int index_pre = 0;

		boolean[] visited = new boolean[numCourses];
		while (index < numCourses) {
			for (int i = 0; i < numCourses; i++) { // 对于numCourses个节点
				if (visited[i])
					break;
				boolean no_in = true;
				for (int j = 0; j < numCourses; j++) {
					if (adj_vex[j][i] > 0) {
						no_in = false;
						break;
					}
				}
				if (no_in) {
					visited[i] = true;
					re[index++] = i;
					for (int j = 0; j < numCourses; j++) {
						adj_vex[i][j] = 0;
					}
				}
			}
			if (index == index_pre) {
				return new int[numCourses];
			} else {
				index_pre = index;
			}
		}
		return re;
	}
}