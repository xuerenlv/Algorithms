package com.america_leval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eightth_leval {

	public static void main(String[] args) {

	}

}

// 单词接龙
class Solution_Eightth_leval_4 {
	/**
	 * @param start,
	 *            a string
	 * @param end,
	 *            a string
	 * @param dict,
	 *            a set of string
	 * @return an integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		
		
		
	}
}

// 拓扑排序
class Solution_Eightth_leval_3 {
	/**
	 * @param graph:
	 *            A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		Map<DirectedGraphNode, Integer> node_map_in = new HashMap<>();

		for (DirectedGraphNode node : graph) {
			if (!node_map_in.containsKey(node)) {
				node_map_in.put(node, 0);
			}
			for (DirectedGraphNode one_neighbour : node.neighbors) {
				if (!node_map_in.containsKey(one_neighbour)) {
					node_map_in.put(one_neighbour, 1);
				} else {
					node_map_in.put(one_neighbour, node_map_in.get(one_neighbour) + 1);
				}
			}
		}

		ArrayList<DirectedGraphNode> re = new ArrayList<>();
		search_down(node_map_in, re);
		return re;
	}

	void search_down(Map<DirectedGraphNode, Integer> node_map_in, ArrayList<DirectedGraphNode> re) {
		if (node_map_in.isEmpty())
			return;

		ArrayList<DirectedGraphNode> ready_to_append = new ArrayList<>();
		for (DirectedGraphNode node : node_map_in.keySet()) {
			if (node_map_in.get(node) == 0) {
				ready_to_append.add(node);
			}
		}
		for (DirectedGraphNode node : ready_to_append) {
			for (DirectedGraphNode one_neighbour : node.neighbors) {
				node_map_in.put(one_neighbour, node_map_in.get(one_neighbour) - 1);
			}
			node_map_in.remove(node);
		}
		re.addAll(ready_to_append);
		search_down(node_map_in, re);
	}

}

// 数字组合
class Solution_Eightth_leval_2 {
	/**
	 * @param candidates:
	 *            A list of integers
	 * @param target:An
	 *            integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> re = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();

		Arrays.sort(candidates);
		if (target == 0)
			return re;

		search_down(candidates, 0, target, in, re);

		return re;
	}

	void search_down(int[] candiates, int start, int target, ArrayList<Integer> in, List<List<Integer>> re) {
		if (start >= candiates.length || candiates[start] > target)
			return;
		if (target == candiates[start]) {
			in.add(candiates[start]);
			re.add(new ArrayList<Integer>(in));
			in.remove((Integer) candiates[start]); // 添加完了之后，要还原
			return;
		}

		in.add(candiates[start]);
		target -= candiates[start];
		search_down(candiates, start + 1, target, in, re);

		in.remove((Integer) candiates[start]);
		target += candiates[start];
		search_down(candiates, start + 1, target, in, re);
	}

}

// 组合
class Solution_Eightth_leval_1 {
	/**
	 * @param n:
	 *            Given the range of numbers
	 * @param k:
	 *            Given the numbers of combinations
	 * @return: All the combinations of k numbers out of 1..n
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> re = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++)
			nums.add(i);

		if (k == 0)
			return re;
		if (n <= k) {
			re.add(nums);
			return re;
		}

		combine_down(nums, k, in, re);

		return re;
	}

	void combine_down(ArrayList<Integer> nums, int k, ArrayList<Integer> in, List<List<Integer>> re) {
		if (k == 1) {
			for (Integer num : nums) {
				in.add(num);
				re.add(new ArrayList<Integer>(in));
				in.remove(num);
			}
			return;
		}

		ArrayList<Integer> copy_nums = new ArrayList<Integer>(nums);
		k--;
		for (Integer num : nums) {
			in.add(num);
			copy_nums.remove(num);
			combine_down(copy_nums, k, in, re);
			// 后面的元素比前面的要大，所以要减轻搜索空间，不需要重新添加进去
			// copy_nums.add(num);
			in.remove(num);
		}
		return;
	}

}

// Definition for Directed graph.
class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};
