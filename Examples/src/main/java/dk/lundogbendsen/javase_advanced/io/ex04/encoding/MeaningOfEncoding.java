package dk.lundogbendsen.javase_advanced.io.ex04.encoding;

/*
 * Shows what happens if you do not use the same text encoding
 * for both writing and reading files...
 */
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MeaningOfEncoding {

	public static void main(final String[] args) throws Exception {
		String message = "";
		message += "Hej med dig \n";
		message += 12.45 + "\n";
		message += "æøåÆØÅ";

		// Just use the default PrintWriter encoding (Cp1252 on Win)
		try (OutputStreamWriter fileWriter = new FileWriter("Message_in_default.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
		}

		// Corresponds in principle to the above WHEN WE ARE ON WIN
		try (FileOutputStream fileOutputStream = new FileOutputStream("Message_in_Cp1252.txt");
				OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutputStream, "Cp1252");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
			printWriter.close();
		}

		// A way to store Uni-code that often takes up only 1 byte per sign
		try (FileOutputStream fileOutputStream = new FileOutputStream("Message_in_UTF-8.txt");
				OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
			printWriter.close();
		}

		// A 'normal' way of storing Uni-code, where each character occupies 2 bytes
		// Characters are also held as 16-bit unicode internally in Java
		try (FileOutputStream fileOutputStream = new FileOutputStream("Message_in_UTF-16.txt");
				OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
			printWriter.close();
		}
	}

}
