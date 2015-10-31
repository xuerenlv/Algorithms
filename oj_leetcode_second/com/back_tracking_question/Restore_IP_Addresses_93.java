package com.back_tracking_question;

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
	// 很直观的解法，而且时间复杂度也挺低
	public List<String> restoreIpAddresses_other(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		// 直接穷举所有可能的分段，而且每一个分段有其自身的限制
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k),
							s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
			return false;
		return true;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	public List<String> restoreIpAddresses(String s) {
		List<String> re = new ArrayList<>();
		if (s.length() > 12)
			return re;
		String houxuan = ""; // 每一段的候选
		int partion = 4; // 总共分4段
		tranverse_str(s, 0, s.length(), partion, houxuan, re);
		return re;
	}

	void tranverse_str(String s, int start, int end, int part, String houxuan, List<String> re) {
		if (start == end) { // 当start ＝＝ end 的时候必须退出
			if (part == 0) // 但只有4段全完成的时候，才是一个正常的划分
				re.add(houxuan);
			return;
		}

		if (s.charAt(start) == '0') {// 在一段中，若是开头出现0，则全段均为0
			String add_str = "";
			if (part == 4) {// 第一段
				add_str = "0";
			} else {
				add_str = "." + "0";
			}
			houxuan += add_str;
			tranverse_str(s, start + 1, end, part - 1, houxuan, re);
			return;
		}
		for (int i = 1; i <= 3; i++) {// 每一段的长度最大为3
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