package dk.lundogbendsen.javase8advanced.io.ex04.other.destinations;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;

public class RandomNumberProducingThread extends Thread {
	private DataOutputStream dos;
	private Random random = new Random();

	RandomNumberProducingThread(PipedOutputStream pos) {
		dos = new DataOutputStream(pos);
	}

	@Override
	public void run() {
		try {
			while (true) {
				int number = random.nextInt();
				dos.writeInt(number);
				System.out.println("Producer wrote number " + number);
			}
		} catch (IOException e) {
			System.out.println("IOException in Producer");
		}
	}
}