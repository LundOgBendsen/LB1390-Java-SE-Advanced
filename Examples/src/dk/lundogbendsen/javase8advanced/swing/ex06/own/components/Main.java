package dk.lundogbendsen.javase8advanced.swing.ex06.own.components;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main
{

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    JFrame frame = new JFrame("Hello world program");
    frame.setLayout(new GridLayout(1, 1));

    // En bid tekst
    MyLabel label = new MyLabel();
    label.setText("This is my label");
    label.setFontSize(16);

    frame.add(label);

    // Lad vinduet give sig selv en passende størrelse.
    frame.setSize(200, 400);

    // Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
    // Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
    // Brug alternativt frame.addWindowListener(WindowListener listener).
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Gør vinduet synligt.
    frame.setVisible(true);

  }
}
