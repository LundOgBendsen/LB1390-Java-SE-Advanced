package dk.lundogbendsen.javase_advanced.lambda.ex02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SwingWithLambda {
	private static int number;
	private static JLabel label;

	private static void updateNumber(final int n) {
		number = n;
		label.setText("Status: " + number);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new BorderLayout());

		// Old school
		JButton buttonUp = new JButton("Up");
		buttonUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				updateNumber(++number);
			}
		});

		// New kid on the block
		JButton buttonDown = new JButton("Down");
		buttonDown.addActionListener((e) -> updateNumber(--number));

		label = new JLabel();
		updateNumber(0);

		panel.add(buttonDown, BorderLayout.WEST);
		panel.add(buttonUp, BorderLayout.EAST);
		panel.add(label, BorderLayout.CENTER);

		frame.add(panel);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(final String[] args) {
		// Ups, still old school
		//
		// SwingUtilities.invokeLater(new Runnable()
		// {
		// @Override
		// public void run()
		// {
		// createAndShowGUI();
		// }
		// });
		Runnable r = () -> createAndShowGUI();
		SwingUtilities.invokeLater(r);
	}

}
