/*
  * Shows example of user interface that does NOT 'hang' while the program behind it is working.
  * That is an example of how user interfaces can be made with the use of threads.
  *
  * See also NonResponsiveGUI.java.
  */
package dk.lundogbendsen.javase_advanced.threads.ex01.nonresponsivegui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ResponsiveGUI {
	public static void main(final String[] args) {
		final int times = 30;
		JFrame frame = new JFrame();
		JButton helloButton = new JButton("Print '-' " + times + " times");
		JButton hiButton = new JButton("Print '|' " + times + " times");
		frame.setLayout(new FlowLayout());
		frame.add(helloButton);
		frame.add(hiButton);
		helloButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						for (int n = 0; n < times; n++) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException ex) { /* never happens */
							}
							System.out.print("-");
						}
					}
				}.start();
			}
		});
		hiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						for (int n = 0; n < times; n++) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException ex) { /* never happens */
							}
							System.out.print("|");
						}
					}
				}.start();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}