package dk.lundogbendsen.javase_advanced.io.ex01.to.file;

/*
 * Shows how to create streams to a file.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamsToFile {
	public static void main(String[] args) throws IOException {
		// OUTPUT TO File
		try (FileOutputStream fos = new FileOutputStream("uhhhh.dat");
				DataOutputStream dos = new DataOutputStream(fos);) {
			dos.writeInt(12);
		}

		// INPUT FROM File
		try (FileInputStream fis = new FileInputStream("uhhhh.dat"); DataInputStream dis = new DataInputStream(fis);) {
			int i = dis.readInt();
			System.out.println("Value read from File: " + i);
		}
	}
}