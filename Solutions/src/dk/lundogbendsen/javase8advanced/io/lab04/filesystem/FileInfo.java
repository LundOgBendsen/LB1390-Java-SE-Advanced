package dk.lundogbendsen.javase8advanced.io.lab04.filesystem;

import java.io.File;
import java.io.FileFilter;

public class FileInfo {

	private static int counter, size;

	public static void main(final String[] args) {
		if (args.length == 0)
			throw new IllegalArgumentException("Der SKAL sendes en sti med til programmet");

		File file = new File(args[0]);
		if (!file.exists())
			throw new IllegalArgumentException("Filen: " + args[0] + " eksisterer ikke!!");
		if (!file.isDirectory())
			throw new IllegalArgumentException("Filen: " + args[0] + " er ikke en mappe!!");

		// Opgave A
		System.out.println("Opgave A");
		fileInFolder(file);

		// Opgave B
		System.out.println("Opgave B");
		fileAndSizeInFolder(file);

		// Opgave C
		System.out.println("Opgave C");
		MyFileFilter filter = new MyFileFilter(getTypeToFilter(args));
		specialFilesInFolder(file, filter);

		// Opgave D
		// Vi genbruger filter
		boolean recursive = getRecursive(args);
		if (recursive) {
			System.out.println("Opgave D");
			filter.includeDirectories(true);
			specialFilesInFolderRecursive(file, filter);
			System.out.println(file.getAbsolutePath() + " contains " + counter + " files of type '" + filter.getType()
					+ "' with a total size of " + size + " bytes.\n");

		}
	}

	private static void specialFilesInFolderRecursive(final File file, final MyFileFilter filter) {
		File[] files = file.listFiles(filter);
		for (File f : files) {
			if (f.isFile()) {
				size += f.length();
				counter++;
			} else if (f.isDirectory()) {
				specialFilesInFolderRecursive(f, filter);
			}
		}
	}

	private static void specialFilesInFolder(final File file, final MyFileFilter filter) {
		File[] files = file.listFiles(filter);
		int counter = 0;
		for (File f : files) {
			counter += f.length();
		}
		System.out.println(file.getAbsolutePath() + " contains " + files.length + " files of type '" + filter.getType()
				+ "' with a total size of " + counter + " bytes.\n");
	}

	private static boolean getRecursive(final String[] args) {
		for (int i = 0; i < args.length; i++)
			if (args[i].equalsIgnoreCase("-recursive"))
				return true;
		return false;
	}

	private static String getTypeToFilter(final String[] args) {
		for (int i = 0; i < args.length; i++)
			if (args[i].equalsIgnoreCase("-type") && i < args.length - 1)
				return args[i + 1];
		return null;
	}

	private static void fileInFolder(final File file) {
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(final File pathname) {
				return pathname.isFile();
			}
		});
		System.out.println(file.getAbsolutePath() + " contains " + files.length + " files\n");
	}

	private static void fileAndSizeInFolder(final File file) {
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(final File pathname) {
				return pathname.isFile();
			}
		});
		int counter = 0;
		for (File f : files) {
			counter += f.length();
		}
		System.out.println(file.getAbsolutePath() + " contains " + files.length + " files with" + " a total size of "
				+ counter + " bytes.\n");
	}
}