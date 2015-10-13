package com.HashTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HashTreeNode {
	// 最多5个分支
	HashTreeNode[] branch = new HashTreeNode[5];
	// 所处深度
	int level;
	// 是不是叶子节点
	boolean isleaf;
	// 当是叶子节点时，这个container_map 用于存放数据
	Map<String, Integer> container_map = new HashMap<>();

	public HashTreeNode(int leval, boolean isleaf, String canstr) {
		this.level = leval;
		this.isleaf = isleaf;
		if (canstr != null)
			container_map.put(canstr, 0);
	}
}

public class HashTree {
	HashTreeNode root;
	int max_depth;

	// 3...1 构造hash树，传入参数为 树的最大深度
	public HashTree(int depth) {
		root = new HashTreeNode(1, false, null);
		this.max_depth = depth;
	}

	// 3...2 加入每一个candidate string
	public void add(String can_str) {
		String[] can_str_arr = can_str.substring(1).split(" ");
		add_pri(can_str, can_str_arr, root);
	}

	private void add_pri(String can_str, String[] can_str_arr, HashTreeNode tree_node) {
		// 当前节点时中间节点
		if (!tree_node.isleaf) {
			int branch_num = Integer.valueOf(can_str_arr[tree_node.level - 1]) % 5;
			if (tree_node.branch[branch_num] == null)
				tree_node.branch[branch_num] = new HashTreeNode(tree_node.level + 1, true, can_str);
			else
				add_pri(can_str, can_str_arr, tree_node.branch[branch_num]);
			return;
		}
		tree_node.container_map.put(can_str, 0);
		// 当达到最大深度，或者对于候选item，已经hash到最后一个位置
		if (tree_node.level == max_depth || tree_node.level - 1 == can_str_arr.length) {
			return;
		} else {
			// 当前叶子节点，中已加入的 itemset 的数量
			int size = tree_node.container_map.size();
			if (size > 5) { // 当个数大于 5 时，进行节点分裂
				Set<String> all_itemset = tree_node.container_map.keySet();
				for (String candata_itemset : all_itemset) {
					String[] candata_itemset_arr = candata_itemset.substring(1).split(" ");
					int branch_num = Integer.valueOf(candata_itemset_arr[tree_node.level - 1]) % 5;
					if (tree_node.branch[branch_num] == null)
						tree_node.branch[branch_num] = new HashTreeNode(tree_node.level + 1, true, candata_itemset);
					else
						add_pri(candata_itemset, candata_itemset_arr, tree_node.branch[branch_num]);
				}
				tree_node.isleaf = false;
				tree_node.container_map.clear();
			}
		}
	}

	// 3...3 对于每一个transaction，要进入hashtree
	public void check_trans(String transaction) {
		if (transaction.equals(""))
			return;
		String[] transaction_arr = transaction.substring(1).split(" ");
		List<String> already_visited_leafs = new ArrayList<>();
		String leaf_id = "";

		for (int i = 0; i < transaction_arr.length; i++) {
			check_trans_pri(root, transaction_arr, i, leaf_id, already_visited_leafs);
		}
	}

	private void check_trans_pri(HashTreeNode treeNode, String[] transaction_arr, int index, String leaf_id,
			List<String> already_visited_leafs) {
		if (!treeNode.isleaf) { // 非叶子节点
			if (index < transaction_arr.length) {
				while(index<transaction_arr.length){
					int branch_num = Integer.valueOf(transaction_arr[index]) % 5;
					if (treeNode.branch[branch_num] != null) {
						check_trans_pri(treeNode.branch[branch_num], transaction_arr, index + 1, leaf_id + branch_num,
								already_visited_leafs);
					}
					index++;
				}
			}
		} else {// 叶子节点
			if (already_visited_leafs.contains(leaf_id)) {
				return;
			} else {
				already_visited_leafs.add(leaf_id);
			}
			for (String can_item_set : treeNode.container_map.keySet()) {
				String[] can_item_set_arr = can_item_set.substring(1).split(" ");
				if (is_transaction_contains_item(transaction_arr, can_item_set_arr)) {
					treeNode.container_map.put(can_item_set, treeNode.container_map.get(can_item_set) + 1);
				}
			}
		}
	}

	// 判断一个项集是不是在transaction中
	private boolean is_transaction_contains_item(String[] transaction_arr, String[] can_item_set_arr) {
		List<String> transaction_li = Arrays.asList(transaction_arr);
		for (String item : can_item_set_arr)
			if (!transaction_li.contains(item))
				return false;
		return true;
	}

	// 3...4 对于hashtree 进行收集，返回 F(k+1) 与对应的 sup
	public Map<String, Float> collect_all_leafs(int file_list_size, float minsup) {
		Map<String, Float> re_map = new HashMap<>();
		collect_all_leafs_pri(re_map, root, file_list_size, minsup);
		return re_map;
	}

	private void collect_all_leafs_pri(Map<String, Float> re_map, HashTreeNode treeNode, int file_list_size,float minsup) {
		if (treeNode.isleaf) {
			for (Map.Entry<String, Integer> entry : treeNode.container_map.entrySet()) {
				float sup = (float) entry.getValue() / (float) file_list_size;
				if (sup - minsup > 0) {
					re_map.put(entry.getKey(), sup);
				}
			}
		} else {
			for (int i = 0; i < 5; i++) {
				HashTreeNode branch = treeNode.branch[i];
				if (branch != null)
					collect_all_leafs_pri(re_map, branch, file_list_size, minsup);
			}
		}
	}
}
