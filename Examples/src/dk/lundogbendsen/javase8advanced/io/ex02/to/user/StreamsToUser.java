package dk.lundogbendsen.javase8advanced.io.ex02.to.user;

/**
 * The user is just a very slow IO-device!
 * Viser streams til og fra brugeren (consol og keyboard).
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamsToUser {
	public static void main(final String[] args) throws IOException {
		System.out.println(System.out.getClass().getName());

		// OUTPUT TO User (console)
		System.out.println("Hello user (System.out)");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Hello again user (System.err)");

		System.out.println("Type something please (end with return)");

		// INPUT FROM User (keyboard)
		String userInput = "";
		while (!userInput.equals("end")) {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader keyboard = new BufferedReader(isr);
			userInput = keyboard.readLine();

			System.out.println("Hey user - you wrote: " + userInput);
		}
	}
}