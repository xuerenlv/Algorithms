package com.array_question;

public class First_Missing_Positive_41 {

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		System.out.println(new Solution_First_Missing_Positive_41().firstMissingPositive(nums));
	}

}

class Solution_First_Missing_Positive_41 {

	// second version
	public int firstMissingPositive_2(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length)
				i++;
			else if (A[A[i] - 1] != A[i])
				swap(A, i, A[i] - 1);
			else
				i++;
		}
		i = 0;
		while (i < A.length && A[i] == i + 1)
			i++;
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// first version
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		int pos = 0;
		while (pos < len) {
			if (nums[pos] > 0 && nums[pos] != pos + 1 && nums[pos] - 1 < len && nums[pos] != nums[nums[pos] - 1]) {
				int temp = nums[pos];
				nums[pos] = nums[temp - 1];
				nums[temp - 1] = temp;
			} else {
				++pos;
			}
		}
		for (int i = 0; i < len; ++i) {
			if (i + 1 != nums[i])
				return i + 1;
		}
		return len + 1;
	}
}