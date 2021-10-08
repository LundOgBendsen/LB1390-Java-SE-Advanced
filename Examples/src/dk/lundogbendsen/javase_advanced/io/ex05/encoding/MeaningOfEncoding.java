package dk.lundogbendsen.javase_advanced.io.ex05.encoding;

/*
 * Viser hvad der sker hvis man ikke bruger samme tekst-encoding
 * til både skrivning og læsning af filer...
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

		// Bruges bare default PrintWriter fås encoding Cp1252 på Win
		try (OutputStreamWriter fileWriter = new FileWriter("Message_in_default.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
		}

		// Svarer principielt til ovenstående NÅR VI ER PÅ WIN
		try (FileOutputStream fileOutputStream = new FileOutputStream("Message_in_Cp1252.txt");
				OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutputStream, "Cp1252");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
			printWriter.close();
		}

		// En måde at gemme Uni-code på, der ofte kun fylder 1 byte pr. tegn
		try (FileOutputStream fileOutputStream = new FileOutputStream("Message_in_UTF-8.txt");
				OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
			printWriter.close();
		}

		// En 'normal' måde at gemme Uni-code på, hvor hvert tegn fylder 2 byte
		// Tegn holdes også i 16-bits unicode internt i Java
		try (FileOutputStream fileOutputStream = new FileOutputStream("Message_in_UTF-16.txt");
				OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
				PrintWriter printWriter = new PrintWriter(fileWriter);) {
			printWriter.print(message);
			printWriter.flush();
			printWriter.close();
		}
	}

}
