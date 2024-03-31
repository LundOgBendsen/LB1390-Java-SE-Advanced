package dk.lundogbendsen.javase_advanced.io.ex05.filesystem;

/*
 * Illustrates working with drives/roots and libraries in Java using the File class.
 * Including what relative paths mean.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WorkingWithDirectories {
	public static void main(String[] args) throws IOException {
		// Creates reference that makes it easier to make System.out.println calls
		try (PrintWriter o = new PrintWriter(new OutputStreamWriter(System.out));) {

			o.println("==|| 1 ||=======================");
			// We create a File instance that refers relatively to the current folder.
			// Notice that . means current directory, while .. is current's parent.
			File relativStiTilNuværendeMappe = new File(".");
			// We quickly convert it to an absolute reference
			File nuværendeMappe = null;
			try {
				nuværendeMappe = relativStiTilNuværendeMappe.getCanonicalFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			// Let's print current directory in both relative and absolute form
			o.print("relativStiTilNuværendeMappe:   ");
			o.println("[" + relativStiTilNuværendeMappe + "]");
			o.print("nuværendeMappe (absolut):   ");
			o.println("[" + nuværendeMappe + "]");

			o.println("==|| 2 ||=======================");
			// Now let's look at a few different ways to get at the C:\ drive
			// Method (1)
			File rodMappe = nuværendeMappe;
			while (rodMappe.getParent() != null) {
				rodMappe = rodMappe.getParentFile();
			}
			o.println("Rod-stien fundet fra start-mappe hva. getParent: " + rodMappe);

			// Method (2)
			File cDrev1 = new File("C:\\"); // remember \ is escaped inside a String with \\
			o.println("Rod-stien fundet vha. dens direkte navn: " + cDrev1);

			// Method (3)
			o.print("Alle rod-stier på systemet (vha. listRoots)");
			File[] roots = File.listRoots();
			for (int n = 0; n < roots.length; n++) {
				o.print("   " + roots[n]);
			}
			o.println();

			o.println("==|| 3 ||=======================");
			// We create new directory in current directory, print all files in current folder
			// and finally delete the folder we created again.
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