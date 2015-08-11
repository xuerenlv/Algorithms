package com.nlp.thread;

public class runable_in_t implements Runnable {
	private static int count = 0;
	private final int id = count++;

	@Override
	public void run() {
		while (true) {
			synchronized (contain.contain_string) {
				if (contain.contain_string.size() != 0) {
					String str = contain.contain_string.get(contain.contain_string.size() - 1);
					System.out.println("in: " + id + "---" + str);
					contain.contain_string.remove(str);
				}
			}
			Thread.yield();
		}
	}

}
