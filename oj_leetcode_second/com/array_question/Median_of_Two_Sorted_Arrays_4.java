package com.array_question;

public class Median_of_Two_Sorted_Arrays_4 {

	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = { 1 };
		System.out.println(new Solution_Median_of_Two_Sorted_Arrays_4().findMedianSortedArrays(nums1, nums2));
	}

}

class Solution_Median_of_Two_Sorted_Arrays_4 {
	// ************************************************************************
	// 在两个已排序的数组中，寻找第k小的元素
	double findKth(int A[], int m, int B[], int n, int k) {
		if (m > n)
			return findKth(B, n, A, m, k);
		if (m == 0)
			return B[k - 1];
		if (k <= 1)
			return Math.min(A[0], B[0]);

		int pa = Math.min(k / 2, m), pb = k - pa;
		if (A[pa - 1] < B[pb - 1]) {
			int[] A_new = new int[m - pa];
			System.arraycopy(A, pa, A_new, 0, m - pa);
			return findKth(A_new, m - pa, B, n, k - pa);
		} else if (A[pa - 1] > B[pb - 1]) {
			int[] B_new = new int[n - pb];
			System.arraycopy(B, pb, B_new, 0, n - pb);
			return findKth(A, m, B_new, n - pb, k - pb);
		} else
			return A[pa - 1];
	}

	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int k = m + n;
		if ((k & 1) != 0) {
			return findKth(A, m, B, n, k / 2 + 1);
		} else {
			return (findKth(A, m, B, n, k / 2) + findKth(A, m, B, n, k / 2 + 1)) / 2;
		}
	}

	// *********************************** 使用分治法 **********************
	// 两个已排序数组的中间数
	public double findMedianSortedArrays_divide_conquer(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		return find_med(nums1, 0, len1 - 1, nums2, 0, len2 - 1);
	}

	// 划分子问题，想法是对的
	double find_med(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
		if (end1 < start1 && end2 < start2) {
			return 0;
		} else if (end1 == start1 && end2 == start2) {
			return (double) (nums1[start1] + nums2[start2]) / 2;
		} else if (end1 >= start1 && end2 < start2) {
			return (end1 + start1) % 2 == 0 ? nums1[(end1 + start1) / 2]
					: (double) (nums1[(end1 + start1) / 2] + nums1[(end1 + start1) / 2 + 1]) / 2;
		} else if (end1 < start1 && end2 >= start2) {
			return (end2 + start2) % 2 == 0 ? nums2[(end2 + start2) / 2]
					: (double) (nums2[(end2 + start2) / 2] + nums2[(end2 + start2) / 2 + 1]) / 2;
		} else {
			if (nums1[start1] >= nums2[start2]) {
				if (nums1[end1] <= nums2[end2]) {
					return find_med(nums1, start1, end1, nums2, start2 + 1, end2 - 1);
				} else {
					return find_med(nums1, start1, end1 - 1, nums2, start2 + 1, end2);
				}
			} else {
				if (nums1[end1] <= nums2[end2]) {
					return find_med(nums1, start1 + 1, end1, nums2, start2, end2 - 1);
				} else {
					return find_med(nums1, start1 + 1, end1 - 1, nums2, start2, end2);
				}
			}
		}
	}

}