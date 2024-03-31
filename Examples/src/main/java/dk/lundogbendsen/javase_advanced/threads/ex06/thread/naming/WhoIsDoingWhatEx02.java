package dk.lundogbendsen.javase_advanced.threads.ex06.thread.naming;

import dk.lundogbendsen.javase_advanced.threads.utils.ThreadUtil;

//NAMING THREAD
//It's annoying that you can't always see who is printing.
//The method ThreadUtil.printThreadNames( ) ensures that all calls to
//System.out.print( ) / println( ) also prints the name of the
//thread making the call to print( ) or println( ).

public class WhoIsDoingWhatEx02 {
	public static void main(final String[] args) {
		ThreadUtil.printThreadNames();

		System.out.println("We are in line approx. 25 in the Threads04.main( )-method.");
		System.out.println("Let us see which thread is running these lines...");
		System.out.println(Thread.currentThread().getName());

		MyThread2 thread = new MyThread2();
		thread.setName("MyVeryOwnThread");
		thread.start();
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("We are in line approx 40 in the MyThread.run( )-method.");
		System.out.println("Let us see which thread is running these lines...");
		System.out.println(Thread.currentThread().getName());
	}
}