package dk.lundogbendsen.javase_advanced.io.ex03.over.net;

/*
 * See description in the associated StreamsOverNetworkServer.
  * NB: Start the server first.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class StreamsOverNetworkClient {
	public static void main(String[] args) throws Exception {
		// The server listens on port 3456.
		// We just use localhost, but could
		// use an ip number for another computer.
		// You can check a computer's IP number
		// using the ipconfig command in dos/cmd.
		try (Socket socket = new Socket("localhost", 3456);) {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			int howManyRequests = (int) (Math.random() * 30 + 20);
			for (int n = 0; n < howManyRequests; n++) {
				int notIncludingTax = (int) (Math.random() * 5000 + 1000);
				dos.writeInt(notIncludingTax);
				System.out.println("Asked server to calculate tax for " + notIncludingTax);
				int includingTax = dis.readInt(); // blocking
				System.out.println("Server replied  " + includingTax);
				int sleepTime = (int) (Math.random() * 1000 + 100);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}