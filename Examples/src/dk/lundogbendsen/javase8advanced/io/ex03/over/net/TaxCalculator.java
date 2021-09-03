package dk.lundogbendsen.javase8advanced.io.ex03.over.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TaxCalculator extends Thread
{
  Socket socket;
  DataOutputStream dos;
  DataInputStream dis;

  TaxCalculator(Socket socket) throws IOException
  {
    this.socket = socket;
    OutputStream os = socket.getOutputStream();
    dos = new DataOutputStream(os);
    InputStream is = socket.getInputStream();
    dis = new DataInputStream(is);
    this.start();
  }

  @Override
  public void run()
  {
    while (true)
    {
      try
      {
        int notIncludingTax = dis.readInt(); // blocking
        int includingTax = (int) (notIncludingTax * 1.25);
        dos.writeInt(includingTax);
      }
      catch (IOException e)
      {
        try
        {
          socket.close();
        }
        catch (IOException e2)
        {
        }
        System.out.println("A client disconnected from the server");
        return;
      }
    }
  }
}