package dk.lundogbendsen.javase8advanced.swing.ex04.components;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Demo03_TextArea
{

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    JFrame frame = new JFrame("Hello world program");
    frame.setLayout(new BorderLayout());

    // Et tekstfelt på flere linier
    // Brug JTextField for tekst-felter på én linie
    int rows = 5;
    int cols = 20;
    final JTextArea textArea = new JTextArea(rows, cols);
    frame.add(textArea, BorderLayout.CENTER);

    JButton button = new JButton("Dump state");
    button.addActionListener(e -> System.out.println("Teksten er: '" + textArea.getText() + "'"));
    frame.add(button, BorderLayout.SOUTH);

    // Lad vinduet give sig selv en passende størrelse.
    // Brug alternativt frame.setSize(200, 400);
    frame.pack();

    // Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
    // Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
    // Brug alternativt frame.addWindowListener(WindowListener listener).
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Gør vinduet synligt.
    frame.setVisible(true);

  }
}
