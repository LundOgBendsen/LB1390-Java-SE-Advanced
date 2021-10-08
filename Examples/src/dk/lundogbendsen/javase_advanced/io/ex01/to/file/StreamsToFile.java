package dk.lundogbendsen.javase_advanced.io.ex01.to.file;

/*
 * Viser hvordan man kan oprette streams til en fil.
 */

import java.io.*;

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