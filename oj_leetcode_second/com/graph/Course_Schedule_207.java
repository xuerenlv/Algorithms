package com.graph;

import java.util.Arrays;
import java.util.Stack;

public class Course_Schedule_207 {

	public static void main(String[] args) {
		int[][] prerequisites = new int[3][2];
		prerequisites[0][0] = 0;
		prerequisites[0][1] = 1;
		prerequisites[1][0] = 0;
		prerequisites[1][1] = 2;
		prerequisites[2][0] = 1;
		prerequisites[2][1] = 2;

		System.out.println(new Solution_Course_Schedule_207().canFinish(3, prerequisites));
	}

}

class Solution_Course_Schedule_207 {

	// 想法是对的，只不过超时了，哈哈
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] adj_vex = new int[numCourses][numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			adj_vex[prerequisites[i][0]][prerequisites[i][1]] = 1;
		}

		boolean[] huan = new boolean[1];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				Stack<Integer> stack = new Stack<Integer>();
				dfs(adj_vex, numCourses, i, visited, huan, stack);
				if (huan[0]) {
					return false;
				}
			}
		}

		return !huan[0];
	}

	void dfs(int[][] adj_vex, int numCourses, int v_i, boolean[] visited, boolean[] huan, Stack<Integer> stack) {
		if (stack.contains(v_i)) {
			huan[0] = true;
			return;
		}
		visited[v_i] = true;
		stack.add(v_i);
		for (int j = 0; j < numCourses; j++) {
			if (j != v_i && adj_vex[v_i][j] > 0) {
				dfs(adj_vex, numCourses, j, visited, huan, stack);
			}
		}
		stack.pop();
	}

	// 2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
	public boolean canFinish___2(int numCourses, int[][] prerequisites) {
		Graph graph = new Graph(numCourses);

		for (int i = 0; i < prerequisites.length; i++)
			graph.addEdge(prerequisites[i][0], prerequisites[i][1]);

		return !graph.isCyclic();
	}

	class Graph {
		int n; // number of vertex
		int[][] matrix; // adjacency matrix

		Graph(int x) {
			n = x;
			matrix = new int[n][n];
		}

		void addEdge(int u, int v) {
			matrix[u][v] = 1;
		}

		// check if there's a cycle in the graph
		boolean isCyclic() {
			boolean[] visited = new boolean[n];
			boolean[] stack = new boolean[n];

			for (int u = 0; u < n; u++)
				if (dfs(u, visited, stack))
					return true;

			return false;
		}

		boolean dfs(int u, boolean[] visited, boolean[] stack) {
			// mark it as visited
			visited[u] = true;
			stack[u] = true;

			// check all its neighbors
			for (int v = 0; v < n; v++)
				if (matrix[u][v] > 0)
					if (stack[v] == true || (visited[v] == false && dfs(v, visited, stack)))
						return true;

			// remove the vertex from recursion stack
			stack[u] = false;

			return false;
		}
	}
}