package dk.lundogbendsen.javase_advanced.io.ex06.filesystem;

/*
 * Illustrerer arbejde med drev/roots og biblioteker i Java vha. File-klassen.
 * Herunder hvad relative stier betyder.
 */
import java.io.*;

public class WorkingWithDirectories {
	public static void main(String[] args) throws IOException {
		// Laver reference som gør det lettere at lave System.out.println-kald
		try (PrintWriter o = new PrintWriter(new OutputStreamWriter(System.out));) {

			o.println("==|| 1 ||=======================");
			// Vi laver en File-instans der på relativ vis henviser til nuværende mappe.
			// Bemærk at . betyder nuværende mappe, mens .. er nuværendes parent.
			File relativStiTilNuværendeMappe = new File(".");
			// Vi omformer den hurtigt til en absolut henvisning
			File nuværendeMappe = null;
			try {
				nuværendeMappe = relativStiTilNuværendeMappe.getCanonicalFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			// Lad os udskrive nuværende mappe både i relativ og absolut form
			o.print("relativStiTilNuværendeMappe:   ");
			o.println("[" + relativStiTilNuværendeMappe + "]");
			o.print("nuværendeMappe (absolut):   ");
			o.println("[" + nuværendeMappe + "]");

			o.println("==|| 2 ||=======================");
			// Lad os nu se på et par forskellige måder at få fat i C:\-drevet på
			// Metode (1)
			File rodMappe = nuværendeMappe;
			while (rodMappe.getParent() != null) {
				rodMappe = rodMappe.getParentFile();
			}
			o.println("Rod-stien fundet fra start-mappe hva. getParent: " + rodMappe);

			// Metode (2)
			File cDrev1 = new File("C:\\"); // husk \ laves inden i en String med \\
			o.println("Rod-stien fundet vha. dens direkte navn: " + cDrev1);

			// Metode (3)
			o.print("Alle rod-stier på systemet (vha. listRoots)");
			File[] roots = File.listRoots();
			for (int n = 0; n < roots.length; n++) {
				o.print("   " + roots[n]);
			}
			o.println();

			o.println("==|| 3 ||=======================");
			// Vi laver ny mappe i nuværende, udskriver alle i nuværende
			// og sletter til sidst mappen vi lavede igen.
			String newFolderPathName = nuværendeMappe.getCanonicalPath();
			newFolderPathName += File.separator + "hello";
			File subDirectoryHello = new File(newFolderPathName);
			subDirectoryHello.mkdir();
			File[] directoryContent = nuværendeMappe.listFiles();
			for (int n = 0; n < directoryContent.length; n++) {
				o.print(directoryContent[n]);
				o.println(" is dir? " + directoryContent[n].isDirectory());
			}
			subDirectoryHello.delete();

			o.println();
			o.println();
			o.println("==|| 4 ||=======================");
			String packageName = WorkingWithDirectories.class.getPackage().getName().replace('.', File.separatorChar);
			File thisSourceFile = new File("." + File.separator + "src" + File.separator + packageName + File.separator
					+ "WorkingWithDirectories.java");
			try (FileReader fr = new FileReader(thisSourceFile); BufferedReader br = new BufferedReader(fr);) {
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					} else {
						o.println(line);
					}
				}
			}

			o.flush();
		}
	}
}