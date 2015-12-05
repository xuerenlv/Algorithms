package com.array_question;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Gap_164 {

	public static void main(String[] args) {

	}

}

class Solution_Maximum_Gap_164 {

	// 桶排序，运用于搜索之中，很有趣
	public int maximumGap(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return 0;

		int max_val = Integer.MIN_VALUE;
		int min_val = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			int val = nums[i];
			if (val > max_val) {
				max_val = val;
			}
			if (val < min_val) {
				min_val = val;
			}
		}

		int agGap = (int) Math.ceil((double) (max_val - min_val) / (len - 1)); // 平均间隔
		int bucketCount = (int) Math.ceil((double) (max_val - min_val) / agGap); // 桶的个数

		// 初始化桶
		List<int[]> buckets = new ArrayList<int[]>();
		for (int i = 0; i < bucketCount; i++) {
			int[] arr = new int[2];
			arr[0] = Integer.MIN_VALUE;
			arr[1] = Integer.MAX_VALUE;
			buckets.add(arr);
		}

		// 每一个元素进桶
		for (int i = 0; i < len; i++) {
			int val = nums[i];
			if (val == max_val || val == min_val)
				continue;
			int bucketNum = (val - min_val) / agGap;
			if (val > buckets.get(bucketNum)[0])
				buckets.get(bucketNum)[0] = val; // 存储最大值
			if (val < buckets.get(bucketNum)[1])
				buckets.get(bucketNum)[1] = val; // 存储最小值
		}

		// 桶间的最大间隔
		int maxGap = 0;
		int lastMax = min_val;
		for (int[] bucket : buckets) {
			if (bucket[0] == Integer.MIN_VALUE)
				continue; // 空桶
			int curMax = bucket[0];
			int curMin = bucket[1];
			maxGap = Math.max(maxGap, curMin - lastMax);
			lastMax = curMax;
		}
		maxGap = Math.max(maxGap, max_val - lastMax);
		return maxGap;
	}
}