/*
 * Viser dynamisk indlæsning af klasse og instantiering af denne.
 *
 * Udkommenter på skift linie 18, 19 og 20.
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
