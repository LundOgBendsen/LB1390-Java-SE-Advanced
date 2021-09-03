package dk.lundogbendsen.javase8advanced.io.ex04.other.destinations;

/*
 * Illustrerer brugen af en pipe imellem to tråde i samme program.
 * Prøv at ændre på variablerne: startNumberReadingThread og
 * slowNumberReadingThread og observer resultaterne.
 * Mest interessant er det nok at sætte begge til true - bemærk
 * i den forbindelse at både read og write på pipes er blocking calls
 * der blokerer hvis den anden ende af pipen ikke kan følge med.
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class StreamsBetweenThreads
{

  // Prøv at ændre på disse værdier
  static boolean startNumberReadingThread = false;
  static boolean slowNumberReadingThread = false;

  public static void main(final String[] args) throws IOException
  {

    PipedOutputStream pos = new PipedOutputStream();
    PipedInputStream pis = new PipedInputStream(pos);

    Thread t1 = new RandomNumberProducingThread(pos);
    t1.start();

    if (startNumberReadingThread)
    {
      Thread t2 = new NumberReadingThread(pis);
      t2.start();
    }
  }
}
