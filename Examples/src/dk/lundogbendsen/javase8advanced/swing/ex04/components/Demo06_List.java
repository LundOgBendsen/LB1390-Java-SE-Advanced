package dk.lundogbendsen.javase8advanced.swing.ex04.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;

public class Demo06_List
{

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    JFrame frame = new JFrame("Hello world program");
    frame.setLayout(new BorderLayout());

    // En liste
    // Tillader som default valg af flere items (hold fx ctrl nede)
    // Overrides med en af flg. metodekald:
    // - setSelectionModel(ListSelectionModel.SINGLE_SELECTION)
    // - setSelectionModel(ListSelectionModel.SINGLE_INTERVAL_SELECTION)
    // - setSelectionModel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION)
    String[] listItems = new String[] { "Item A", "Item B", "Item C", "Item D", "Item E" };
    final JList<String> list = new JList<String>(listItems);
    frame.add(list, BorderLayout.CENTER);

    JButton button = new JButton("Dump state");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        // Læsning af listens tilstand
        System.out.println("Følgende elementer er valgt i listen:");
        List<String> values = list.getSelectedValuesList();
        for (String s : values)
        {
          System.out.println("    -" + s);
        }
      }
    });
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
