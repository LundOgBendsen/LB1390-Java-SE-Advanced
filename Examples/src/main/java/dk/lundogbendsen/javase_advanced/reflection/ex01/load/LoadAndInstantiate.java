/*
  * Shows dynamic loading of class and its instantiation.
  *
  * Comment out lines 18, 19 and 20 alternately.
  */

package dk.lundogbendsen.javase_advanced.reflection.ex01.load;

public class LoadAndInstantiate {

	public static void main(final String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String packageName = LoadAndInstantiate.class.getPackage().getName();

		tryLoading(packageName + ".ClassOne");
		tryLoading(packageName + ".ClassTwo");
		tryLoading(packageName + ".NonExistingClass");
	}

	@SuppressWarnings("deprecation")
	private static void tryLoading(final String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> loadedClass = Class.forName(name);

		Object instanceOfLoadedClass = loadedClass.newInstance();

		System.out.println("Class: " + name + " -> " + instanceOfLoadedClass);
	}
}
