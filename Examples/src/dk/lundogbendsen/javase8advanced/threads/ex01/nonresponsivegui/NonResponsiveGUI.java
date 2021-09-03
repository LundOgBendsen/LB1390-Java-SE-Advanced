/*
 * Viser eksempel på brugergrænseflade, der 'hænger' mens programmet bagved arbejder.
 * Dvs. et eksempel på hvordan brugergrænseflader ville være uden brug af tråde.
 * 
 * Se ResponsiveGUI.java for løsning.
 */
package dk.lundogbendsen.javase8advanced.threads.ex01.nonresponsivegui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NonResponsiveGUI
{
  public static void main(String[] args)
  {
    final int times = 30;
    JFrame frame = new JFrame();
    JButton helloButton = new JButton("Print '-' " + times + " times");
    JButton hiButton = new JButton("Print '|' " + times + " times");
    frame.setLayout(new FlowLayout());
    frame.add(helloButton);
    frame.add(hiButton);
    helloButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        for (int n = 0; n < times; n++)
        {
          try
          {
            Thread.sleep(100);
          }
          catch (InterruptedException ex)
          { /* never happens */
          }
          System.out.print("-");
        }
      }
    });
    hiButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        for (int n = 0; n < times; n++)
        {
          try
          {
            Thread.sleep(100);
          }
          catch (InterruptedException ex)
          { /* never happens */
          }
          System.out.print("|");
        }
      }
    });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}