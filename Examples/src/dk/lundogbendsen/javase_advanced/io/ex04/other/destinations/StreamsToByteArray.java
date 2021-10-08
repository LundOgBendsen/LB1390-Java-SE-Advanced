package dk.lundogbendsen.javase_advanced.io.ex04.other.destinations;

/*
 * Viser hvordan man kan lave streams til programmets
 * egen hukommelse - her i form af et byte[ ]
 */
import java.io.*;

public class StreamsToByteArray {
	public static void main(String[] args) throws IOException {
		// OUTPUT TO byte[ ]
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(12);

		byte[] byteArray = baos.toByteArray();
		System.out.println("Number of bytes in the array: " + byteArray.length);

		// INPUT FROM byte[ ]
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		DataInputStream dis = new DataInputStream(bais);
		int i = dis.readInt();

		System.out.println("Value read from byte[ ]: " + i);
	}
}