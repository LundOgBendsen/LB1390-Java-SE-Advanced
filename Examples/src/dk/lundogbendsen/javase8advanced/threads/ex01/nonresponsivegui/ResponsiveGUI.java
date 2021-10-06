/*
 * Viser eksempel på brugergrænseflade, der IKKE 'hænger' mens programmet bagved arbejder.
 * Dvs. et eksempel på hvordan brugergrænseflader kan lave med brugen af tråde.
 *
 * Se også NonResponsiveGUI.java.
 */
package dk.lundogbendsen.javase8advanced.threads.ex01.nonresponsivegui;

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