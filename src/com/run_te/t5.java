package com.run_te;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class t5 {

	public static void main(String[] args) {
		String[] arr = " 2 4 5 6 ".split(" ");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[0].equals(""));
	}

	public static void main_1(String[] args) {
		Map<String, String> iMap = new HashMap<>();
		iMap.put("12", "213");
		iMap.put("12w", "213d");
		iMap.put("1as2", "2f13");
		iMap.put("1wqd2", "21d3");
		Set<String> iSet = iMap.keySet();

		String[] srr = new String[iSet.size()];
		iSet.toArray(srr);
		System.out.println(Arrays.toString(srr));
	}

}
