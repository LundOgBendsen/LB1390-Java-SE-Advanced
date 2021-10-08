package dk.lundogbendsen.javase_advanced.io.lab03.writerfork;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterForkTest {

	public static void main(final String[] args) throws IOException {

		try (FileWriter fw01 = new FileWriter("file01.txt"); FileWriter fw02 = new FileWriter("file02.txt");) {
			WriterFork wf = new WriterFork(fw01, fw02);

			try (PrintWriter pw = new PrintWriter(wf);) {
				pw.println("Dette er første linie");
				pw.println("Dette er anden linie");
				pw.println("Dette er tredje linie");

				pw.flush();

				System.out.println("Finished writing 3 lines to 2 files.");
			}
		}
	}
}
