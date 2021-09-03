package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Demo04_ChooseFileToLoad
{
  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    final JFrame frame = new JFrame("File chooser (load)");
    frame.setLayout(new BorderLayout());

    ///////////////////////////////////////////////////////////////////

    JButton button = new JButton("Load file...");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        File fileChosen = showLoadFileChooser(frame);
        if (fileChosen == null)
        {
          System.out.println("User didn't select a file");
        }
        else
        {
          System.out.print("File chosen is: ");
          System.out.println(fileChosen.getAbsolutePath());
        }
      }
    });
    frame.add(button, BorderLayout.CENTER);

    ///////////////////////////////////////////////////////////////////

    // Lad vinduet give sig selv en passende størrelse.
    frame.pack();

    // Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
    // Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
    // Brug alternativt frame.addWindowListener(WindowListener listener).
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Gør vinduet synligt.
    frame.setVisible(true);

  }

  private static File showLoadFileChooser(final JFrame parentFrame)
  {
    JFileChooser fileChooser = new JFileChooser(".");
    int returnVal = fileChooser.showOpenDialog(parentFrame);
    if (returnVal == JFileChooser.APPROVE_OPTION)
    {
      return fileChooser.getSelectedFile();
    }
    else
    {
      return null;
    }
  }
}
