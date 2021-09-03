package dk.lundogbendsen.javase8advanced.io.ex03.over.net;

/*
 * Se beskrivelse i den tilhørende StreamsOverNetworkServer.
 * NB: Start serveren først.
 */
import java.io.*;
import java.net.*;

public class StreamsOverNetworkClient
{
  public static void main(String[] args) throws Exception
  {
    // Serveren lytter på port 3456.
    // Vi bruger bare localhost, men kunne
    // bruge et ip-nummer til en anden computer.
    // Man kan checke en computers ip-nummer
    // ved at bruge kommandoen ipconfig i dos.
    try (Socket socket = new Socket("localhost", 3456);)
    {
      OutputStream os = socket.getOutputStream();
      DataOutputStream dos = new DataOutputStream(os);

      InputStream is = socket.getInputStream();
      DataInputStream dis = new DataInputStream(is);

      int howManyRequests = (int) (Math.random() * 30 + 20);
      for (int n = 0; n < howManyRequests; n++)
      {
        int notIncludingTax = (int) (Math.random() * 5000 + 1000);
        dos.writeInt(notIncludingTax);
        System.out.println("Asked server to calculate tax for " + notIncludingTax);
        int includingTax = dis.readInt(); // blocking
        System.out.println("Server replied  " + includingTax);
        int sleepTime = (int) (Math.random() * 1000 + 100);
        try
        {
          Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
        }
      }
    }
  }
}