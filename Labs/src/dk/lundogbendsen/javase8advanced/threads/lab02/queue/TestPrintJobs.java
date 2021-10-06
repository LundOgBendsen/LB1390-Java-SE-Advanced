package dk.lundogbendsen.javase8advanced.threads.lab02.queue;

public class TestPrintJobs {

	public static void main(final String[] args) throws InterruptedException {
		PrintQueue sharedqueue = new PrintQueue();

		Thread provider1 = new Thread(new JobProvider(sharedqueue, "signe"));
		Thread provider2 = new Thread(new JobProvider(sharedqueue, "jakob"));
		// Thread provider3 = new Thread(new JobProviderBatch(sharedqueue, "kenneth"));

		JobConsumer jobconsumer = JobConsumer.getInstance();
		jobconsumer.setQueue(sharedqueue);
		Thread consumer = new Thread(jobconsumer);

		consumer.start();
		provider1.start();
		provider2.start();
		Thread.sleep(10000);
		// provider3.start();

	}

}
