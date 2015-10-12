package com.HashTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main_Run {

	public static void main(String[] args) {
		List<String> file_list = read_file();
		float minsup = (float) 0.144;
		int items = 11;
		List<Map<String, Float>> frequent_items_all = new ArrayList<>();

		// for (Map.Entry<String, Float> iEntry :
		// frequent_items_all.get(0).entrySet())
		// System.out.println(iEntry.getKey() + "->" + iEntry.getValue());

		int k = 1;
		frequent_items_all.add(k - 1, generate_all_one_fre_item(file_list, minsup, items));
		while (true) {
			// 1 generate C(k+1) by joiningitemset-pairs in F(k)
			// 1...1 提取 F（k）
			Set<String> F_k_set = frequent_items_all.get(k - 1).keySet();
			String[] F_k_arr = new String[F_k_set.size()];
			F_k_set.toArray(F_k_arr);
			// 1...2 对 F_k_arr 赋一个序列，这里使用字典序。
			sort_str_arr_by_dic(F_k_arr, 0, F_k_arr.length - 1);
			// 1...3 根据F（k） 生成候选的 C（k+1）
			List<String> C_k_plus_1 = generate_c_k_plus_1(F_k_arr);

			// 2 prune itemsetsfrom C(k+1) that violate download closure
			List<String> C_k_plus_1_atter_prune = new ArrayList<>();
			for (String candate_str : C_k_plus_1) {
				// 2...1 对于一个 candate_str 生成所有 len－1 的子集
				List<String> candate_str_len_minus_1 = gen_candate_str_len_minus_1(candate_str);
				// 2...2 判断 len－1 的子集 是否全在 F（k）中
				if (is_contain_all(F_k_set, candate_str_len_minus_1))
					C_k_plus_1_atter_prune.add(candate_str);
			}
			// 如果经过过滤之后，候选集为空，则跳出循环
			if (C_k_plus_1_atter_prune.isEmpty())
				break;

			// 3 Determine Fk+1 by support counting on (Ck+1, T ) and retaining
			// itemsets from Ck+1 with support at least minsup;
			// 3...1 构造hash树，传入参数为 树的最大深度
			HashTree hashTree = new HashTree(3);
			// 3...2 加入每一个candidate string
			for (String can_str : C_k_plus_1_atter_prune)
				hashTree.add(can_str);
			// 3...3 对于每一个transaction，要进入hashtree
			for (String one_tran : file_list)
				hashTree.check_trans(one_tran);
			// 3...4 对于hashtree 进行收集，返回 F(k+1) 与对应的 sup
			Map<String, Float> F_k_plus_1_map = hashTree.collect_all_leafs(file_list.size(), minsup);

			// Map<String, Float> F_k_plus_1_map =
			// blute_force(file_list,C_k_plus_1_atter_prune,minsup);

			// 4 若 F(k+1) 为空，则跳出循环
			if (F_k_plus_1_map.isEmpty()) {
				break;
			} else {
				frequent_items_all.add(k, F_k_plus_1_map);
			}

			k++;
		}

		Map<String, Float> all_frequent_items = new HashMap<>();
		for (Map<String, Float> one_map : frequent_items_all) {
			all_frequent_items.putAll(one_map);
		}
		// System.out.println(all_frequent_items.toString());
		Set<String> all_key_set = all_frequent_items.keySet();
		String[] all_key_arr = new String[all_key_set.size()];
		all_key_set.toArray(all_key_arr);
		sort_str_arr_by_dic(all_key_arr, 0, all_key_arr.length - 1);
		for (String one_key : all_key_arr) {
			System.out.println(one_key + "->" + all_frequent_items.get(one_key));
		}
	}

	// 穷举法生成 Determine Fk+1 by support counting on (Ck+1, T ) and retaining
	// 用于检验结果
	public static Map<String, Float> blute_force(List<String> file_list, List<String> C_k_plus_1_atter_prune,
			float minsup) {
		Map<String, Float> re = new HashMap<>();
		Map<String, Integer> count_map = new HashMap<>();
		for (String one_tran : file_list) {
			if (one_tran.equals(""))
				continue;
			String[] transaction_arr = one_tran.substring(1).split(" ");
			for (String one_can : C_k_plus_1_atter_prune) {
				String[] can_item_set_arr = one_can.substring(1).split(" ");
				if (is_transaction_contains_item(transaction_arr, can_item_set_arr)) {
					if (count_map.containsKey(one_can)) {
						count_map.put(one_can, count_map.get(one_can) + 1);
					} else {
						count_map.put(one_can, 1);
					}
				}
			}
		}
		for (String key : count_map.keySet()) {
			float val = (float) count_map.get(key) / (float) file_list.size();
			if (val > minsup)
				re.put(key, val);
		}
		return re;
	}

	// 判断一个项集是不是在transaction中
	private static boolean is_transaction_contains_item(String[] transaction_arr, String[] can_item_set_arr) {
		List<String> transaction_li = Arrays.asList(transaction_arr);
		for (String item : can_item_set_arr)
			if (!transaction_li.contains(item))
				return false;
		return true;
	}

	// 2...2 判断 len－1 的子集 是否全在 F（k）中
	public static boolean is_contain_all(Set<String> F_k_set, List<String> candate_str_len_minus_1) {
		for (String can : candate_str_len_minus_1) {
			if (!F_k_set.contains(can))
				return false;
		}
		return true;
	}

	// 2...1 对于一个 candate_str 生成所有 len－1 的子集
	// 如 "_1_3_6"->"_3_6"+"_1_6"+"_1_3"
	public static List<String> gen_candate_str_len_minus_1(String candate_str) {
		List<String> re = new ArrayList<>();
		String[] candate_items = candate_str.substring(1).split(" ");
		for (int i = 0; i < candate_items.length; i++) {
			String one = "";
			for (int j = 0; j < candate_items.length; j++) {
				if (j != i)
					one += " " + candate_items[j];
			}
			re.add(one);
		}
		return re;
	}

	// 1...3 根据F（k） 生成候选的 C（k+1）
	// 此时的 F_k_arr 是有序的
	public static List<String> generate_c_k_plus_1(String[] F_k_arr) {
		List<String> re = new ArrayList<>();
		for (int i = 0; i < F_k_arr.length - 1; i++) {
			String cur = F_k_arr[i];
			for (int j = i + 1; j < F_k_arr.length; j++) {
				String op = F_k_arr[j];
				// 判断前 len－1 项是否相同
				if (is_same_len_minus_1(cur, op)) {
					// 对于 两个前 len－1 项相同的，生成候选的项
					re.add(combine_two_gen_one(cur, op));
				} else {
					break;
				}
			}
		}
		return re;
	}

	// 对于 两个前 len－1 项相同的， 生成候选的项
	public static String combine_two_gen_one(String str1, String str2) {
		String[] str1_arr = str1.substring(1).split(" ");
		String[] str2_arr = str2.substring(1).split(" ");
		String re = "";
		int i = 0;
		while (i < str1_arr.length - 1) {
			re += " " + str1_arr[i];
			i++;
		}
		if (Integer.parseInt(str1_arr[i]) < Integer.parseInt(str2_arr[i])) {
			re += " " + str1_arr[i] + " " + str2_arr[i];
		} else {
			re += " " + str2_arr[i] + " " + str1_arr[i];
		}
		return re;
	}

	// 判断两个 String 的 前 len－1 项是否相同
	public static boolean is_same_len_minus_1(String str1, String str2) {
		String[] str1_arr = str1.split(" ");
		String[] str2_arr = str2.split(" ");
		int i = 0;
		while (i < str1_arr.length) {
			if (!str1_arr[i].equals(str2_arr[i]))
				break;
			i++;
		}
		return i == str1_arr.length - 1;
	}

	// 对字符串数组进行排序，这里的字符串形如：“1 5 6 11”（每两个项之间使用空格进行分割）
	// 使用 快速排序算法
	public static void sort_str_arr_by_dic(String[] str_arr, int start, int end) {
		if (start < end) {
			int part = partion_quick_sort(str_arr, start, end);
			sort_str_arr_by_dic(str_arr, start, part - 1);
			sort_str_arr_by_dic(str_arr, part + 1, end);
		}
	}

	// 快速排序，的划分函数
	public static int partion_quick_sort(String[] str_arr, int left, int right) {
		String part_str = str_arr[left];
		while (left < right) {
			while (left < right && compare_str(part_str, str_arr[right]) == -1)
				right--;
			if (left < right) {
				str_arr[left] = str_arr[right];
				left++;
			}
			while (left < right && compare_str(part_str, str_arr[left]) == 1)
				left++;
			if (left < right) {
				str_arr[right] = str_arr[left];
				right--;
			}
		}
		str_arr[left] = part_str;
		return left;
	}

	// 对两个字符串，用字典序进行比较
	public static int compare_str(String str1, String str2) {
		String[] str1_arr = str1.split(" ");
		String[] str2_arr = str2.split(" ");
		int i = 0;
		int j = 0;
		while (i < str1_arr.length && j < str2_arr.length) {
			if (!str1_arr[i].equals(str2_arr[j])) {
				return Integer.parseInt(str1_arr[i]) > Integer.parseInt(str2_arr[j]) ? 1 : -1;
			} else {
				i++;
				j++;
			}
		}
		if (i == str1_arr.length && j == str2_arr.length)
			return 0;
		else
			return j == str2_arr.length ? 1 : -1;
	}

	// 返回 频繁项（大小为 1 的）
	public static Map<String, Float> generate_all_one_fre_item(List<String> file_list, float minsup, int items) {
		Map<String, Float> re = new HashMap<>();
		for (int i = 1; i <= items; i++) {
			float count = (float) 0.0;
			for (String line : file_list)
				for (String item : line.split(" "))
					if (item.equals(new Integer(i).toString()))
						count += 1.0;
			float val = count / file_list.size();
			if (val - minsup >= 0.0) {
				re.put(" " + new Integer(i).toString(), val);
			}
		}
		return re;
	}

	// 对于 assignment2-data.txt 的每一行
	// 如： 0 1 0 1 0 1 。。。 返回： “ 2 4 6 ...”
	public static List<String> read_file() {
		File file = new File("./nlp_er/assignment2-data.txt");
		List<String> re = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("file does not existed !");
			e.printStackTrace();
		}

		String line = "";
		try {
			reader.readLine(); //  不读第一行
			while ((line = reader.readLine()) != null) {
				String line_str = "";
				String[] split = line.split(" ");
				for (int i = 0; i < split.length; i++) {
					if (split[i].equals("1"))
						line_str += " " + (i + 1);
				}
				re.add(line_str);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return re;
	}

}
