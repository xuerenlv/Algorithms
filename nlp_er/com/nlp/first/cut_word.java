package com.nlp.first;

import java.util.List;

public class cut_word {
	private static List<String> dictionary;
	private static int max_words = 4;

	public static void initDictionary() {

	}

	public static void ReverseMaxSegmentation(String input) {
		if (dictionary.isEmpty()) {
			initDictionary();
		}

		StringBuffer result = new StringBuffer();
		while (input.length() > 0) {
			String temp;
			// temp就是待分词的短语
			if (input.length() < max_words) {
				temp = input;
			} else {
				temp = input.substring(input.length() - max_words);
			}

			while (temp.length() > 0) {
				if (dictionary.contains(temp) || temp.length() == 1) {
					// 如果在字典中找到某个词，这个词被加入到分词结果中同时从原始输入中删除这个词
					result = new StringBuffer(temp).append("/").append(result);
					input = input.substring(0, input.length() - temp.length());
					break;
				} else {
					// 待分词短语从左向右不断变短
					temp = temp.substring(1);
				}
			}
		}
		System.out.println(result);
	}

	public static void ForwardMaxSegmentation(String input) {
		if (dictionary.isEmpty()) {
			initDictionary();
		}

		StringBuffer result = new StringBuffer();

		while (input.length() > 0) {
			String temp;
			if (input.length() < max_words) {
				temp = input;
			} else {
				temp = input.substring(0, max_words);
			}
			while (temp.length() > 0) {
				if (dictionary.contains(temp) || temp.length() == 1) {
					result = result.append(temp).append("/");
					input = input.substring(temp.length());
					break;
				} else {
					temp = temp.substring(0, temp.length() - 1);
				}
			}
		}
		System.out.println(result);
	}
}
