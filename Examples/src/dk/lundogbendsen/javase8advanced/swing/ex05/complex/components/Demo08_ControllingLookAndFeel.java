/*
 * Viser det nye default look-and-feel (Ocean).
 *
 * Desuden er der blevet tilføjet et LaF kaldet Synth, der kan tilpasses vha.
 * skins, uden at skrive noget kode. Se:
 * http://www.javapassion.com/planning/handsonbyol/swingsynth/
 */
package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Demo08_ControllingLookAndFeel {

	public static void main(final String[] args) throws Exception {

		// FÅ JAVA TIL AT BRUGE DET GAMLE UDSEENDE PÅ METAL
		// System.setProperty("swing.metalTheme", "steel");

		// BRUG *JAVAS* DEAFULT LOOK AND FEEL (ER DEFAULT DET VALGTE)
		// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

		// BRUG *OPERATIVSYSTEMETS* DEFAULT LOOK AND FEEL (FX WINDOWS XP)
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		// Udskriv klassenavnet på alle installerede Look and feels
		LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo laf : lafs) {
			System.out.println(laf.getClassName());
		}

		// ANGIV NAVN PÅ DET LAF, DER SKAL BRUGES (brug fully qualified class name)
		// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

		JFrame frame = new JFrame("Swing Test");

		frame.setLayout(new BorderLayout()); // NB: Uden getContentPane() !!

		JButton button = new JButton("Print hej");

		button.addActionListener(e -> System.out.println("Hej"));

		frame.add(button); // NB: Uden getContentPane() !!
		frame.pack();
		frame.setVisible(true);
	}

}
