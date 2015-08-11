package com.nlp.thread;

public class runable_out_t implements Runnable {
	private static int count = 0;
	private final int id = count++;
	
	@Override
	public void run() {
		while (true) {
			synchronized (contain.contain_string) {
				if (contain.contain_string.size() < 10) {
					String str = "out: "+"  "+id+"  " + System.currentTimeMillis();
					contain.contain_string.add(str);
					System.out.println(str);
				}
			}
			Thread.yield();
		}
	}

}
