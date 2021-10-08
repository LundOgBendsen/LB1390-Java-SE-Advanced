/*
 * HVILKE TRÅDE UDSKRIVER HVAD???
 *
 * Det kan være ofte være svært at overskue hvilke tråde, der gør hvad. Kald af
 * System.out.println hjælper sjældent ret meget i forbindelse med tråde, da
 * man ikke kan se, hvilken tråd det er, der har udskrevet en given linie.
 *
 * Man kan til en hvis grad afhjælpe problemet, ved at give alle tråde et unikt
 * navn vha. Thread.setName(String name), hvilket dog kun hjælper, hvis man ved
 * hver eneste udskrift også udskriver trådnavnet.
 *
 * Klassen ThreadUtil har en metode ThreadUtil.printThreadNames(), som ændrer
 * System.out og System.err, så kald til print eller println ALTID starter med
 * at udskrive navnet på den tråd, der kalder metoden.
 */

package dk.lundogbendsen.javase_advanced.threads.utils.thread.demo1;

import dk.lundogbendsen.javase_advanced.threads.utils.thread.ThreadUtil;

public class WhichThreadIsPrintingWhat {
	public static void main(final String[] args) {

		// Metodekaldet ændrer System.out og System.err, så de altid starter
		// med at udskrive navnet på den tråd, der kaldte print eller println.
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