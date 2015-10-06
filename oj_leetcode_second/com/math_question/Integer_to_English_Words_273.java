package com.math_question;

public class Integer_to_English_Words_273 {

	public static void main(String[] args) {

		System.out.println(new Solution_Integer_to_English_Words_273().numberToWords(230234254));
	}

}

class Solution_Integer_to_English_Words_273 {
	public String numberToWords(int num) {
		if (num < 0)
			return null;
		else if (num == 0)
			return "Zero";

		int billion = 1000000000;
		int million = 1000000;
		int thousand = 1000;
		String result = "";
		int tempBillion = num / billion;
		if (tempBillion != 0)
			result += getStr(tempBillion) + "Billion ";
		num = num - tempBillion * billion;
		int tempMillion = num / million;
		if (tempMillion != 0)
			result += getStr(tempMillion) + "Million ";
		num = num - tempMillion * million;
		int tempThousand = num / thousand;
		if (tempThousand != 0)
			result += getStr(tempThousand) + "Thousand ";
		num = num - tempThousand * thousand;
		if (num != 0)
			result += getStr(num);

		if (result.charAt(result.length() - 1) == ' ')
			return result.substring(0, result.length() - 1);
		else
			return result;
	}

	private String getStr(int num) {
		if (num <= 0)
			return "";
		String str = "";
		int hundred = num / 100;
		if (hundred != 0) {
			String hundredStr = getDigit(hundred);
			str += hundredStr + "Hundred ";
		}
		num = num - 100 * hundred;
		int ten = num / 10;
		if (ten != 0) {
			if (ten == 1) {// 十几
				str += getTen(num);
				return str;
			} else {// 几十
				str += getMoreTen(ten);
			}
		}
		num = num - 10 * ten;
		if (num != 0)
			str += getDigit(num);
		return str;
	}

	// 1-9
	private String getDigit(int digit) {
		if (digit <= 0)
			return "";
		switch (digit) {
		case 1:
			return "One ";
		case 2:
			return "Two ";
		case 3:
			return "Three ";
		case 4:
			return "Four ";
		case 5:
			return "Five ";
		case 6:
			return "Six ";
		case 7:
			return "Seven ";
		case 8:
			return "Eight ";
		case 9:
			return "Nine ";
		default:
			return "";
		}
	}

	// 10,20,30,,,90
	private String getMoreTen(int ten) {
		if (ten <= 0)
			return "";
		switch (ten) {
		case 1:
			return "Ten ";
		case 2:
			return "Twenty ";
		case 3:
			return "Thirty ";
		case 4:
			return "Forty ";
		case 5:
			return "Fifty ";
		case 6:
			return "Sixty ";
		case 7:
			return "Seventy ";
		case 8:
			return "Eighty ";
		case 9:
			return "Ninety ";
		default:
			return "";
		}
	}

	// 10-19 转换成字符串
	private String getTen(int ten) {
		if (ten <= 0)
			return "";
		switch (ten) {
		case 10:
			return "Ten ";
		case 11:
			return "Eleven ";
		case 12:
			return "Twelve ";
		case 13:
			return "Thirteen ";
		case 14:
			return "Fourteen ";
		case 15:
			return "Fifteen ";
		case 16:
			return "Sixteen ";
		case 17:
			return "Seventeen ";
		case 18:
			return "Eighteen ";
		case 19:
			return "Nineteen ";
		default:
			return "";
		}
	}
}