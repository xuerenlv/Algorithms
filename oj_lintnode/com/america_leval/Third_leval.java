package com.america_leval;

import com.nlp.thread.contain;

public class Third_leval {

	public static void main(String[] args) {
		// System.out.println(new Solution_Third_leval_1().sqrt(10));
		int[] nums = { 6, 1, 2, 3, 4, 5 };
		System.out.println(new Solution_Third_leval_6().findMin(nums));
	}

}

// 寻找峰值
class Solution_Third_leval_Third_leval_8 {
	/**
	 * @param A:
	 *            An integers array.
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
	}
}

// 寻找旋转排序数组中的最小值 II
class Solution_Third_leval_7 {
	/**
	 * @param num:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] num) {
		int l = 0;
		int r = num.length - 1;
		if (num[l] < num[r])
			return num[l];
		int mid = 0;
		while (l < r) {
			mid = (l + r) >> 1;
			if (num[mid] == num[r]) {
				r--;
				continue;
			}
			if (num[mid] > num[r])
				l = mid + 1;
			else
				r = mid;
		}

		return num[l];

	}
}

// 寻找旋转排序数组中的最小值
class Solution_Third_leval_6 {
	/**
	 * @param num:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] num) {
		int l = 0;
		int r = num.length - 1;
		if (num[l] < num[r])
			return num[l];
		int mid = 0;
		while (l < r) {
			mid = (l + r) >> 1;
			if (num[mid] > num[r])
				l = mid + 1;
			else
				r = mid;
		}

		return num[l];
	}
}

// 木材加工
class Solution_Third_leval_5 {
	/**
	 * @param L:
	 *            Given n pieces of wood with length L[i]
	 * @param k:
	 *            An integer return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		if (L.length == 0)
			return 0;
		long sum = 0;
		long len = 0;
		for (long i : L) {
			sum += i;
			if (i > len)
				len = i;
		}
		if (sum < k)
			return 0;

		long l = 1;
		long r = len;
		while (l < r) {
			long mid = (l + r + 1) >> 1;
			if (is_ok(L, k, mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return (int) l;

	}

	boolean is_ok(int[] L, int k, long len) {
		long cn = 0;
		for (long i : L) {
			cn += i / len;
		}
		return cn >= k;
	}
}

// 二分查找
class Solution_Third_leval_4 {
	/**
	 * @param nums:
	 *            The integer array.
	 * @param target:
	 *            Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
	public int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) >> 1;
			if (nums[mid] == target) {
				while (mid > 0 && nums[mid] == nums[mid - 1])
					mid--;
				return mid;
			}
			if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}
}

// 搜索二维矩阵
class Solution_Third_leval_3 {
	/**
	 * @param matrix,
	 *            a list of lists of integers
	 * @param target,
	 *            an integer
	 * @return a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;

		int start = 1;
		int end = m * n;
		int mid, i, j;
		while (start <= end) {
			mid = (start + end) / 2;
			i = (mid - 1) / n;
			j = (mid - 1) % n;
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}

// 搜索插入位置
class Solution_Third_leval_2 {
	/**
	 * param A : an integer sorted array param target : an integer to be
	 * inserted return : an integer
	 */
	public int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >> 1;
			if (A[mid] == target)
				return mid;
			if (A[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		if (mid == 0) {
			return 0;
		} else if (A[mid] > target) {
			return mid;
		} else {
			return mid + 1;
		}
	}
}

// x的平方根
class Solution_Third_leval_1 {
	/**
	 * @param x:
	 *            An integer
	 * @return: The sqrt of x
	 */
	public int sqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int start = 1;
		int end = x;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >> 1;
			System.out.println(mid);
			if (mid == x / mid)
				return mid;
			if (mid > x / mid)
				end = mid - 1;
			else
				start = mid + 1;
		}

		if (mid > x / mid)
			return mid - 1;
		else
			return mid;
	}
}