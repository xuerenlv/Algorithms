package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Clone_Graph_133 {

	public static void main(String[] args) {

	}

}

/**
 * Definition for undirected graph.
 * 
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

class Solution_Clone_Graph_133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new ArrayDeque<>();

		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode temp_node = queue.poll();
			if (!map.containsKey(temp_node.label)) {
				map.put(temp_node.label, new UndirectedGraphNode(temp_node.label));
				for (UndirectedGraphNode temp_list : temp_node.neighbors) {
					queue.add(temp_list);
				}
			}
		}
		
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode temp_node = queue.poll();
			UndirectedGraphNode existing_node = map.get(temp_node.label);
			if(existing_node.neighbors.isEmpty() && !temp_node.neighbors.isEmpty()){
				for (UndirectedGraphNode temp_list : temp_node.neighbors) {
					existing_node.neighbors.add(map.get(temp_list.label));
					queue.add(temp_list);
				}
			}
		}
		
		return map.get(node.label);
	}
}