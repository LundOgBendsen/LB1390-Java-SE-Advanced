package dk.lundogbendsen.javase8advanced.swing.lab02;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Klassen viser det andet BorderLayout i øvelsen 'Swing-02'.
 * Løsningen demonstrerer hvordan et panel kan indeholde ét eller flere paneler - Hver med deres eget layout.
 */
public class LayoutManager02 {

	public static void main(final String[] args) {

		JFrame frame = new JFrame("LayoutManager02");
		frame.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1, 3));
		north.add(new JButton("NORTH 1"));
		north.add(new JButton("NORTH 2"));
		north.add(new JButton("NORTH 3"));

		JPanel west = new JPanel();
		west.setLayout(new GridLayout(2, 2));
		west.add(new JButton("West group 1"));
		west.add(new JButton("West group 2"));
		west.add(new JButton("West group 3"));
		west.add(new JButton("West group 4"));

		frame.add(north, BorderLayout.NORTH);
		frame.add(new JButton("CENTER"), BorderLayout.CENTER);
		frame.add(west, BorderLayout.WEST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
