package dk.lundogbendsen.javase8advanced.io.ex03.over.net;

/*
 * Et serverprogram der beregner moms for en netværksklient.
 * Se også den tilhørende StreamsOverNetworkClient.
 * NB: Start serveren før klienterne.
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamsOverNetworkServer {
	public static void main(final String[] args) throws IOException {
		// lytter på port 3456
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