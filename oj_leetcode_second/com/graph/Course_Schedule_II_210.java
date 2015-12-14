package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

// 邻接矩阵有问题，下面尝试邻接表
// 建立入边表
// Time Limit Exceeded

class Solution_Course_Schedule_II_210 {
	
	public int[] findOrder_other_people(int numCourses, int[][] prerequisites) {
		List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();  
        for (int i = 0; i < numCourses; i++) {  
            adjLists.add(new HashSet<Integer>());  
        }  
          
        for (int i = 0; i < prerequisites.length; i++) {  
            adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);  
        }  
          
        int[] indegrees = new int[numCourses];  
        for (int i = 0; i < numCourses; i++) {  
            for (int x : adjLists.get(i)) {  
                indegrees[x]++;  
            }  
        }  
        
        // queue 里面放入读为 0 的顶点
        Queue<Integer> queue = new LinkedList<Integer>();  
        for (int i = 0; i < numCourses; i++) {  
            if (indegrees[i] == 0) {  
                queue.offer(i);  
            }  
        }  
          
        int[] res = new int[numCourses];  
        int count = 0;  
        while (!queue.isEmpty()) {  
            int cur = queue.poll();  
            for (int x : adjLists.get(cur)) {  
                indegrees[x]--;  
                if (indegrees[x] == 0) {  
                    queue.offer(x);  
                }  
            }  
            res[count++] = cur;  
        }  
          
        if (count == numCourses) return res;  
        return new int[0];  
	}
	
	// 邻接矩阵有问题，下面尝试邻接表
	// 建立入边表
	// Time Limit Exceeded
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			adjLists.add(new HashSet<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		ArrayList<Integer> re = new ArrayList<>();
		int index = 0;
		while (index < numCourses) {
			boolean no_in = false;
			int i = 0;
			for (; i < numCourses; i++) {
				if (adjLists.get(i).size() == 0 || re.containsAll(adjLists.get(i))) {
					no_in = true;
				}
			}
			if (no_in == false) {
				return new int[numCourses];
			} else {
				re.add(i);
				index++;
			}
		}
		int[] re_s = new int[numCourses];
		int i = 0;
		for (int in : re) {
			re_s[i++] = in;
		}
		return re_s;
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