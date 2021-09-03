package dk.lundogbendsen.javase8advanced.swing.ex04.components;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Demo04_CheckBox
{

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    JFrame frame = new JFrame("Hello world program");
    frame.setLayout(new GridLayout(2, 1));

    // Et afkrydningsfelt
    // Feltet er final, så det kan bruges fra en anonym klasse nedenfor
    final JCheckBox checkBox = new JCheckBox("My check box");
    frame.add(checkBox);

    JButton button = new JButton("Dump state");
    button.addActionListener(e ->
    {
      // Læsning af Checkboxens tilstand
        if (checkBox.isSelected())
        {
          System.out.println("Checkbox is selected");
        }
        else
        {
          System.out.println("Checkbox is NOT selected");
        }
      });
    frame.add(button);

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
