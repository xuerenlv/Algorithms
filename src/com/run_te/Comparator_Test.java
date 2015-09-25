package com.run_te;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Comparator_Test {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		
		Random random = new Random();
		for(int i=0;i<10;i++){
			li.add(Math.abs(random.nextInt())%100);
		}
		System.out.println(li.toString());
		
		Collections.sort(li,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		System.out.println(li.toString());
	}

}
