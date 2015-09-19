package com.interview.yinxiangbiji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class meituan____2015_biji {

	public static void main(String[] args) {
		// String[] container = { "at", "", "", "ball", "car", "dad", "", "", ""
		// };
		// System.out.println(new
		// Solution_meituan____2015_biji().find_word(container, "ball"));

		// int[] nums = { 3, 3, 3 };
		// int[] re = new Solution_meituan____2015_biji().trible_cut(nums);
		// System.out.println(Arrays.toString(re));

		int[] big = { 1, 3, 5, 7 };
		int[] small = { 1, 5, 5 };
		System.out.println(new Solution_meituan____2015_biji().is_contain(big, small));
	}

}

class Solution_meituan____2015_biji {

	// 6 ip 所有合适的ip地址
	public List<String> restoreIpAddresses(String s) {
		List<String> re = new ArrayList<>();
		String houxuan = "";
		int partion = 4;
		tranverse_str(s, 0, s.length(), partion, houxuan, re);
		return re;
	}

	void tranverse_str(String s, int start, int end, int part, String houxuan, List<String> re) {
		if (part < 0)
			return;
		if (start > end) {
			return;
		}
		if (start == end) {
			if (part == 0)
				re.add(houxuan);
			return;
		}

		if (s.charAt(start) == '0') {
			String add_str = "";
			if (part == 4) {
				add_str = "0";
			} else {
				add_str = "." + "0";
			}
			houxuan += add_str;
			tranverse_str(s, start + 1, end, part - 1, houxuan, re);
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (start + i > s.length())
				return;
			String se = s.substring(start, start + i);
			int se_int = Integer.parseInt(se);
			if (se_int < 256) {
				String add_str = "";
				if (part == 4) {
					add_str = se;
				} else {
					add_str = "." + se;
				}
				houxuan = houxuan + add_str;
				tranverse_str(s, start + i, end, part - 1, houxuan, re);
				houxuan = houxuan.substring(0, houxuan.length() - add_str.length());
			}
		}
	}

	// 5 将奇数放在前面
	void re_array(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				if (i != index) {
					int temp = nums[i];
					nums[i] = nums[index];
					nums[index] = temp;
				}
				index++;
			}
		}
	}

	// 4

	// 3 数组包含
	boolean is_contain(int[] big, int[] small) {
		int i = 0;
		int j = 0;

		while (j < small.length && i < big.length) {
			if (j - 1 >= 0 && small[j] == small[j - 1])
				j++;
			if (j >= small.length)
				return true;
			if (big[i] < small[j])
				i++;
			else if (big[i] == small[j]) {
				i++;
				j++;
			} else {
				return false;
			}
		}

		return true;
	}

	// 2 整数数组，3等分
	int[] trible_cut(int[] nums) {
		int[] re = new int[2];
		if (nums.length < 3)
			return re;

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		ArrayList<Integer> i_temp = new ArrayList<>();
		int first = nums[0];
		int second = sum - nums[0];
		for (int i = 1; i < nums.length - 1; i++) {
			if (second % first == 0 && second / first == 2) {
				i_temp.add(i);
			}
			first += nums[i];
			second -= nums[i];
		}

		for (int i : i_temp) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
			}
			first = nums[i];
			second = sum - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (first == second) {
					re[0] = i;
					re[1] = j;
					return re;
				}
				first += nums[j];
				second -= nums[j];
			}
		}
		return re;
	}

	// 1 []
	// binary search
	int find_word(String[] container, String word) {
		int start = 0;
		int end = container.length - 1;

		while (start <= end) {
			while (container[start] == "" && start < container.length)
				start++;
			while (container[end] == "" && end >= 0)
				end--;
			if (start > end)
				return -1;
			int mid = (start + end) >> 2;
			if (container[mid] == "") {
				mid = start;
			}
			if (container[mid].equals(word))
				return mid;
			else {
				if (container[mid].charAt(0) <= word.charAt(0)) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;
	}

}