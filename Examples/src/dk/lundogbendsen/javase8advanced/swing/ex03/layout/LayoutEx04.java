package dk.lundogbendsen.javase8advanced.swing.ex03.layout;

/*
 * Layout inden i layout
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutEx04
{
  public static void main(final String[] args)
  {
    // Create button panel to be added in center of a Border Layout
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(2, 3)); // 2 høj, 3 bred
    JButton button1 = new JButton("added as no 1");
    JButton button2 = new JButton("added as no 2");
    JButton button3 = new JButton("added as no 3");
    JButton button4 = new JButton("added as no 4");
    JButton button5 = new JButton("added as no 5");
    JButton button6 = new JButton("added as no 6");
    buttonPanel.add(button1);
    buttonPanel.add(button2);
    buttonPanel.add(button3);
    buttonPanel.add(button4);
    buttonPanel.add(button5);
    buttonPanel.add(button6);

    // Create border layout
    JFrame frame = new JFrame("GridLayout in BorderLayout.CENTER");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLayout(new BorderLayout());
    JButton button7 = new JButton("NORTH");
    JButton button8 = new JButton("EAST");
    JButton button9 = new JButton("SOUTH");
    JButton button10 = new JButton("WEST");
    frame.add(button7, BorderLayout.NORTH);
    frame.add(button8, BorderLayout.EAST);
    frame.add(button9, BorderLayout.SOUTH);
    frame.add(button10, BorderLayout.WEST);

    // Add button panel to the center of the Border Layout
    frame.add(buttonPanel, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}