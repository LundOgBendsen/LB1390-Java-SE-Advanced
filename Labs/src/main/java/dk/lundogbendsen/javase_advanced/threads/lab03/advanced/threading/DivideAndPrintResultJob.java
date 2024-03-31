package dk.lundogbendsen.javase_advanced.threads.lab03.advanced.threading;

public class DivideAndPrintResultJob implements Job {

	private int a;
	private int b;

	public DivideAndPrintResultJob(final int a, final int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void execute() throws Exception {
		// simulate long running task
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// do the actual job
		int result = a / b;
		System.out.println(result);
	}

	@Override
	public String toString() {
		return "DivideAndPrintJob[a=" + a + ", b=" + b + "]";
	}
}
