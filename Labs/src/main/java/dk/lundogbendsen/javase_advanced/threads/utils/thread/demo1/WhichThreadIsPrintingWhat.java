/*
  * WHICH THREAD PRINTS WHAT???
  *
  * It can often be difficult to see which threads do what. Calling
  * System.out.println rarely helps much in connection with threads, as
  * you cannot see which thread printed a given line.
  *
  * The problem can be alleviated to some extent by giving all threads a unique name
  * name using Thread.setName(String name), which only helps if you on
  * each and every print also print the thread name.
  */

package dk.lundogbendsen.javase_advanced.threads.utils.thread.demo1;

import dk.lundogbendsen.javase_advanced.threads.utils.thread.ThreadUtil;

public class WhichThreadIsPrintingWhat {
	public static void main(final String[] args) {

		// The method call changes System.out and System.err so that they always start
		// to print the name of the thread that called print or println.
		ThreadUtil.printThreadNames();

		String msg = "We are in line 29 in the Threads04.main( )-method.";
		System.out.println(msg);
		System.out.println("Let us see which thread is running these lines...");
		System.out.println(Thread.currentThread().getName());

		MyThread thread = new MyThread();
		thread.setName("MyVeryOwnThread");
		thread.start();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		String msg = "We are in line 42 in the MyThread.run( )-method.";
		System.out.println(msg);
		System.out.println("Let us see which thread is running these lines...");
		System.out.println(Thread.currentThread().getName());
	}
}