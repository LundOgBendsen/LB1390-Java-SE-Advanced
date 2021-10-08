package dk.lundogbendsen.javase_advanced.threads.ex09.thread.naming;

import dk.lundogbendsen.javase_advanced.threads.utils.ThreadUtil;

//  NAVNGIVNING AF TRÅDE
//  Det er irriterende at man ikke altid kan se hvem der udskriver.
//  Metoden ThreadUtil.printThreadNames( ) sikrer at alle kald til
//  System.out.print( ) / println( ) også udskriver navnet på den
//  tråd, der foretager kaldet til print( ) eller println( ).

public class WhoIsDoingWhatEx02 {
	public static void main(final String[] args) {

		// Metoden ændrer på System.out, så print( ) og println( ) starter med
		// at skrive navnet på den tråd, der kaldte dem. Godt mht. forståelse af
		// tråde!

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