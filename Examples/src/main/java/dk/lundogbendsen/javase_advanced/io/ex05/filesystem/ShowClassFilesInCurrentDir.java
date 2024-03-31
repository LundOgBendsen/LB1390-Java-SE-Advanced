package dk.lundogbendsen.javase_advanced.io.ex05.filesystem;

/*
 * Shows how to create a File filter using an anonymous inner class.
 */
import java.io.File;
import java.io.FilenameFilter;

public class ShowClassFilesInCurrentDir {
	public static void main(final String[] args) {

		String packageName = ShowClassFilesInCurrentDir.class.getPackage().getName().replace('.', File.separatorChar);
		File currentDir = new File("." + File.separatorChar + "bin" + File.separatorChar + packageName);

		String[] classFiles = currentDir.list(new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				return name.endsWith(".class");
			}
		});

		System.out.println("List of class files in current dir (Old School): ");
		for (int n = 0; n < classFiles.length; n++) {
			System.out.println("  " + classFiles[n]);
		}

		String[] classFilesLambda = currentDir.list((dir, name) -> name.endsWith(".class"));

		System.out.println("List of class files in current dir (using lambda): ");
		for (int n = 0; n < classFilesLambda.length; n++) {
			System.out.println("  " + classFilesLambda[n]);
		}
	}
}