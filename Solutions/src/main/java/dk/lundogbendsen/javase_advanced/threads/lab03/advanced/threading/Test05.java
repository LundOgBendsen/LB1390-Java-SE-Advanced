package dk.lundogbendsen.javase_advanced.threads.lab03.advanced.threading;

public class Test05 {

	public static void main(final String[] args) throws Exception {
		Job job = new PrintMessageJob("Hi");
		LoopingWorker worker = new LoopingWorker(job, null, null, 200);

		Thread.sleep(1000);

		worker.deactivateAsap();
		System.out.println("Deactivated the looping worker");
		Thread.sleep(3000);
		System.out.println("Reactivated the looping worker");
		worker.reactivate();

		Thread.sleep(1000);

		worker.stopAsap();
		System.out.println("Stopped the looping worker");
	}
}
