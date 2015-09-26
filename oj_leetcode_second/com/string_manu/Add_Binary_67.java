package com.string_manu;

public class Add_Binary_67 {

	public static void main(String[] args) {

		System.out.println(new Solution_Add_Binary_67().addBinary_accepted("100", "11"));
		System.out.println(new Solution_Add_Binary_67().addBinary_accepted("11", "1"));
	}

}

class Solution_Add_Binary_67 {
	public String addBinary_accepted(String a, String b) {
		if (a.length() == 0 && b.length() == 0)
			return "";
		if (a.length() == 0)
			return b;
		if (b.length() == 0)
			return a;

		String re = "";

		int i = a.length() - 1;
		int j = b.length() - 1;
		int jinwei = 0;
		int f, s;
		while (i >= 0 && j >= 0) {
			f = (a.charAt(i) - '0');
			s = (b.charAt(j) - '0');
			re = (char) ((f + s + jinwei) % 2 + '0') + re;
			jinwei = (f + s + jinwei) / 2;
			i--;
			j--;
		}

		while (i >= 0) {
			f = (a.charAt(i) - '0');
			re = (char) ((f + jinwei) % 2 + '0') + re;
			jinwei = (f + jinwei) / 2;
			i--;
		}

		while (j >= 0) {
			s = (b.charAt(j) - '0');
			re = (char) ((s + jinwei) % 2 + '0') + re;
			jinwei = (s + jinwei) / 2;
			j--;
		}

		if (jinwei == 0) {
			return re;
		} else {
			return '1' + re;
		}
	}
}