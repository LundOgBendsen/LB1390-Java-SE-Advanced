package dk.lundogbendsen.javase_advanced.threads.ex06.start.only.once;

/*
 * ONE CAN ONLY CALL START( ) ONCE.
 */
public class StartCanOnlyBeCalledOnce {
	public static void main(final String[] args) throws InterruptedException {
		SimpleRunnable sr = new SimpleRunnable();
		Thread thread = new Thread(sr);
		thread.start();
		System.out.flush();
		System.out.println("thread.start( ) was called the first time");

		System.out.flush();
		Thread.sleep(2000);

		try {
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.flush();
			Thread.sleep(2000);
		}
		System.out.flush();
		System.out.println("thread.start( ) was called the second time");
		System.out.println("setting sr.keepRunning = false");
		sr.keepRunning = false;

		System.out.flush();
		Thread.sleep(2000);

		try {
			sr.keepRunning = false;
			thread.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.flush();
		}

		System.out.flush();
		Thread.sleep(2000);

		System.out.println("thread.start( ) was called the third time");

		System.out.flush();
		Thread.sleep(2000);

		System.out.println();
		Thread.dumpStack();
	}
}