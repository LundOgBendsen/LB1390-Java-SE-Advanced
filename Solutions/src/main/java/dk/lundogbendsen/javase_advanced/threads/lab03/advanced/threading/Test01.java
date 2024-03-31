package dk.lundogbendsen.javase_advanced.threads.lab03.advanced.threading;

public class Test01 {

	public static void main(final String[] args) {
		Job job = new DivideAndPrintResultJob(4, 2);
		new Worker(job, null, null);
	}
}
