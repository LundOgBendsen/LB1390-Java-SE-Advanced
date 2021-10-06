package dk.lundogbendsen.javase8advanced.swing.ex07.listeners;
/*
* Illustrerer princippet med events, listeners (event-consumers) og
* event-producers.
*/

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerEx02 {

	public static void main(final String[] args) throws Exception {

		// Vi laver en event-listener - Java 8 style
		ActionListener eventListener = e -> System.out.println("Consumer received event");

		// Så laver vi en event-producer...
		JButton eventProducer = new JButton("Produce event");
		// ... og registrerer vores event-listener hos den
		eventProducer.addActionListener(eventListener);

		JFrame frame = new JFrame("Event-programming test");
		frame.add(eventProducer);
		frame.setSize(new Dimension(200, 200));
		frame.setVisible(true);
	}
}