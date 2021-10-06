package dk.lundogbendsen.javase8advanced.reflection.ex02.load.and.call;

public class RunnableTwo implements Runnable {

	@Override
	public void run() {
		System.out.println("RunnableTwo has startet");
		System.out.println("2 * 2 is: " + (2 * 2));
		System.out.println("RunnableTwo has finished");
	}
}
