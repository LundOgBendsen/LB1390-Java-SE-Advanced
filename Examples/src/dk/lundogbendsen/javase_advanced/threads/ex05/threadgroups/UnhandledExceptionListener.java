package dk.lundogbendsen.javase_advanced.threads.ex05.threadgroups;

public interface UnhandledExceptionListener {
	public void unhandledException(Thread t, Throwable e);
}