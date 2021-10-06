package dk.lundogbendsen.javase8advanced.swing.ex03.layout;

/*
 * Layout inden i layout inden i layout ;-)
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutEx05 {
	public static void main(String[] args) {

		// Create button panel to be added field no 2 of Grid Layout
		JPanel borderButtonPanel = new JPanel();
		borderButtonPanel.setLayout(new BorderLayout());
		JButton button1 = new JButton("N");
		JButton button2 = new JButton("E");
		JButton button3 = new JButton("S");
		JButton button4 = new JButton("W");
		JButton button5 = new JButton("C");
		borderButtonPanel.add(button1, BorderLayout.NORTH);
		borderButtonPanel.add(button2, BorderLayout.EAST);
		borderButtonPanel.add(button3, BorderLayout.SOUTH);
		borderButtonPanel.add(button4, BorderLayout.WEST);
		borderButtonPanel.add(button5, BorderLayout.CENTER);

		// Create button panel to be added in center of a Border Layout
		JPanel gridButtonPanel = new JPanel();
		gridButtonPanel.setLayout(new GridLayout(2, 3)); // 2 høj, 3 bred !!
		JButton button6 = new JButton("no 1");
		// Husk vi indsætter borderButtonPanel på plads 2
		JButton button7 = new JButton("no 3");
		JButton button8 = new JButton("no 4");
		JButton button9 = new JButton("no 5");
		JButton button10 = new JButton("no 6");

		gridButtonPanel.add(button6);
		// på plads 2 sættes borderButtonPanel !!!!
		gridButtonPanel.add(borderButtonPanel);
		gridButtonPanel.add(button7);
		gridButtonPanel.add(button8);
		gridButtonPanel.add(button9);
		gridButtonPanel.add(button10);

		// Create border layout
		JFrame frame = new JFrame("GridLayout in BorderLayout.CENTER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JButton button11 = new JButton("NORTH");
		JButton button12 = new JButton("EAST");
		JButton button13 = new JButton("SOUTH");
		JButton button14 = new JButton("WEST");
		frame.add(button11, BorderLayout.NORTH);
		frame.add(button12, BorderLayout.EAST);
		frame.add(button13, BorderLayout.SOUTH);
		frame.add(button14, BorderLayout.WEST);

		// Add button panel to the center of the Border Layout
		frame.add(gridButtonPanel, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}
}