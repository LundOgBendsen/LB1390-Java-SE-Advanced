package dk.lundogbendsen.javase8advanced.designpatterns.ex05.observer.button;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtonListenerWithLambdaExpressionMethodReference
{
  public static void main(final String[] args)
  {
    JFrame frame = new JFrame("Button Listener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create event producer / observable / publisher
    JButton eventProducer = new JButton("Create event");

    // Register event consumer with event producer
    eventProducer.addActionListener(TestButtonListenerWithLambdaExpressionMethodReference::doEvent);

    frame.add(eventProducer);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }

  private static void doEvent(final ActionEvent e)
  {
    System.out.println("Listener01 received event containing:");
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
    DateFormat tf = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.getDefault());
    String date = df.format(new Date(e.getWhen()));
    String time = tf.format(new Date(e.getWhen()));
    System.out.println("  When = " + date + " " + time);
    System.out.println("  Source = " + e.getSource());
  }
}
