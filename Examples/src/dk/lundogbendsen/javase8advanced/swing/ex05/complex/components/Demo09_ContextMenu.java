/*
 * Det er nu muligt at tilføje en JPopupMenu-instans til alle komponenter,
 * fremfor selv at skulle tilføje relevante key event listeners.
 *
 * Klassen JComponent har fået følgende metoder:
 * - void setInheritsPopupMenu(boolean value) // delegate to parent component?
 * - boolean getInheritsPopupMenu()
 * - void setComponentPopupMenu(JPopupMenu popup)
 * - JPopupMenu getComponentPopupMenu()
 */
package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

public class Demo09_ContextMenu {
	public static void main(final String[] args) {

		JFrame frame = new JFrame("Swing Test");

		frame.setLayout(new BorderLayout());

		JButton button = new JButton("Rightclick to activate menu");

		button.addActionListener(e -> System.out.println("Left click"));

		// *********************************************************************
		// * Her opretter og tilføjer vi en popup-menu til knappen
		// *********************************************************************
		JPopupMenu popupMenu = new JPopupMenu("Menu");
		popupMenu.add(new AbstractAction("Action 1") {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("Action 1");
			}
		});
		popupMenu.add(new AbstractAction("Action 2") {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("Action 2");
			}
		});
		button.setComponentPopupMenu(popupMenu);

		frame.add(button);
		frame.pack();
		frame.setVisible(true);

	}
}
