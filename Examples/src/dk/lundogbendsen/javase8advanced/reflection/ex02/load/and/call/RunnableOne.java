package dk.lundogbendsen.javase8advanced.reflection.ex02.load.and.call;

public class RunnableOne implements Runnable {

	@Override
	public void run() {
		System.out.println("RunnableOne has startet");
		System.out.println("2 + 2 is: " + (2 + 2));
		System.out.println("RunnableOne has finished");
	}
}
