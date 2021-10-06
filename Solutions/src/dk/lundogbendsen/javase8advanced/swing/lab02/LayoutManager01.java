package dk.lundogbendsen.javase8advanced.swing.lab02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutManager01 {

	public static void main(final String[] args) {

		JFrame frame = new JFrame("LayoutManager01");
		frame.setLayout(new BorderLayout());

		frame.add(new JButton("NORTH"), BorderLayout.NORTH);
		frame.add(new JButton("CENTER"), BorderLayout.CENTER);
		frame.add(new JButton("WEST"), BorderLayout.WEST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
