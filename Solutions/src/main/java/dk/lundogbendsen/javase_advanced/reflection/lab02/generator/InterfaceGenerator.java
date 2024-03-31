package dk.lundogbendsen.javase_advanced.reflection.lab02.generator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InterfaceGenerator {
	private static final String START = "public interface ";

	public static void main(String[] args) {

		if (args.length == 0) {
			args = new String[] { "java.util.ArrayList" };
		}

		String classname = args[0];

		String classDef = START;
		try {
			Class<?> c = Class.forName(classname);
			Method[] methods = c.getDeclaredMethods();

			classDef += c.getSimpleName() + "Interface { \n";

			for (Method m : methods) {
				// process only public and nonstatic methods
				if (!Modifier.isStatic(m.getModifiers()) && Modifier.isPublic(m.getModifiers())) {
					Class<?> rt = m.getReturnType();
					classDef += "  public " + getType(rt);
					classDef += " " + m.getName();
					classDef += "( ";
					Class<?>[] params = m.getParameterTypes();
					for (int j = 0; j < params.length; j++) {
						classDef += getType(params[j]) + " p" + j;
						classDef += (j < params.length - 1 ? ", " : " ");
					}
					classDef += ");\n";
				}
			}
			classDef += "}";
			System.out.println(classDef);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static String getType(final Class<?> c) {
		if (c.isArray()) {
			return removeDefaultPackage(c.getName().substring(2, c.getName().length() - 1)) + "[]";
		} else {
			return removeDefaultPackage(c.getName());
		}

	}

	private static String removeDefaultPackage(final String substring) {
		if (substring.startsWith("java.lang."))
			return substring.substring(10);
		else
			return substring;
	}
}
