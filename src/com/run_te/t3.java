package com.run_te;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t3 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<10;i++){
			map.put(new Integer(i)+"_str", i);
		}
		for(String key : map.keySet()){
			map.put("xhj", 2);
		}
		System.out.println(map.get("xhj"));
	}

}
