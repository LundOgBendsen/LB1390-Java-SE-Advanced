package dk.lundogbendsen.javase8advanced.swing.lab01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Eksempel på en simpel lommeregner kreeret ved hjælp af grid layout.
 */
public class Lommeregner {

	public static void main(final String[] args) {

		JFrame frame = new JFrame("Lommeregner");
		frame.setLayout(new GridLayout(4, 2));

		// første række
		frame.add(new JLabel("Indtast et tal A"));
		final JTextField numA = new JTextField();
		frame.add(numA);

		// anden række
		frame.add(new JLabel("Indtast et tal B"));
		final JTextField numB = new JTextField();
		frame.add(numB);

		// tredje række
		frame.add(new JLabel("Summen af A og B er:"));
		final JTextField sum = new JTextField();
		sum.setEditable(false);
		frame.add(sum);

		// fjerde række - tilføj først tom label i nederste venstre hjørne
		frame.add(new JLabel());
		JButton beregn = new JButton("Beregn sum");
		// Brug af action listeners (observer pattern) er udbredt i swing. Her
		// er den benyttede action listener implementeret som en indre anonym
		// klasse.
		beregn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				int a = Integer.parseInt(numA.getText());
				int b = Integer.parseInt(numB.getText());
				sum.setText(Integer.toString(a + b));
			}
		});
		frame.add(beregn);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
