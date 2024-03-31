package dk.lundogbendsen.javase_advanced.threads.ex02.by.extension;

/*
 * CONSTRUCTION OF THREAD BY INHERITANCE FROM THREAD.
 * Shows how to create a thread by inheriting from Thread.
 * Note that the run( ) method is overridden in our subclass of Thread,
 * and that the thread is started by calling the inherited method start( ),
 * which here is done automatically in the constructor.
 */
public class ActiveObjectByExtension {
	public static void main(final String[] args) {
		new Printer("Bliiiip", 250, 40);
		new Printer("Duuuuut", 1000, 10);
	}
}