package dk.lundogbendsen.javase8advanced.threads.ex09.thread.naming;

//  NAVNGIVNING AF TRÅDE
//  Det kan ofte være en fordel at give tråde navne, så kan
//  det være nemmere at finde ud af hvem der gør hvad hvornår.

public class WhoIsDoingWhatEx01 {
	public static void main(final String[] args) {
		System.out.println("We are in line approx. 12 in the WhoIsDoingWhatEx01.main( )-method.");
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
		System.out.println("We are in line approx 26 in the MyThread.run( )-method.");
		System.out.println("Let us see which thread is running these lines...");
		System.out.println(Thread.currentThread().getName());
	}
}