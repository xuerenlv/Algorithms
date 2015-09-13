package com.interview;

public class Space_Replace_212 {

	public static void main(String[] args) {

	}

}

class Solution_Space_Replace_212 {
	/**
	 * @param string:
	 *            An array of Char
	 * @param length:
	 *            The true length of the string
	 * @return: The true length of new string
	 */
	public int replaceBlank(char[] string, int length) {
		int count_blank = 0;
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ')
				count_blank++;
		}
		if (count_blank == 0) {
			return length;
		} else {
			int new_length = count_blank * 2 + length;

			int index_s = length - 1;
			int index_n = new_length - 1;
			while (index_s >= 0) {
				if (string[index_s] == ' ') {
					string[index_n] = '0';
					string[index_n - 1] = '2';
					string[index_n - 2] = '%';
					index_s--;
					index_n -= 3;
				} else {
					string[index_n] = string[index_s];
					index_n--;
					index_s--;
				}
			}
			return new_length;
		}
	}
}