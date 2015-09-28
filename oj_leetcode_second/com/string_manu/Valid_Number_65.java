package com.string_manu;

import com.nlp.thread.contain;

public class Valid_Number_65 {

	public static void main(String[] args) {
		System.out.println(new Solution_Valid_Number_65().isNumber("-00.300"));
//		System.out.println(new Solution_Valid_Number_65().isNumber("e0"));
//		System.out.println(new Solution_Valid_Number_65().isNumber("0.3"));
//		System.out.println(new Solution_Valid_Number_65().isNumber("abc"));
//		System.out.println(new Solution_Valid_Number_65().isNumber("1 a"));
//		System.out.println(new Solution_Valid_Number_65().isNumber("2e10"));
	}

}

class Solution_Valid_Number_65 {
	public boolean isNumber(String s) {
		s = s.trim();
	    if (s.length() == 0)
	        return false;
	    if (s.matches("[+-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))([eE][+-]?[0-9]+)?"))
	        return true;
	    else
	        return false;
	}
}