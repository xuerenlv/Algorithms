package com.string_manu;

public class Reverse_Words_in_a_String_151 {

	public static void main(String[] args) {
		String str = "hi!";

		System.out.println(new Solution_Reverse_Words_in_a_String_151().reverseWords_accepted_1(str));
		System.out.println(new Solution_Reverse_Words_in_a_String_151().reverseWords_accepted_2(str));
	}
}

class Solution_Reverse_Words_in_a_String_151 {

	public String reverseWords_bralliant(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		int end = words.length - 1;
		for (int i = 0; i <= end; i++) {
			if (!words[i].isEmpty()) {
				sb.insert(0, words[i]);
				if (i < end)
					sb.insert(0, " ");
			}
		}
		return sb.toString();
	}
	// **********************************************************************************

	// 这个比较好，在O(n)的情况下逆转
	public String reverseWords_accepted_1(String s) {
		String rs = "";
		for (int i = s.length() - 1; i >= 0;) {
			if (i < 0)
				break;
			while (s.charAt(i) == ' ')
				i--;

			if (!rs.isEmpty())
				rs += " ";

			String t = "";
			while (i >= 0 && s.charAt(i) != ' ')
				t += s.charAt(i--);
			t = reverseWords_i_to_j(t, 0, t.length() - 1);
			rs = rs + t;
		}
		return rs;
	}

	// 这种思想较为常用
	public String reverseWords_accepted_2(String s) {
		char[] str = s.trim().toCharArray();
		char[] str_repair = new char[str.length];
		int k = 0, l = 0;
		while (l < str.length) {
			if (str[l] != ' ' || (str[l] == ' ' && str[l - 1] != ' ')) {
				str_repair[k++] = str[l++];
			} else {
				l++;
			}
		}
		str = new String(str_repair).trim().toCharArray();
		// 先整体逆转
		reverseWords_i_to_j(str, 0, str.length - 1);

		int i = 0, j = 0;
		while (j < str.length) {
			if (str[j] == ' ' && j > i) {
				reverseWords_i_to_j(str, i, j - 1);
				i = j + 1;
			}
			if (j == str.length - 1 && j > i) {
				reverseWords_i_to_j(str, i, j);
				break;
			}
			j++;
		}

		return new String(str);
	}

	// 对数组进行逆转
	public void reverseWords_i_to_j(char[] str, int i, int j) {
		char swap;
		while (i < j) {
			swap = str[i];
			str[i] = str[j];
			str[j] = swap;

			i++;
			j--;
		}
	}

	// 对字符串进行逆转
	public String reverseWords_i_to_j(String s, int i, int j) {
		char[] str = s.toCharArray();
		char swap;
		while (i < j) {
			swap = str[i];
			str[i] = str[j];
			str[j] = swap;

			i++;
			j--;
		}
		return new String(str);
	}
}