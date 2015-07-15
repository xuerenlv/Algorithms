package com.run_te;

import java.util.Arrays;


public class justforrun {

	public static void main(String[] args) {

//		String s = "xhj";
//		s = s.substring(0, s.length() - 1);
//		System.out.println(s);

		// List<Integer> li = new ArrayList<>();
		//
		// li.add(12);
		// li.add(3);
		// li.add(5);
		//
		// for(int i=0;i<li.size();i++){
		// System.out.print(li.get(i)+" **** ");
		// }
		//
		// Collections.sort(li, new Comparator<Integer>() {
		// @Override
		// public int compare(Integer o1, Integer o2) {
		// return o1-o2;
		// }
		//
		// });
		//
		// System.out.println();
		// for(int i=0;i<li.size();i++){
		// System.out.print(li.get(i)+" **** ");
		// }
		int[] a=new int[2];
		it(a);
		System.out.println(Arrays.toString(a));
	}
	static void it(int[] arr){
		arr[0]=10;
		arr[1]=10;
	}

}
