package dk.lundogbendsen.javase8advanced.swing.ex03.layout;

/*
 * Viser hvad sker der hvis ikke alle 5 felter bruges i BorderLayout?
 * Prøv at resize vinduet - hvilke områder får lov til at tage pladsen?
 */
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutEx02
{
  public static void main(final String[] args)
  {
    JFrame frame = new JFrame("BorderLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton button1 = new JButton("NORTH");
    JButton button2 = new JButton("EAST");
    //JButton button3 = new JButton( "SOUTH" );
    JButton button4 = new JButton("WEST");
    JButton button5 = new JButton("CENTER");
    frame.setLayout(new BorderLayout());
    frame.add(button1, BorderLayout.NORTH);
    frame.add(button2, BorderLayout.EAST);
    //frame.add( button3, BorderLayout.SOUTH );
    frame.add(button4, BorderLayout.WEST);
    frame.add(button5, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
}