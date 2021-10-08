package dk.lundogbendsen.javase_advanced.threads.lab03.advanced.threading;

public interface ExceptionListener {
	public void onJobFailure(Job job, Throwable reason);
}
