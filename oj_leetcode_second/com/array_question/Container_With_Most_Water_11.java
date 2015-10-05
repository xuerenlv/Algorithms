package com.array_question;

public class Container_With_Most_Water_11 {

	public static void main(String[] args) {

	}

}

class Solution_Container_With_Most_Water_11 {
	// two pointers
	public int maxArea_accepted(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int get = 0;
		while (i < j) {
			int souyi = (j - i) * Math.min(height[i], height[j]);
			get = Math.max(get, souyi);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return get;
	}
	// /*
	// * 这种虽然加了备忘，还是超时
	// * 题目理解错了，当成动态规划了
	// */
	// public int maxArea_overtime(int[] height) {
	// HashMap<Integer, Integer> mapping_r = new HashMap<Integer, Integer>();
	// return max_naive(height, 0, height.length - 1, mapping_r);
	// }
	//
	// int max_naive(int[] height, int start, int end, HashMap<Integer, Integer>
	// r) {
	// if (start + 1 == end)
	// return (end-start)*Math.min(start, end);
	// if (r.containsKey(start + end))
	// return r.get(start + end);
	// int get = 0;
	// for (int k = start + 1; k < end; k++) {
	// get = Math.max(get, max_naive(height, start, k, r) + max_naive(height, k,
	// end, r));
	// }
	// r.put(start + end, get);
	// return get;
	// }
	//
	// public int maxArea(int[] height) {
	// HashMap<Integer, Integer> mapping_r = new HashMap<Integer, Integer>();
	// while (true) {
	// int get = 0;
	// for (int i = 1; i < height.length; i++) {
	// get = Math.max(get, );
	// }
	// }
	// }
}