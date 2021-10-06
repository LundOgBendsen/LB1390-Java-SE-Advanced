package dk.lundogbendsen.javase8advanced.io.ex04.other.destinations;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

public class NumberReadingThread extends Thread {
	private DataInputStream dis;

	NumberReadingThread(PipedInputStream pis) {
		dis = new DataInputStream(pis);
	}

	@Override
	public void run() {
		try {
			while (true) {
				int number = dis.readInt();
				System.out.println("Reader read number " + number);
				if (StreamsBetweenThreads.slowNumberReadingThread) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		} catch (IOException e) {
			System.out.println("IOException in Producer");
		}
	}
}