package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.nongeneric;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for dk.lundogbendsen.dp.exercises.solution.observablelist");
		suite.addTest(new TestSuite(ObservableListTest.class));
		suite.addTest(new TestSuite(ObservableListFactoryTest.class));
		return suite;
	}
}
