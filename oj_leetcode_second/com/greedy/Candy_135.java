package com.greedy;

public class Candy_135 {

	public static void main(String[] args) {
		int[] ra = { 1, 3, 4, 3, 2, 1 };

		System.out.println(new Solution_Candy_135().candy(ra));
	}

}

class Solution_Candy_135 {
	// 贪心策略
	public int candy_others(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		if (ratings.length == 1)
			return 1;

		int len = ratings.length;
		int sum = 1; // total candies
		int prev = 1; // the number of candies allocated to the previous child
		for (int i = 1; i < len; i++) {
			if (ratings[i] < ratings[i - 1]) {
				int count = 1;
				while (ratings[i] < ratings[i - 1]) {
					count++;
					i++;
					if (i >= len)
						break;
				} // if rating is descending, count the numbers.
				sum += count > prev ? (1 + count) * count / 2 - prev : (1 + count) * count / 2 - count;
				prev = 1; // The last child get 1 candy to make the number
							// minimum.
				i--; // since while loop take i to the next non-decreasing
						// sequence, fix i.
			} else if (ratings[i] == ratings[i - 1]) {
				sum += 1;
				prev = 1; // if equals, we give the child 1 candy, since it
							// doesn't violate the rule.
			} else if (ratings[i] > ratings[i - 1]) {
				sum += ++prev; // increasing, give ++temp candies to the child.
			}
		}
		return sum;
	}

	// wrong
	public int candy(int[] ratings) {
		if (ratings.length == 0)
			return 0;

		int sum = 1;
		int current_give = 1;
		int equal = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				current_give++;
				sum += current_give;
			}
			if (ratings[i] == ratings[i - 1]) {
				equal = i;
				if (current_give != 1) {
					current_give = 1;
					sum += current_give;
				} else {
					sum += current_give;
				}
			}
			if (ratings[i] < ratings[i - 1]) {
				if (current_give != 1) {
					current_give = 1;
					sum += current_give;
				} else {
					sum = sum + (i - equal) + 1;
				}
			}
		}

		return sum;
	}
}