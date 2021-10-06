package dk.lundogbendsen.javase8advanced.swing.ex07.listeners;

/*
 * Illustrerer princippet med events, listeners (event-consumers) og
 * event-producers.
 */

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ListenerEx01 {

	public static void main(final String[] args) throws Exception {

		// Vi laver en event-listener
		ActionListener printHelloListener = e -> System.out.println("Hello");

		// Og endnu en event-listener
		ActionListener printHiListener = e -> System.out.println("Hi");

		// Så laver vi en event-producer, og registrerer
		// de to listeners hos den
		Timer timer = new Timer(500, printHelloListener);
		timer.addActionListener(printHiListener);
		timer.start();

		Thread.sleep(6000);
		timer.stop();
	}
}