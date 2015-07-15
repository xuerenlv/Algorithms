package com.leetcode.two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Word_Break_139 {

	public static void main(String[] args) {
		Set<String> wordDict = new  HashSet<String>();
		wordDict.add("xhj");
		wordDict.add("xh");
		
		System.out.println(new Solution_Word_Break_139().wordBreak("xhxhj", wordDict));
	}

}


class Solution_Word_Break_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;
        for (int i = 1; i < len + 1; i++){
            for (int j = 0; j < i; j++){
            	System.out.println(Arrays.toString(f)+"  "+j+"  "+s.substring(j, i)+" "+wordDict.contains(s.substring(j, i)));
                if (f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        System.out.println("final: "+Arrays.toString(f));
        return f[len];
    }
}