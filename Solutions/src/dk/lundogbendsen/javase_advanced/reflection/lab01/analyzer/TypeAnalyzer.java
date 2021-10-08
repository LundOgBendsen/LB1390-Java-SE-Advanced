package dk.lundogbendsen.javase_advanced.reflection.lab01.analyzer;

public class TypeAnalyzer {

	public static void main(String[] args) {
		if (args.length == 0) {
			args = new String[] { "java.lang.Object" };
			// args = new String[] { "java.util.ArrayList" };
			// args = new String[] { "java.io.PrintWriter" };
		}

		String classname = args[0];

		try {
			Class<?> c = Class.forName(classname);
			System.out.println(getParentClassName(c));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static String getParentClassName(final Class<?> c) {
		if (c != Object.class) {
			return c.getName() + " => " + getParentClassName(c.getSuperclass());
		}
		return c.getName();
	}
}
