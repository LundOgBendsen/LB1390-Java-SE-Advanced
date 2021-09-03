package dk.lundogbendsen.javase8advanced.swing.ex05.complex.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;

public class Demo03_InternalFrames
{

  public static int frameCount = 1;

  public static void main(final String[] args)
  {

    // Et vindue med titel-linie
    JFrame frame = new JFrame("Internal Frames");
    frame.setLayout(new BorderLayout());

    ///////////////////////////////////////////////////////////////////

    // erklæret final, så vi kan få fat i den fra den anonyme klasse nedenfor
    final JDesktopPane desktopPane = new JDesktopPane();
    frame.add(desktopPane, BorderLayout.CENTER);

    JButton button = new JButton("Add new frame");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {

        // Variablen er final for at kunne bruge den i den
        // anonyme klasse tilhørende knappen nedenfor
        final int frameNo = frameCount++;
        String title = "Internal frame (" + frameNo + ")";

        // Lav ny internt vindue
        // JInternalFrame(title, resizable, closable, maximizable)
        JInternalFrame f = new JInternalFrame(title, true, true, true);

        // Sæt størrelsen på den interne frame
        f.setSize(200, 100);

        // Tilføj den interne frame til desktop pane'et
        desktopPane.add(f);

        // Husk at gøre den interne frame synlig
        f.setVisible(true);

        // Tilføj en knap til den interne frame
        JButton button = new JButton("Print " + frameNo);
        f.add(button);
        button.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(final ActionEvent e)
          {
            System.out.println("Knap " + frameNo + " trykket");
          }
        });

      }
    });
    frame.add(button, BorderLayout.SOUTH);

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
