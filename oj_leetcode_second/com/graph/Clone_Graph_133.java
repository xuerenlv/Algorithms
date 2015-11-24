package com.graph;

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

	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph_2(UndirectedGraphNode node) {
		return clone(node);
	}

	// 递归，这里是深度优先遍历
	private UndirectedGraphNode clone(UndirectedGraphNode node) {
		if (node == null)
			return null;
		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor));
		}
		return clone;
	}

	// ＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new ArrayDeque<>();

		// 广度优先遍历
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

		// 再来一次广度优先搜索，进行复制
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode temp_node = queue.poll();
			UndirectedGraphNode existing_node = map.get(temp_node.label);
			if (existing_node.neighbors.isEmpty() && !temp_node.neighbors.isEmpty()) {
				for (UndirectedGraphNode temp_list : temp_node.neighbors) {
					existing_node.neighbors.add(map.get(temp_list.label));
					queue.add(temp_list);
				}
			}
		}

		return map.get(node.label);
	}
}