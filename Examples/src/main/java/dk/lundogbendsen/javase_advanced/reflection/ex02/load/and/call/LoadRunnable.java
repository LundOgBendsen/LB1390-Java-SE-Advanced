/*
  * Shows dynamic loading and execution of a Runnable class.
  */
package dk.lundogbendsen.javase_advanced.reflection.ex02.load.and.call;

public class LoadRunnable {

	public static void main(final String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		tryRunning("dk.lundogbendsen.javase_advanced.reflection.ex02.load.and.call.RunnableOne");
		tryRunning("dk.lundogbendsen.javase_advanced.reflection.ex02.load.and.call.RunnableTwo");
		tryRunning("dk.lundogbendsen.javase_advanced.reflection.ex02.load.and.call.RunnableThree");
	}

	@SuppressWarnings("deprecation")
	private static void tryRunning(final String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> loadedClass = Class.forName(name);
		Object instanceOfLoadedClass = loadedClass.newInstance();
		Runnable runnable = (Runnable) instanceOfLoadedClass;
		runnable.run();

		System.out.println();
	}
}
