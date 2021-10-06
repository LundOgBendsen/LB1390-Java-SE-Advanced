package dk.lundogbendsen.javase8advanced.nestedtypes.ex03.nestedinterface;

public class MessagePrinter {
	private String message;
	private InnerThread innerThread;

	public MessagePrinter(String message) {
		this.message = message;
		this.innerThread = new InnerThread();
	}

	public void start() {
		this.innerThread.start();
	}

	private class InnerThread extends Thread {
		private InnerThread() {
			start();
		}

		@Override
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(message);
		}
	}
}
