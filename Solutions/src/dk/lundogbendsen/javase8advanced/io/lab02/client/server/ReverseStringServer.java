package dk.lundogbendsen.javase8advanced.io.lab02.client.server;

/*
 * This program demonstrates how to make a simple multi threaded server.
 * The server reads a string from an object stream, reverses this string (ABC->CBA)
 * and returns it to the client.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @author Jakob Bendsen
 *         We don't want the server to block, so we let it extend Thread in order to give it its own
 *         thread of execution.
 */
public class ReverseStringServer extends Thread
{

  /**
   * This is the method being executed be the server thread. It listens on port
   * 3456 using a server socket and instantiates and starts a new Clienthandler
   * when a client makes a request.
   */
  @Override
  public void run()
  {
    try (ServerSocket ss = new ServerSocket(3456);)
    {
      while (true)
      {
        //blocking call - wait for client connections
        final Socket s = ss.accept();
        //create a new client handler to serve the client
        new ClientHandler(s);
      }
    }
    catch (IOException e)
    {
      System.out.println("SimpleServer: IOException" + e);
    }
  }

  //main method for starting the server
  public static void main(final String[] args)
  {
    ReverseStringServer ss = new ReverseStringServer();
    ss.start();
  }

  /**
   * This is a non-anonymous inner class. Instances of this class are used to
   * serve clients, and the class therefore extends Thread, so that each instance
   * executes has its own thread. This means that many ClientHandlers can execute
   * simultanously thus making the server multithreaded.
   *
   * The ClientHandler creates objectstreams from the Socket it recieves as a parameter
   * on creation. It reads a String object from the client, reverses the string and
   * writes it back to the client.
   */
  class ClientHandler extends Thread
  {
    private Socket s;

    ClientHandler(final Socket s)
    {
      this.s = s;
      //start the thread (i.e. the run()-method is being called)
      start();
    }

    @Override
    public void run()
    {
      try
      {

        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        String obj = (String) ois.readObject();

        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        //reverse string and write it back to the client
        oos.writeObject(reverse(obj));
      }
      catch (Exception e)
      {
        System.out.println("Exception in Clienthandler.run()" + e);

      }
    }

    /**
     * Returns a string that is the reverse of the parameter.
     * An example: reverse("Missetand") -> "dnatessiM"
     */
    private String reverse(final String s)
    {
      return (s.length() > 1 ? reverse(s.substring(1)) + s.charAt(0) : s);
    }
  }

}
