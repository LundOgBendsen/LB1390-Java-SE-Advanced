package dk.lundogbendsen.javase8advanced.designpatterns.ex05.observer.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class EventConsumer implements ActionListener
{

  // Implement the appropriate notification method (accept event as parameter)
  @Override
  public void actionPerformed(ActionEvent e)
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