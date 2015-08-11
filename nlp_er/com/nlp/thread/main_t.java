package com.nlp.thread;

public class main_t {
	public static void main(String[] a) {
		for (int i = 0; i < 10; i++) {
			new Thread(new runable_in_t()).start();
			new Thread(new runable_out_t()).start();
		}
	}
}
