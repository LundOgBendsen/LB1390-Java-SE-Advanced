package dk.lundogbendsen.javase_advanced.threads.lab01.printer.blocking.nonblocking;

public class SlowPrinterOpgave {
	public static void main(final String[] args) {
		String[] s1 = new String[20];
		for (int n = 0; n < s1.length; n++) {
			s1[n] = "A";
		}
		String[] s2 = new String[20];
		for (int n = 0; n < s2.length; n++) {
			s2[n] = "B";
		}
		String[] s3 = new String[20];
		for (int n = 0; n < s3.length; n++) {
			s3[n] = "C";
		}
		SlowPrinter.blockingPrint(s1);
		SlowPrinter.blockingPrint(s2);
		SlowPrinter.blockingPrint(s3);
		System.out.println();
		System.out.println();
		SlowPrinter.nonBlockingPrint(s1);
		SlowPrinter.nonBlockingPrint(s2);
		SlowPrinter.nonBlockingPrint(s3);

	}
}

class SlowPrinter {
	public static void blockingPrint(final String[] s) {
		for (int n = 0; n < s.length; n++) {
			System.out.print(s[n]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Implementeret ved brug af anonym indre klasse - bemærk final modifier for s
	public static void nonBlockingPrint(final String[] s) {
		new Thread() {
			@Override
			public void run() {
				for (int n = 0; n < s.length; n++) {
					System.out.print(s[n]);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	// //Implementeret ved brug af komposition (Runnable interfacet)
	// public static void nonBlockingPrint(String[] s){
	// MyRunnable runnable = new MyRunnable(s);
	// Thread t = new Thread(runnable);
	// t.start();
	// }
	//
	// //Implementeret ved brug af arv
	// public static void nonBlockingPrint(String[] s){
	// Thread t = new MyThread(s);
	// t.start();
	// }
}

class MyRunnable implements Runnable {
	String[] s;

	public MyRunnable(final String[] s) {
		this.s = s;
	}

	@Override
	public void run() {
		for (int n = 0; n < s.length; n++) {
			System.out.print(s[n]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread extends Thread {
	String[] s;

	public MyThread(final String[] s) {
		this.s = s;
	}

	@Override
	public void run() {
		for (int n = 0; n < s.length; n++) {
			System.out.print(s[n]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}