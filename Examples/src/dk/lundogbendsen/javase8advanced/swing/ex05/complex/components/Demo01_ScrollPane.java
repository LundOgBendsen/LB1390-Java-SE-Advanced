package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Demo01_ScrollPane
{

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    JFrame frame = new JFrame("Scroll Pane");
    frame.setLayout(new BorderLayout());

    // Et tekstfelt på flere linier
    // Brug JTextField for tekst-felter på én linie
    int rows = 5;
    int cols = 20;
    final JTextArea textArea = new JTextArea(rows, cols);
    textArea.setText("linie 1\nlinie 2\nlinie 3\nlinie 4\nlinie 5\nlinie 6\nlinie 7");

    ///////////////////////////////////////////////////////////////

    // Placér text area-komponenten i et JScrollPane
    JScrollPane scrollPane = new JScrollPane(textArea);

    // Indsæt scroll pane'et i stedet for text area'et
    frame.add(scrollPane, BorderLayout.CENTER);

    ///////////////////////////////////////////////////////////////

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
