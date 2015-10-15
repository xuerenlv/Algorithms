package com.array_question;

public class Count_and_Say_38 {

	public static void main(String[] args) {
		System.out.println(new Solution_Count_and_Say_38().countAndSay(25));
		System.out.println(new Solution_renjia().countAndSay(25));
	}

}

class Solution_Count_and_Say_38 {
	public String countAndSay(int n) {
		String re = "1";
		String re_two;

		char[] re_arr;
		for (int i = 1; i < n; i++) {
			re_two = "";
			re_arr = re.toCharArray();
			int num = 1;
			char temp = re_arr[0];
			for (int j = 1; j < re.length(); j++) {
				if (re_arr[j] == temp) {
					num++;
					continue;
				}
				re_two += Integer.toString(num) + temp;
				temp = re_arr[j];
				num = 1;
			}
			re_two += Integer.toString(num) + temp;
			re = re_two.toString();
		}

		return re;
	}
}

class Solution_renjia {
	String countAndSayForOneString(String input) {
		char tmp = input.charAt(0);
		int num = 1;
		StringBuffer newString = new StringBuffer("");
		for (int k = 1; k < input.length(); k++) {
			if (input.charAt(k) == tmp) {
				num++;
				continue;
			}
			newString.append(Integer.toString(num) + tmp);
			tmp = input.charAt(k);
			num = 1;
		}
		newString.append(Integer.toString(num) + tmp);
		return newString.toString();
	}

	public String countAndSay(int n) {
		String result = "1";
		int i = 1;
		while (i < n) {
			result = countAndSayForOneString(result);
			i++;
		}
		return result;
	}
}