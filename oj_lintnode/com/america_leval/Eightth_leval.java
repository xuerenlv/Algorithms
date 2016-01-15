package com.america_leval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Eightth_leval {

	public static void main(String[] args) {
		String[] strs = { "hot", "dot", "dog", "lot", "log" };
		Set<String> dict = new HashSet<>(Arrays.asList(strs));

		System.out.println(new Solution_Eightth_leval_4().ladderLength_2("hit", "cog", dict));
	}

}

// 克隆图
class Solution_Eightth_leval_12 {
	/**
	 * @param node:
	 *            A undirected graph node
	 * @return: A undirected graph node
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		Map<Integer, UndirectedGraphNode> con_map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		UndirectedGraphNode p;
		while (!queue.isEmpty()) {
			p = queue.poll();
			con_map.put(p.label, new UndirectedGraphNode(p.label));
			for (UndirectedGraphNode q : p.neighbors) {
				if (!con_map.containsKey(q.label)) {
					queue.add(q);
				}
			}
		}

		ArrayList<Integer> visited = new ArrayList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			p = queue.poll();
			if (!visited.contains(p.label)) {
				for (UndirectedGraphNode q : p.neighbors) {
					con_map.get(p.label).neighbors.add(con_map.get(q.label));
					queue.add(q);
				}
				visited.add(p.label);
			}

		}

		return con_map.get(node.label);
	}
}

// 数字组合 II
class Solution_Eightth_leval_11 {
	/**
	 * @param num:
	 *            Given the candidate numbers
	 * @param target:
	 *            Given the target number
	 * @return: All the combinations that sum to target
	 */
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> re = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();

		Arrays.sort(num);
		if (target == 0)
			return re;

		search_down(num, 0, target, in, re);

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
		while (start + 1 < candiates.length && candiates[start + 1] == candiates[start])
			start++;
		search_down(candiates, start + 1, target, in, re);
	}
}

// 单词接龙 II
class Solution_Eightth_leval_10 {
	/**
	 * @param start,
	 *            a string
	 * @param end,
	 *            a string
	 * @param dict,
	 *            a set of string
	 * @return a list of lists of string
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> current = new ArrayList<List<String>>(); // swap
																	// between
																	// "current"
																	// / "next"
		List<List<String>> next;
		if (start == null || end == null)
			return current;

		dict.remove(start); // remove start if dict contains
		dict.add(end); // add end to dict
		List<String> list = new ArrayList<String>(); // first list only contains
														// start
		list.add(start);
		current.add(list);
		Set<String> curLevelVisited = new HashSet<String>();

		while (!current.isEmpty()) {
			next = new ArrayList<List<String>>(); // create a new
													// List<List<String>>
			while (!current.isEmpty()) {
				for (int i = 0; i < current.size(); i++) { // iterate "current"
					List<String> curList = current.remove(i); // get & remove
																// one
																// List<String>
																// from
																// "current"
					String curStr = curList.get(curList.size() - 1); // get last
																		// string
																		// of
																		// curList
					char[] curArr = curStr.toCharArray(); // conver to char[]
					// ------------------------------------------------------------------
					if (curStr.equals(end)) { // we find one List<String> in
												// "current" is a result, so all
												// the other results should in
												// "current" as well
						current.add(curList); // add curList back to "current"
												// as we remove it above
						List<List<String>> result = new ArrayList<List<String>>(); // this
																					// is
																					// the
																					// final
																					// result
						for (int j = 0; j < current.size(); j++) {
							List<String> tmp = current.get(j);
							String lastStr = tmp.get(tmp.size() - 1);
							if (lastStr.equals(end))
								result.add(tmp);
						}
						return result;
					}
					// -------------------------------------------------------------------
					for (int k = 0; k < curArr.length; k++) {
						for (char r = 'a'; r <= 'z'; r++) {
							char old = curArr[k]; // keep old character
							curArr[k] = r; // replacing with the new one from
											// 'a' to 'z'
							String test = String.valueOf(curArr);
							if (dict.contains(test)) {
								List<String> newList = new ArrayList<String>(curList);
								newList.add(test);
								next.add(newList); // add new constructed
													// List<String> to "next"
								curLevelVisited.add(test); // keep track of
															// newly founded
															// String
							}
							curArr[k] = old;
						}
					}
				}
			}
			dict.removeAll(curLevelVisited); // before "current" and "next"
												// switch, we need to delete all
												// String stored in
												// curLevelVisited to avoid
												// circle
			curLevelVisited.clear();
			current = next;
		}
		return current;
	}

}

// 带重复元素的排列
class Solution_Eightth_leval_9 {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of unique permutations.
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> re_list = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0)
			return re_list;
		perm(nums, 0, nums.size() - 1, re_list);
		return re_list;
	}

	public void perm(ArrayList<Integer> arr, int start, int end, ArrayList<ArrayList<Integer>> re) {
		if (start == end) {
			ArrayList<Integer> in_list = new ArrayList<Integer>(arr);
			re.add(in_list);
		} else {
			for (int i = start; i <= end; i++) {
				if (is_ok(arr, start, i)) {
					int temp;
					temp = arr.get(i);
					arr.set(i, arr.get(start));
					arr.set(start, temp);

					perm(arr, start + 1, end, re);

					temp = arr.get(i);
					arr.set(i, arr.get(start));
					arr.set(start, temp);
				}
			}
		}
	}

	boolean is_ok(ArrayList<Integer> nums, int start, int now) {
		for (int i = start; i < now; i++) {
			if (nums.get(i) == nums.get(now))
				return false;
		}
		return true;
	}

}

// 全排列
class Solution_Eightth_leval_8 {
	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of permutations.
	 */
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> re_list = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0)
			return re_list;
		perm(nums, 0, nums.size() - 1, re_list);
		return re_list;
	}

	public void perm(ArrayList<Integer> arr, int start, int end, ArrayList<ArrayList<Integer>> re) {
		if (start == end) {
			ArrayList<Integer> in_list = new ArrayList<Integer>(arr);
			re.add(in_list);
		} else {
			for (int i = start; i <= end; i++) {
				int temp;
				temp = arr.get(i);
				arr.set(i, arr.get(start));
				arr.set(start, temp);

				perm(arr, start + 1, end, re);

				temp = arr.get(i);
				arr.set(i, arr.get(start));
				arr.set(start, temp);
			}
		}
	}
}

// 子集
class Solution_Eightth_leval_7 {
	/**
	 * @param S:
	 *            A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());

		Arrays.sort(S);
		for (int i : S) {
			// tmp用于存放加入当前元素的
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
			for (ArrayList<Integer> sub : res) {
				ArrayList<Integer> a = new ArrayList<>(sub);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
		}
		return res;
	}
}

// 带重复元素的子集
class Solution_Eightth_leval_6 {
	/**
	 * @param S:
	 *            A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<ArrayList<Integer>> re = new ArrayList<>();

		Collections.sort(S);
		tran(S, 0, S.size(), in, re);

		return re;
	}

	void tran(ArrayList<Integer> S, int start, int end, ArrayList<Integer> in, ArrayList<ArrayList<Integer>> re) {
		if (start == end) {
			// 当有了重复元素之后，子集可能会发生重复
			if (!re.contains(in))
				re.add(new ArrayList<>(in));
			return;
		}

		ArrayList<Integer> in_2 = new ArrayList<>(in);
		in.add(S.get(start));
		tran(S, start + 1, end, in, re);
		tran(S, start + 1, end, in_2, re);
	}
}

// N皇后问题
class Solution_Eightth_leval_5 {
	/**
	 * Get all distinct N-Queen solutions
	 * 
	 * @param n:
	 *            The number of queens
	 * @return: All distinct solutions For example, A string '...Q' shows a
	 *          queen on forth position
	 */
	ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> re = new ArrayList<>();
		int[] pre = new int[n];
		search_down(pre, 0, re);
		return re;
	}

	void search_down(int[] pre, int start, ArrayList<ArrayList<String>> re) {
		if (start == pre.length) {
			ArrayList<String> in = new ArrayList<>();
			String one_line;
			for (int wei : pre) {
				one_line = "";
				for (int i = 0; i < pre.length; i++) {
					if (i == wei) {
						one_line += "Q";
					} else {
						one_line += ".";
					}
				}
				in.add(one_line);
			}
			re.add(in);
			return;
		}

		for (int houxuan = 0; houxuan < pre.length; houxuan++) {
			if (whether_fine(pre, start, houxuan)) {
				pre[start] = houxuan;
				search_down(pre, start + 1, re);
			}
		}
	}

	boolean whether_fine(int[] pre, int now, int houxuan) {
		for (int i = 0; i < now; i++) {
			if (pre[i] == houxuan)
				return false;
			if (Math.abs(i - now) == Math.abs(houxuan - pre[i]))
				return false;
		}
		return true;
	}

};

// 单词接龙
class Solution_Eightth_leval_4 {

	public int ladderLength_2(String start, String end, Set<String> dict) {
		if (start.length() != end.length() || start.length() == 0 || end.length() == 0 || dict.isEmpty())
			return 0;

		Queue<String> path = new LinkedList<>();
		path.add(start);
		Map<String, Integer> count = new HashMap<>();
		count.put(start, 1);

		if (dict.contains(start))
			dict.remove(start);
		while (dict.size() > 0 || !path.isEmpty()) {
			String curword = path.poll();
			int n = count.get(curword);

			for (int i = 0; i < curword.length(); i++) {
				String new_str = "";
				for (int j = 0; j < 26; j++) {
					char ne = (char) ('a' + j);
					if (ne == curword.charAt(i))
						continue;

					if (i == 0) {
						new_str = ne + curword.substring(1);
					} else if (i == curword.length() - 1) {
						new_str = curword.substring(0, curword.length() - 1) + ne;
					} else {
						new_str = curword.substring(0, i) + ne + curword.substring(i + 1);
					}

					if (new_str.equals(end))
						return n + 1;

					if (dict.contains(new_str)) {
						path.add(new_str);
						count.put(new_str, n + 1);
						dict.remove(new_str);
					}
				}
			}
		}

		return 0;
	}

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
		if (dict.contains(start))
			dict.remove(start);
		if (dict.contains(end))
			dict.remove(end);
		int[] min_step = new int[1];
		min_step[0] = Integer.MAX_VALUE;

		search_down(dict, start, end, 0, min_step);

		return min_step[0];
	}

	void search_down(Set<String> dict, String start, String end, int step, int[] minstep) {
		if (whether_two_str(start, end)) {
			if (step + 1 < minstep[0])
				minstep[0] = step + 1;
			return;
		}

		ArrayList<String> can_change_to = new ArrayList<>();
		ArrayList<String> can_gen = gen_sim_str(start);
		for (String one : can_gen) {
			if (dict.contains(one)) {
				can_change_to.add(one);
			}
		}

		for (String one : can_change_to) {
			dict.remove(one);
		}

		for (String one : can_change_to) {
			search_down(dict, one, end, step + 1, minstep);
		}
		for (String one : can_change_to) {
			dict.add(one);
		}
	}

	// whether hit->hot
	boolean whether_two_str(String one, String two) {
		int def = 0;

		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i))
				def++;
		}

		return def == 1;
	}

	ArrayList<String> gen_sim_str(String old) {
		ArrayList<String> re = new ArrayList<>();

		char ch, ne;
		for (int i = 0; i < old.length(); i++) {
			ch = old.charAt(i);
			for (int j = 0; j < 26; j++) {
				ne = (char) ('a' + j);
				if (ne == ch)
					continue;
				if (i == 0) {
					re.add(ne + old.substring(1));
				} else if (i == old.length() - 1) {
					re.add(old.substring(0, old.length() - 1) + ne);
				} else {
					re.add(old.substring(0, i) + ne + old.substring(i + 1));
				}
			}
		}

		return re;
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
		search_down(candiates, start, target, in, re);

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

// Definition for undirected graph.
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

// Definition for Directed graph.
class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};
