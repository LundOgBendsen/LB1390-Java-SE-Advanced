package dk.lundogbendsen.javase_advanced.io.lab02.client.server;

/*
 * This program shows how to connect to a java server. *
 */

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @version 1.0
 * @author Jakob Bendsen
 *
 */
public class ReverseStringClient {

	public static void main(final String[] args) {
		try (Socket s = new Socket("localhost", 3456);

				OutputStream os = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);

				InputStream is = s.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);) {
			oos.writeObject("this is a test");

			System.out.println(ois.readObject());
		} catch (Exception e) {
			System.out.println("Failure...!");
		}

	}
}
