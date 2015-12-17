package com.java_style;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class read_from_console {

	public static void main(String[] args) throws Exception {
		BufferedReader console_reader = new BufferedReader(new InputStreamReader(System.in));
		String r_line;
		while ((r_line = console_reader.readLine()) != null) {
			System.out.println(r_line + "  " + r_line.length());
		}
	}

}
