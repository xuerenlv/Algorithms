package com.string_manu;

public class Compare_Version_Numbers_165 {
	public static void main(String[] args) {

	}

}

class Solution_Compare_Version_Numbers_165 {

	public int compareVersion(String version1, String version2) {
		int val1, val2;
		int index_1 = 0;
		int index_2 = 0;
		// . 可能有多个
		while (index_1 < version1.length() || index_2 < version2.length()) {
			val1 = 0;
			while (index_1 < version1.length()) {
				if (version1.charAt(index_1) == '.') {
					index_1++;
					break;
				}
				val1 = val1 * 10 + (version1.charAt(index_1++) - '0');
			}

			val2 = 0;
			while (index_2 < version2.length()) {
				if (version2.charAt(index_2) == '.') {
					index_2++;
					break;
				}
				val2 = val2 * 10 + (version2.charAt(index_2++) - '0');
			}
			if (val1 > val2)
				return 1;
			if (val1 < val2)
				return -1;
		}
		return 0;
	}

	// 。 号可能有多个
	public int compareVersion_wrong(String version1, String version2) {
		int decimal_1 = version1.indexOf(".");
		int decimal_2 = version2.indexOf(".");

		if (decimal_1 == -1) {
			decimal_1 = version1.length();
		}
		if (decimal_2 == -1) {
			decimal_2 = version2.length();
		}
		int version1_first = Integer.valueOf(version1.substring(0, decimal_1));
		int version2_first = Integer.valueOf(version2.substring(0, decimal_2));
		if (version1_first > version2_first) {
			return 1;
		}
		if (version1_first < version2_first) {
			return -1;
		}

		if (decimal_1 == version1.length() && decimal_2 == version2.length())
			return 0;
		if (decimal_1 == version1.length()) {
			return -1;
		}
		if (decimal_2 == version2.length()) {
			return 1;
		}
		int version1_sec = Integer.valueOf(version1.substring(decimal_1 + 1));
		int version2_sec = Integer.valueOf(version2.substring(decimal_2 + 1));
		if (version1_sec > version2_sec) {
			return 1;
		}
		if (version1_sec < version2_sec) {
			return -1;
		}
		return 0;
	}
}