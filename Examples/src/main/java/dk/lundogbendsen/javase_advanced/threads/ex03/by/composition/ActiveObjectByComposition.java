package dk.lundogbendsen.javase_advanced.threads.ex03.by.composition;

/*
 * CONSTRUCTION OF THREAD WHEN IMPLEMENTING RUNNABLE.
 * Shows how to make a thread by implementing
 * the Runnable interface. The 'executable' instance is given to a new one
 * Thread instance, which is started with the start( ) method. After this
 * the Thread instance will create a new thread with which it calls run( ).
 * Note we call the thread's start( ) method in the constructor.
 */
public class ActiveObjectByComposition {
	public static void main(final String[] args) {
		new Printer("Bliiiip", 250, 40);
		new Printer("Duuuuut", 1000, 10);
	}
}