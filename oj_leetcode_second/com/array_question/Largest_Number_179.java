package com.array_question;

public class Largest_Number_179 {

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		// int[] nums = { 20, 1 };
		System.out.println(new Solution_Largest_Number_179().largestNumber(nums));
	}

}

class Solution_Largest_Number_179 {

	// 排序中的比较
	public String largestNumber(int[] nums) {
		int i, j, len = nums.length, swap;
		// 这里使用的是经过优化的冒泡排序
		boolean swap_ornot = false;
		for (i = 0; i < len - 1; i++) {
			swap_ornot = false;
			for (j = len - 1; j > i; j--) {
				// 通过自定义的比较函数，进行排序
				if (!is_large(nums[j - 1], nums[j])) {
					swap = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = swap;
					swap_ornot = true;
				}
			}
			if (!swap_ornot)
				continue;
		}

		String re = "";
		for (i = 0; i < len; i++) {
			re = re + nums[i];
		}
		if (re.charAt(0) == '0')
			return "0";

		return re;
	}

	boolean is_large(int left, int right) {
		String l = new Integer(left).toString() + new Integer(right).toString();
		String r = new Integer(right).toString() + new Integer(left).toString();
		for (int i = 0; i < l.length(); i++) {
			if (r.charAt(i) > l.charAt(i)) {
				return false;
			}
			if (r.charAt(i) < l.charAt(i)) {
				return true;
			}
		}
		return true;
	}

	// 惨，写的是错的
	public String largestNumber_wrong(int[] nums) {
		int i, j, len = nums.length, swap;
		int de = 1;
		boolean go_on = false;
		boolean swap_ornot = false;
		while (true) {
			go_on = false;
			for (i = 0; i < len - 1; i++) {
				swap_ornot = false;
				for (j = len - 1; j > i; j--) {
					int i1 = nums[j] / de;
					int i2 = nums[j - 1] / de;
					if (i1 != 0 || i2 != 0)
						go_on = true;
					if ((i1 == 0 ? nums[j] : i1) % 10 > (i2 == 0 ? nums[j - 1] : i2) % 10) {
						swap = nums[j];
						nums[j] = nums[j - 1];
						nums[j - 1] = swap;
						swap_ornot = true;
					}
				}
				if (!swap_ornot)
					continue;
			}

			if (!go_on)
				break;
			de *= 10;
		}

		String re = "";
		for (i = 0; i < len; i++) {
			re = re + nums[i];
		}
		return re;
	}
}