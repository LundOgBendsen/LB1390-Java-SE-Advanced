package dk.lundogbendsen.javase8advanced.swing.ex03.layout;

/*
 * Brugen af GridLayout
 */
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutEx03 {
	public static void main(final String[] args) {
		JFrame frame = new JFrame("GridLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button1 = new JButton("added as no 1");
		JButton button2 = new JButton("added as no 2");
		JButton button3 = new JButton("added as no 3");
		JButton button4 = new JButton("added as no 4");
		JButton button5 = new JButton("added as no 5");
		frame.setLayout(new GridLayout(3, 2)); // 3 høj, 2 bred
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.pack();
		frame.setVisible(true);
	}
}