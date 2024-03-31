package dk.lundogbendsen.javase_advanced.threads.lab03.advanced.threading;

public class Test03 {

	public static void main(final String[] args) {

		CompletionListener completionListener = new CompletionListener() {
			@Override
			public void onJobCompletion(final Job job) {
				System.out.println("The job: " + job);
				int result = ((DivideAndRememberResultJob) job).getResult();
				System.out.println("Completed with the result: " + result);
			}
		};

		Job job = new DivideAndRememberResultJob(16, 2);
		new Worker(job, completionListener, null);
	}
}
