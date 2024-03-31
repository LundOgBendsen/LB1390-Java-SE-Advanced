package dk.lundogbendsen.javase_advanced.io.ex03.over.net;

/*
 * A server program that calculates VAT for a network client.
 * See also the associated StreamsOverNetworkClient.
 * NB: Start the server before the clients.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamsOverNetworkServer {
	public static void main(final String[] args) throws IOException {
		// listening on port 3456
		try (ServerSocket serverSocket = new ServerSocket(3456);) {
			System.out.println("Super Duper Tax Calculating Server is running");
			while (true) {
				Socket socket = serverSocket.accept(); // blocking
				System.out.println("A client connected to the server");
				new TaxCalculator(socket);
			}
		}
	}
}