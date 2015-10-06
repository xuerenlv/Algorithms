package com.back_tracking_question;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

	public static void main(String[] args) {
		List<List<Integer>> re = new Solution_Combinations_77().combine(4, 2);
		for (List<Integer> in : re) {
			System.out.println(in.toString());
		}
	}

}

class Solution_Combinations_77 {
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> in = new ArrayList<>();
		List<List<Integer>> re = new ArrayList<>();

		find(1, n, k, in, re);
		return re;
	}

	void find(int start, int n, int k, List<Integer> in, List<List<Integer>> re) {
		if (k == 0) {
			re.add(new ArrayList<>(in));
			return;
		}
		for (int i = start; i <= n; i++) {
			in.add(i);
			find(i + 1, n, k - 1, in, re);
			in.remove((Integer) i);
		}
	}
}