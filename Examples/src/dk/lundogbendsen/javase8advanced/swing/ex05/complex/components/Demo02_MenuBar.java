package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;

public class Demo02_MenuBar {

	public static void main(final String[] args) {

		// Et vindue med titel-linie
		JFrame frame = new JFrame("Menu Bar");
		frame.setLayout(new BorderLayout());

		///////////////////////////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// tilføj menuer til menulinien
		JMenu menu1 = new JMenu("Menu_1");
		menuBar.add(menu1);
		JMenu menu2 = new JMenu("Menu_2");
		menuBar.add(menu2);

		// tilføj menupunkter til menuerne
		menu1.add(new AbstractAction("menu_item_1") {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("menu_item_1");
			}
		});
		menu1.add(new AbstractAction("menu_item_2") {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("menu_item_2");
			}
		});
		menu2.add(new AbstractAction("menu_item_3") {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("menu_item_3");
			}
		});
		menu2.add(new AbstractAction("menu_item_4") {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("menu_item_4");
			}
		});

		// tilføj en submenu til en af menuerne
		JMenu menu3 = new JMenu("Menu_3");
		menu2.add(menu3);

		// tilføj menupunkter til submenuen
		menu3.add(new AbstractAction("menu_item_5") {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("menu_item_5");
			}
		});
		menu3.add(new AbstractAction("menu_item_6") {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("menu_item_6");
			}
		});
		///////////////////////////////////////////////////////////////////

		// Lad vinduet give sig selv en passende størrelse.
		frame.setSize(400, 400);

		// Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
		// Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
		// Brug alternativt frame.addWindowListener(WindowListener listener).
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Gør vinduet synligt.
		frame.setVisible(true);

	}
}
