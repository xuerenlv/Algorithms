package com.america_leval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Fivth_leval {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution_Fivth_leval_10().to_binary(4)));
	}

}

// 跳跃游戏 II
class Solution_Fivth_leval_12 {
	/**
	 * @param A:
	 *            A list of lists of integers
	 * @return: An integer
	 */
	public int jump(int[] A) {
		if (A.length <= 1)
			return 0;

		int i = 0, step = 1;
		while (i + A[i] < A.length - 1) {

			int maxindex = i;
			for (int j = i + 1; j <= i + A[i]; j++)
				if (j + A[j] >= maxindex + A[maxindex]) {
					maxindex = j;
				}
			step++;
			i = maxindex;
		}
		return step;
	}
}

// 落单的数 III
class Solution_Fivth_leval_11 {
	/**
	 * @param A
	 *            : An integer array
	 * @return : Two integers
	 */
	public List<Integer> singleNumberIII(int[] A) {
		int mask = 0;
		for (int i = 0; i < A.length; i++)
			mask ^= A[i];
		mask = mask - 1;

		int re1 = 0, re2 = 0;
		for (int i = 0; i < A.length; i++) {
			if ((A[i] & mask) != 0) {
				re1 ^= A[i];
			} else {
				re2 ^= A[i];
			}

		}

		List<Integer> li = new ArrayList<>();
		li.add(re1);
		li.add(re2);
		return li;
	}
}

// 落单的数 II
class Solution_Fivth_leval_10 {
	/**
	 * @param A
	 *            : An integer array
	 * @return : An integer
	 */
	public int singleNumberII(int[] A) {
		int[] wei = new int[32];

		for (int i = 0; i < A.length; i++) {
			Integer[] bin = to_binary(A[i]);
			for (int j = 0; j < bin.length; j++) {
				if (bin[j] == 1)
					wei[j]++;
			}
		}

		int re = 0;
		for (int i = 0; i < 32; i++) {
			if (wei[i] % 3 != 0)
				re += 1 << i;

		}

		return re;
	}

	Integer[] to_binary(int num) {
		ArrayList<Integer> bin = new ArrayList<>();
		while (num != 0) {
			bin.add(num & 1);
			num = num >>> 1;
		}
		// Collections.reverse(bin);
		Integer[] re = bin.toArray(new Integer[bin.size()]);
		return re;
	}

}

// 主元素 III
class Solution_Fivth_leval_9 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @param k:
	 *            As described
	 * @return: The majority number
	 */
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		HashMap<Integer, Integer> k_map_count = new HashMap<>();

		for (int i = 0; i < nums.size(); i++) {
			int num = nums.get(i);
			if (k_map_count.containsKey(num)) {
				k_map_count.put(num, k_map_count.get((Integer) num) + 1);
			} else if (k_map_count.size() < k) {
				k_map_count.put(num, 1);
			} else {
				ArrayList<Integer> remove_key = new ArrayList<>();
				Set<Map.Entry<Integer, Integer>> entry_set = k_map_count.entrySet();
				for (Map.Entry<Integer, Integer> one_entry : entry_set) {
					if (one_entry.getValue() == 1)
						remove_key.add(one_entry.getKey());
					else {
						k_map_count.put(one_entry.getKey(), one_entry.getValue() - 1);
					}
				}
				for (Integer key : remove_key)
					k_map_count.remove(key);
			}
		}

		int re = Integer.MAX_VALUE;
		int count = 0;
		for (Map.Entry<Integer, Integer> one_entry : k_map_count.entrySet()) {
			if (one_entry.getValue() > count) {
				count = one_entry.getValue();
				re = one_entry.getKey();
			}
		}
		return re;

	}
}

// 主元素 II 采用抵消法
class Solution_Fivth_leval_8 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: The majority number that occurs more than 1/3
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		if (nums == null)
			return 0;
		int num1 = Integer.MIN_VALUE;
		int times1 = 0;
		int num2 = Integer.MIN_VALUE;
		int times2 = 0;
		for (int i = 0; i < nums.size(); i++) {
			int num = nums.get(i);
			if (num1 == num) {
				times1++;
			} else if (num2 == num) {
				times2++;
			} else if (times1 == 0) {
				times1 = 1;
				num1 = num;
			} else if (times2 == 0) {
				times2 = 1;
				num2 = num;
			} else {
				times1--;
				times2--;
			}
		}
		times1 = 0;
		times2 = 0;
		for (int i = 0; i < nums.size(); i++) {
			int num = nums.get(i);
			if (num == num1) {
				times1++;
			} else if (num == num2) {
				times2++;
			}
		}
		return times1 > times2 ? num1 : num2;
	}
}

// 下一个排列
class Solution_Fivth_leval_7 {
	/**
	 * @param nums:
	 *            an array of integers
	 * @return: return nothing (void), do not return anything, modify nums
	 *          in-place instead
	 */
	public int[] nextPermutation(int[] num) {
		// 1.找到最后一个升序位置pos
		int pos = -1;
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				pos = i - 1;
				break;
			}
		}

		// 2.如果不存在升序，即这个数是最大的，那么反排这个数组
		if (pos < 0) {
			reverse(num, 0, num.length - 1);
			return num;
		}

		// 3.存在升序，那么找到pos之后最后一个比它大的位置
		for (int i = num.length - 1; i > pos; i--) {
			if (num[i] > num[pos]) {
				int tmp = num[i];
				num[i] = num[pos];
				num[pos] = tmp;
				break;
			}
		}

		// 4.反排pos之后的数
		reverse(num, pos + 1, num.length - 1);
		return num;
	}

	// 反转数组
	public void reverse(int[] num, int begin, int end) {
		int l = begin, r = end;
		while (l < r) {
			int tmp = num[l];
			num[l] = num[r];
			num[r] = tmp;
			l++;
			r--;
		}
	}
}

// 跳跃游戏 从后向前看，也是可以的
class Solution_Fivth_leval_6 {
	/**
	 * @param A:
	 *            A list of integers
	 * @return: The boolean answer
	 */
	public boolean canJump(int[] A) {
		boolean[] can = new boolean[A.length];
		can[A.length - 1] = true;

		for (int i = A.length - 2; i >= 0; i--) {
			if (i + A[i] >= A.length) {
				can[i] = true;
				continue;
			}
			if (A[i] == 0) {
				can[i] = false;
				continue;
			}

			for (int j = 1; j <= A[i]; j++) {
				if (can[i + j] == true) {
					can[i] = true;
					break;
				}
			}

		}
		return can[0];

	}

}

// 删除数字 删除第一个峰点
class Solution_Fivth_leval_5 {
	/**
	 * @param A:
	 *            A positive integer which has N digits, A is a string.
	 * @param k:
	 *            Remove k digits.
	 * @return: A string
	 */
	public String DeleteDigits(String A, int k) {
		String temp = A;
		while (k-- > 0) {
			int i = 0;
			while (i < temp.length() - 1 && temp.charAt(i) <= temp.charAt(i + 1))
				i++;
			temp = temp.substring(0, i) + temp.substring(i + 1, temp.length());
		}
		int i = 0;
		while (i < temp.length() && temp.charAt(i) == '0')
			i++;

		return temp.substring(i);
	}
}

// 最大数
class Solution_4 {
	/**
	 * @param num:
	 *            A list of non negative integers
	 * @return: A string
	 */
	public String largestNumber(int[] num) {
		boolean swap_ornot = false;
		int swap;
		for (int i = 0; i < num.length - 1; i++) {
			swap_ornot = false;
			for (int j = num.length - 1; j > i; j--) {
				if (!my_cmp(num[j - 1], num[j])) {
					swap = num[j];
					num[j] = num[j - 1];
					num[j - 1] = swap;
					swap_ornot = true;
				}
			}
			if (!swap_ornot)
				break;
		}

		String re = "";
		for (int i = 0; i < num.length; i++) {
			re += new Integer(num[i]).toString();
		}
		if (num.length == 0 || num[0] == 0) {
			return "0";
		} else {
			return re;
		}

	}

	boolean my_cmp(int pre, int next) {
		// return Long.valueOf(new Integer(pre).toString() + new
		// Integer(next).toString()) > Long
		// .valueOf(new Integer(next).toString() + new Integer(pre).toString());
		if (pre == next) {
			return true;
		}
		String no_change = new Integer(pre).toString() + new Integer(next).toString();
		String change = new Integer(next).toString() + new Integer(pre).toString();

		for (int i = 0; i < no_change.length(); i++) {
			if (no_change.charAt(i) != change.charAt(i)) {
				if (no_change.charAt(i) > change.charAt(i)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;

	}
}

// 加油站
class Solution_3 {
	/**
	 * @param gas:
	 *            an array of integers
	 * @param cost:
	 *            an array of integers
	 * @return: an integer
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int all_get = 0;
		int start_sum = 0;
		for (int i = 0; i < gas.length; i++) {
			all_get += gas[i] - cost[i];
			start_sum += gas[i] - cost[i];
			if (start_sum < 0) {
				start = (i + 1) % gas.length;
				start_sum = 0;
			}
		}

		return all_get >= 0 ? start : -1;
	}
}

// 主元素
class Solution_2 {
	/**
	 * @param nums:
	 *            a list of integers
	 * @return: find a majority number
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return -1;
		}
		int num = nums.get(0), count = 1;
		for (int i = 1; i < nums.size(); i++) {
			if (count == 0) {
				num = nums.get(i);
				count++;
				continue;
			}
			if (nums.get(i) == num) {
				count++;
			} else {
				count--;
			}
		}

		return num;
	}
}

// 落单的数
class Solution_1 {
	/**
	 * @param A
	 *            : an integer array return : a integer
	 */
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for (int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}
}