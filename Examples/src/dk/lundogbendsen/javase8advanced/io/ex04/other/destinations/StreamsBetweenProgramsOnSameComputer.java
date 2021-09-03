package dk.lundogbendsen.javase8advanced.io.ex04.other.destinations;

/*
 * Illustrerer hvordan man fra et Java-program kan starte et
 * andet program og få fingre i dennes System.in, err og out!
 * Programmet bruger programmet StreamsToUser.java, idet
 * vi snyder StreamsToUser.java til at tro at dette program er
 * en bruger (kunne evt. bruges til at teste et program).
 */
import java.io.*;

public class StreamsBetweenProgramsOnSameComputer
{
  public static void main(String[] args) throws IOException
  {
    // Vi sikrer os først lige at StreamsToUser er kompileret:
    File f = new File("StreamsToUser.class");
    if (!f.exists())
    {
      Runtime.getRuntime().exec("javac StreamsToUser.java");
    }

    // Så starter vi StreamsToUser
    Process streamsToUserProgram = Runtime.getRuntime().exec("java StreamsToUser");

    // Så får vi fingre i StreamsToUsers System.out, err og in
    InputStream othersErr = streamsToUserProgram.getErrorStream();
    InputStream othersOut = streamsToUserProgram.getInputStream();
    OutputStream othersIn = streamsToUserProgram.getOutputStream();
    
    @SuppressWarnings("unused")
    final BufferedReader fromErr = new BufferedReader(new InputStreamReader(othersErr));
    final BufferedReader fromOut = new BufferedReader(new InputStreamReader(othersOut));
    final PrintWriter toIn = new PrintWriter(new OutputStreamWriter(othersIn));

    // Da vi ved reads er blocking calls hvis der ikke er noget at læse
    // sætter vi en tråd til at læse fra den andet program (og udskrive det læste)
    Thread readFromOtherProgramAndPrint = new Thread()
    {
      @Override
      public void run()
      {
        try
        {
          while (true)
          {
            String read = fromOut.readLine();
            System.out.println(read);
          }
        }
        catch (IOException e)
        {
        }
      }
    };
    readFromOtherProgramAndPrint.setDaemon(true);
    readFromOtherProgramAndPrint.start();

    // Lets wait a bit for the other program to get a chance to write to its user (me;-)
    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
    }

    // Lets play around a bit with the other program
    for (int n = 0; n < 3; n++)
    {
      sendKeyStrokeToOtherProgram(toIn, "H");
      sendKeyStrokeToOtherProgram(toIn, "i");
      sendKeyStrokeToOtherProgram(toIn, ",");
      sendKeyStrokeToOtherProgram(toIn, " ");
      sendKeyStrokeToOtherProgram(toIn, "I");
      sendKeyStrokeToOtherProgram(toIn, "'");
      sendKeyStrokeToOtherProgram(toIn, "m");
      sendKeyStrokeToOtherProgram(toIn, " ");
      sendKeyStrokeToOtherProgram(toIn, "a");
      sendKeyStrokeToOtherProgram(toIn, " ");
      sendKeyStrokeToOtherProgram(toIn, "r");
      sendKeyStrokeToOtherProgram(toIn, "e");
      sendKeyStrokeToOtherProgram(toIn, "a");
      sendKeyStrokeToOtherProgram(toIn, "l");
      sendKeyStrokeToOtherProgram(toIn, " ");
      sendKeyStrokeToOtherProgram(toIn, "u");
      sendKeyStrokeToOtherProgram(toIn, "s");
      sendKeyStrokeToOtherProgram(toIn, "e");
      sendKeyStrokeToOtherProgram(toIn, "r");
      sendKeyStrokeToOtherProgram(toIn, "!");
      sendKeyStrokeToOtherProgram(toIn, "\n");
    }

    // Lets end the other program the HARD way
    streamsToUserProgram.destroy();
    try
    {
      streamsToUserProgram.waitFor();
    }
    catch (InterruptedException e)
    {
    }
    System.out.print("Other program killed! It's exitValue was: ");
    System.out.println(streamsToUserProgram.exitValue());
  }

  static void sendKeyStrokeToOtherProgram(PrintWriter pw, String keyStroke)
  {
    pw.print(keyStroke);
    System.out.print(keyStroke);
    pw.flush();
    int sleepTime = (int) (Math.random() * 150 + 50);
    try
    {
      Thread.sleep(sleepTime);
    }
    catch (InterruptedException e)
    {
    }
    pw.flush();
  }
}
