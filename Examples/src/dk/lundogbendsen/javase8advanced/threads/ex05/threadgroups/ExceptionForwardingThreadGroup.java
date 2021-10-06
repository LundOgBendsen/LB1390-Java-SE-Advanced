package dk.lundogbendsen.javase8advanced.threads.ex05.threadgroups;

public class ExceptionForwardingThreadGroup extends ThreadGroup {
	private UnhandledExceptionListener listener;

	ExceptionForwardingThreadGroup(final String name, final UnhandledExceptionListener listener) {
		super(name);
		this.listener = listener;
	}

	@Override
	public void uncaughtException(final Thread t, final Throwable e) {
		listener.unhandledException(t, e);
	}

}