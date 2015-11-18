package com.array_question;

import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle_II_119 {

	public static void main(String[] args) {
		List<Integer> in = new Solution_Pascal_s_Triangle_II_119().getRow(5);
		System.out.println(in.toString());
	}

}

class Solution_Pascal_s_Triangle_II_119 {
	// better
	public List<Integer> getRow_2(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 1; i <= rowIndex; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}

	public List<Integer> getRow(int rowIndex) {
		rowIndex++;
		List<Integer> in_a = new ArrayList<Integer>();
		List<Integer> in_b = new ArrayList<Integer>();
		if (rowIndex == 0)
			return in_a;
		in_a.add(1);
		if (rowIndex == 1)
			return in_a;
		for (int i = 2; i <= rowIndex; i++) {
			in_b = new ArrayList<Integer>();
			in_b.add(1);
			for (int j = 0; j < i - 2; j++) {
				in_b.add(in_a.get(j) + in_a.get(j + 1));
			}
			in_b.add(1);
			in_a = in_b;
		}
		return in_a;
	}
}