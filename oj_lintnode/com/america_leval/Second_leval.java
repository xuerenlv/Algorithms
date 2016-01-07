package com.america_leval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Second_leval {

	public static void main(String[] args) {

		// int[] nums = { -3, 1, 2, -3, 4 };
		// ArrayList<Integer> re = new
		// Solution_second_leval_2().subarraySum(nums);
		// System.out.println(re.toString());

		// int[] nums = { 2, 1 };
		// System.out.println(new
		// Solution_second_leval_6().firstMissingPositive(nums));

		int[] nums = { -14, -14, -14, -14 };
		int index = new Solution_second_leval_11().removeDuplicates(nums);
		for (int i = 0; i < index; i++) {
			System.out.print(nums[i] + "    ");
		}
	}

}

// 最接近零的子数组和
class Solution_second_leval_13 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */

	// 跑过了15个测试案例，最后超时
	// Time Limit Exceeded
	public ArrayList<Integer> subarraySumClosest(int[] nums) {
		Map<Integer, Integer> index_sum = new HashMap<>();
		int sum = 0;
		index_sum.put(-1, 0);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			index_sum.put(i, sum);
		}

		long gap = Long.MAX_VALUE;
		Stack<Integer> re_stack = new Stack<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum_in = index_sum.get(j) - index_sum.get(i - 1);
				if (Math.abs(sum_in) < gap) {
					gap = Math.abs(sum_in);
					re_stack.push(i);
					re_stack.push(j);
				}
			}
		}

		ArrayList<Integer> re = new ArrayList<>();
		int j = re_stack.pop();
		int i = re_stack.pop();
		re.add(i);
		re.add(j);
		return re;
	}
}

// 合并排序数组
class Solution_second_leval_12 {
	/**
	 * @param A
	 *            and B: sorted integer array A and B.
	 * @return: A new sorted integer array
	 */
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> re = new ArrayList<>();
		int index_a = 0;
		int index_b = 0;
		while (index_a < A.size() && index_b < B.size()) {
			if (A.get(index_a) < B.get(index_b)) {
				re.add(A.get(index_a++));
			} else {
				re.add(B.get(index_b++));
			}
		}
		while (index_a < A.size()) {
			re.add(A.get(index_a++));
		}
		while (index_b < B.size()) {
			re.add(B.get(index_b++));
		}
		return re;
	}
}

// 删除排序数组中的重复数字 II
class Solution_second_leval_11 {
	/**
	 * @param A:
	 *            a array of integers
	 * @return : return an integer
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;

		int index = 1;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[index] || nums[i] != nums[index - 1]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}
}

// 数组划分
class Solution_second_leval_10 {
	/**
	 * @param nums:
	 *            The integer array you should partition
	 * @param k:
	 *            As description return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				if (index != i) {
					int temp = nums[index];
					nums[index] = nums[i];
					nums[i] = temp;
				}
				index++;
			}
		}
		return index;
	}
}

// 两数之和
class Solution_second_leval_9 {
	/*
	 * @param numbers : An array of Integer
	 * 
	 * @param target : target = numbers[index1] + numbers[index2]
	 * 
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> maping = new HashMap<Integer, Integer>();

		int[] re = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (maping.containsKey(target - nums[i])) {
				re[0] = maping.get(target - nums[i]);
				re[1] = i + 1;
				break;
			} else {
				maping.put(nums[i], i + 1);
			}
		}

		return re;
	}

	// 不能使用排序，因为返回的是位置
	public int[] twoSum_wrong(int[] numbers, int target) {
		int[] re = new int[2];
		if (numbers.length < 2)
			return re;
		Arrays.sort(numbers);
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				re[0] = numbers[start];
				re[1] = numbers[end];
				return re;
			}
			if (numbers[start] + numbers[end] < target) {
				start++;
			} else {
				end--;
			}
		}
		return re;
	}
}

// 三数之和 II
class Solution_second_leval_8 {
	/**
	 * @param numbers:
	 *            Give an array numbers of n integer
	 * @param target
	 *            : An integer
	 * @return : return the sum of the three integers, the sum closest target.
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		int index = 0;
		int min_closet_target = Integer.MAX_VALUE / 2;
		while (index < len) {
			if (min_closet_target != Integer.MAX_VALUE && index > 0 && nums[index] == nums[index - 1]) {
				index++;
				continue;
			}
			int front = index + 1;
			int tail = len - 1;
			while (front < tail) {
				int sum = nums[front] + nums[tail] + nums[index];

				if (sum == target) {
					return target;
				} else if (nums[front] + nums[tail] + nums[index] < target) {
					int gap = target - (nums[front] + nums[tail] + nums[index]);
					if (Math.abs(target - min_closet_target) > gap)
						min_closet_target = target - gap;
					++front;
				} else {
					int gap = nums[front] + nums[tail] + nums[index] - target;
					if (Math.abs(target - min_closet_target) > gap)
						min_closet_target = target + gap;
					tail--;
				}
			}
			index++;
		}

		return min_closet_target;
	}
}

// 三数之和
class Solution_second_leval_7 {
	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of
	 *         zero.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (numbers.length <= 2)
			return result;
		Arrays.sort(numbers);

		int index = 0;
		while (index < numbers.length - 2 && numbers[index] <= 0) {
			if (index > 0 && numbers[index] == numbers[index - 1]) {
				index++;
				continue;
			}
			int front = index + 1;
			int tail = numbers.length - 1;
			while (front < tail) {
				if (numbers[front] + numbers[tail] == numbers[index] * (-1)) {
					// 判断是否重复
					if (!(result.size() != 0 && result.get(result.size() - 1).get(0) == numbers[index]
							&& result.get(result.size() - 1).get(1) == numbers[front]
							&& result.get(result.size() - 1).get(2) == numbers[tail])) {
						ArrayList<Integer> item = new ArrayList<Integer>();
						item.add(numbers[index]);
						item.add(numbers[front]);
						item.add(numbers[tail]);
						result.add(item);
					}
					front++;
					tail--;
				} else if (numbers[front] + numbers[tail] < numbers[index] * (-1)) {
					front++;
				} else {
					tail--;
				}
			}
			index++;
		}
		return result;
	}

}

// 丢失的第一个正整数
class Solution_second_leval_6 {
	/**
	 * @param A:
	 *            an array of integers
	 * @return: an integer
	 */
	public int firstMissingPositive(int[] A) {
		int n = A.length;
		int i = 0;
		while (i < n) {
			if (A[i] == i + 1) {
				i++;
			} else {
				if (A[i] >= 1 && A[i] <= n && A[A[i] - 1] != A[i]) {
					int temp = A[i];
					A[i] = A[temp - 1];
					A[temp - 1] = temp;
				} else {
					i++;
				}
			}
		}

		for (i = 0; i < n; i++)
			if (A[i] != i + 1)
				return i + 1;
		return n + 1;
	}
}

// 数组剔除元素后的乘积
class Solution_second_leval_5 {
	/**
	 * @param A:
	 *            Given an integers array A
	 * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... *
	 *          A[n-1]
	 */
	public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
		ArrayList<Long> re = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			long mut_1 = 1;
			for (int j = 0; j < i; j++) {
				mut_1 *= A.get(j);
			}
			long mut_2 = 1;
			for (int k = i + 1; k < A.size(); k++) {
				mut_2 *= A.get(k);
			}
			re.add(mut_1 * mut_2);
		}
		return re;
	}
}

// 合并排序数组 II
class Solution_second_leval_4 {
	/**
	 * @param A:
	 *            sorted integer array A which has m elements, but size of A is
	 *            m+n
	 * @param B:
	 *            sorted integer array B which has n elements
	 * @return: void
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		int index = m + n - 1;
		m = m - 1;
		n = n - 1;
		while (m >= 0 && n >= 0) {
			if (A[m] > B[n]) {
				A[index--] = A[m--];
			} else {
				A[index--] = B[n--];
			}
		}

		while (m >= 0)
			A[index--] = A[m--];
		while (n >= 0)
			A[index--] = B[n--];
	}
}

// 删除排序数组中的重复数字
class Solution_second_leval_3 {
	/**
	 * @param A:
	 *            a array of integers
	 * @return : return an integer
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				index++;
				if (nums[i] != nums[index]) {
					nums[index] = nums[i];
				}
			}
		}
		return index + 1;
	}
}

// 子数组之和
class Solution_second_leval_2 {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 * 
	 * 
	 *          i < j; sum[i] = a[0] + ...+ a[i]; sum[j] = a[0] + ...+ a[j];
	 * 
	 *          如果sum[i]和sum[j]相等，则a[i + 1] + ... + a[j] = 0;
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> re = new ArrayList<>();
		if (nums.length == 0)
			return re;

		Map<Integer, Integer> sum_index = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				re.add(i);
				re.add(i);
				return re;
			}
			sum += nums[i];
			if (sum == 0) {
				re.add(0);
				re.add(i);
				return re;
			}
			if (!sum_index.containsKey(sum)) {
				sum_index.put(sum, i);
			} else {
				re.add(sum_index.get(sum) + 1);
				re.add(i);
				return re;
			}
		}
		return re;
	}

	// 超时
	public ArrayList<Integer> subarraySum_overtime(int[] nums) {
		ArrayList<Integer> re = new ArrayList<>();
		if (nums.length == 0)
			return re;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				if (sum == 0) {
					re.add(i);
					re.add(j);
					return re;
				}
			}
		}
		return re;
	}
}

// 删除元素
class Solution_second_leval_1 {
	/**
	 * @param A:
	 *            A list of integers
	 * @param elem:
	 *            An integer
	 * @return: The new length after remove
	 */
	public int removeElement(int[] A, int elem) {
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				if (i != index) {
					A[index] = A[i];
				}
				index++;
			}
		}
		return index;
	}
}