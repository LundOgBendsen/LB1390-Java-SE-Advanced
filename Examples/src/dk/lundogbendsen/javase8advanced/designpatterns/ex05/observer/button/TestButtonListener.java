package dk.lundogbendsen.javase8advanced.designpatterns.ex05.observer.button;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtonListener
{
  public static void main(final String[] args)
  {
    JFrame frame = new JFrame("Button Listener");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create event producer / observable / publisher
    JButton eventProducer = new JButton("Create event");

    // Create event consumer / observer / subscriber
    EventConsumer eventConsumer = new EventConsumer();

    // Register event consumer with event producer
    eventProducer.addActionListener(eventConsumer);

    frame.add(eventProducer);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}
