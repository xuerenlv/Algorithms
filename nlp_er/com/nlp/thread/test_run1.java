package com.nlp.thread;

public class test_run1 {

	public static void main(String[] args) {
		Thread thread_1 = new Thread(new LiftOff());
		Thread thread_2 = new Thread(new LiftOff());
		Thread thread_3 = new Thread(new LiftOff());
		Thread thread_4 = new Thread(new LiftOff());
		Thread thread_5 = new Thread(new LiftOff());
		
		thread_1.start();
		thread_2.start();
		thread_3.start();
		thread_4.start();
		thread_5.start();
	}

}

class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"lift off!")+").";
	}
	
	@Override
	public void run() {
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
	}

}