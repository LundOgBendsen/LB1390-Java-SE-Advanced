package dk.lundogbendsen.javase_advanced.reflection.ex05.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UsingMethods {
	public static void main(final String[] args) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class<Calculator> calculatorClass = Calculator.class;

		// obtains all public methods - including inherited ones

		Method[] methods = calculatorClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}

		System.out.println();

		// provides all methods - not inherited

		Method[] declaredMethods = calculatorClass.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			System.out.println(declaredMethods[i]);
		}

		System.out.println();

		// Obtains reference to the method Calculator.add(int a, int b)
		Class<?>[] twoInts = new Class[] { int.class, int.class };
		Method addIntsMethod = calculatorClass.getDeclaredMethod("add", twoInts);
		System.out.println(addIntsMethod);

		System.out.println();

		// Obtains reference to the method Calculator.add(int[] ints)
		Class<?>[] intArray = new Class[] { int[].class };
		Method addIntArrayMethod = calculatorClass.getDeclaredMethod("add", intArray);

		// Makes it possible to invoke the method even if it is private
		addIntArrayMethod.setAccessible(true);
		System.out.println(addIntArrayMethod);

		System.out.println();

		// Uses the two methods on an object

		Calculator calculator = new Calculator();

		// create params matching add(int, int)
		Object[] twoIntValues = new Object[] { Integer.valueOf(12), Integer.valueOf(3) };

		// invoke add(int, int)
		Object result = addIntsMethod.invoke(calculator, twoIntValues);
		int resultAsInt = ((Integer) result).intValue();
		System.out.println("Result of add(12, 3) is " + resultAsInt + " (expected " + 15 + ")");

		System.out.println();

		// create params matching add(int[])
		Object[] intArrayValue = new Object[] { new int[] { 1, 4, 2, 3 } };

		// invoke add(int[])
		Object result2 = addIntArrayMethod.invoke(calculator, intArrayValue);
		int resultAsInt2 = ((Integer) result2).intValue();
		System.out.println("Result of add(int[]{1, 4, 2, 3}) is " + resultAsInt2 + " (expected " + 10 + ")");

	}
}
