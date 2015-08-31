package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses_93 {

	public static void main(String[] args) {
		// String s = "25525511135";
		String s = "1111";
		List<String> re = new Solution_Restore_IP_Addresses_93().restoreIpAddresses(s);
		System.out.println(re.toString());
	}

}

class Solution_Restore_IP_Addresses_93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> re = new ArrayList<>();
		String houxuan = "";
		int partion = 4;
		tranverse_str(s, 0, s.length(), partion, houxuan, re);
		return re;
	}

	void tranverse_str(String s, int start, int end, int part, String houxuan, List<String> re) {
		if (part < 0)
			return;
		if (start > end) {
			return;
		}
		if (start == end) {
			if(part==0)
				re.add(houxuan);
			return;
		}

		System.out.println(part);
		if (s.charAt(start) == '0') {
			String add_str = "";
			if (part == 4) {
				add_str = "0";
			} else {
				add_str = "." + "0";
			}
			houxuan += add_str;
			tranverse_str(s, start + 1, end, part - 1, houxuan, re);
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (start + i > s.length())
				return;
			String se = s.substring(start, start + i);
			int se_int = Integer.parseInt(se);
			if (se_int < 256) {
				String add_str = "";
				if (part == 4) {
					add_str = se;
				} else {
					add_str = "." + se;
				}
				houxuan = houxuan + add_str;
				tranverse_str(s, start + i, end, part - 1, houxuan, re);
				houxuan = houxuan.substring(0, houxuan.length() - add_str.length());
			}
		}
	}

}