package com.dynamic_programing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Ladder_II_126 {

	public static void main(String[] args) {

	}

}

class Solution_Word_Ladder_II_126 {
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> current = new ArrayList<List<String>>(); // swap between "current" / "next"
        List<List<String>> next;
        if (start == null || end == null) return current;

        dict.remove(start); // remove start if dict contains
        dict.add(end);      // add end to dict
        List<String> list = new ArrayList<String>(); //  first list only contains start
        list.add(start);
        current.add(list);
        Set<String> curLevelVisited = new HashSet<String>();

        while (!current.isEmpty()) {
            next = new ArrayList<List<String>>(); // create a new List<List<String>>
            while (!current.isEmpty()) {
                for(int i=0; i<current.size(); i++) { // iterate "current"
                    List<String> curList = current.remove(i); //  get & remove one List<String> from "current"
                    String curStr = curList.get(curList.size()-1); // get last string of curList
                    char[] curArr = curStr.toCharArray(); // conver to char[]
                    //------------------------------------------------------------------
                    if (curStr.equals(end)) { // we find one List<String> in "current" is a result, so all the other results should in "current" as well
                        current.add(curList); // add curList back to "current" as we remove it above
                        List<List<String>> result = new ArrayList<List<String>>(); // this is the final result
                        for(int j=0; j<current.size(); j++) {
                            List<String> tmp = current.get(j);
                            String lastStr = tmp.get(tmp.size()-1);
                            if (lastStr.equals(end)) result.add(tmp);
                        }
                        return result;
                    }
                    //-------------------------------------------------------------------
                    for(int k=0; k<curArr.length; k++) {
                        for(char r='a'; r<='z'; r++) {
                            char old = curArr[k]; // keep old character
                            curArr[k] = r; // replacing with the new one from 'a' to 'z'
                            String test = String.valueOf(curArr);
                            if (dict.contains(test)) {
                                List<String> newList = new ArrayList<String>(curList);
                                newList.add(test);
                                next.add(newList); // add new constructed List<String> to "next"
                                curLevelVisited.add(test); // keep track of newly founded String
                            }
                            curArr[k] = old;
                        }
                    }
                }
            }
            dict.removeAll(curLevelVisited); //before "current" and "next" switch, we need to delete all String stored in curLevelVisited to avoid circle
            curLevelVisited.clear();
            current = next;
        }
        return current;
    }
	
	public List<List<String>> findLadders_overtime(String start, String end, Set<String> dict) {
		List<List<String>> re = new ArrayList<>();
		List<String> in = new ArrayList<>();
		tran(start, end, dict, re, in);
		return re;
	}

	void tran(String start, String end, Set<String> dict, List<List<String>> re, List<String> in) {
		if (dict.size() == 0)
			return;
		if (does_one(start, end)) {
			re.add(new ArrayList<>(in));
			return;
		}

		for (int i = 0; i < start.length(); i++) {
			char ch = start.charAt(i);
			for (int j = 0; j < 26; j++) {
				char new_char = (char) (j + 'a');
				if (new_char != ch) {
					String new_begin_word = start.substring(0, i) + new_char + start.substring(i + 1);
					if (dict.contains(new_begin_word)) {
						dict.remove(new_begin_word);
						in.add(new_begin_word);
						tran(start, end, dict, re, in);
						in.remove(new_begin_word);
						dict.add(new_begin_word);
					}
				}
			}
		}

	}

	// 判断start是否与end有一个字符的差别
	boolean does_one(String start, String end) {
		int count = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == end.charAt(i)) {
				count++;
			}
		}
		return count == (start.length() - 1);
	}
}