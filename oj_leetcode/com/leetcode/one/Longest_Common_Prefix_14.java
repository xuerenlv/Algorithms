package com.leetcode.one;

public class Longest_Common_Prefix_14 {

	public static void main(String[] args) {
		String[] strs={"aa","aab"};
		System.out.println(new Solution_Longest_Common_Prefix_14().longestCommonPrefix_accepted(strs) );
	}

}

class Solution_Longest_Common_Prefix_14 {
	public String longestCommonPrefix_accepted(String[] strs) {
		if(strs.length==0)
			return "";
		String re="";
		int i=0;
		while(true){
			if(i>=strs[0].length()) break;
			char ch=strs[0].charAt(i);
			
//			System.out.println(ch);
			
			int index;
			for(index=0;index < strs.length;index++){
				if(i >= strs[index].length() || strs[index].charAt(i) !=ch){
					break;
				}
			}
			
			
			if(index == strs.length){
				i++;
				re+=ch;
			}else{
				break;
			}
		}
		
		return re;
	}
}