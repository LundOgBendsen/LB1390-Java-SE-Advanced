package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.nongeneric;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class ObservableListFactoryTest {
	@Test
	public void testGet() {
		ArrayList<String> al01 = new ArrayList<>();

		List<String> ol01 = ObservableListFactory.getInstanceTheProxyWay(al01);
		assertNotNull(ol01);
		List<String> ol02 = ObservableListFactory.getInstanceTheProxyWay(al01);
		assertSame(ol01, ol02);

		List<Integer> al02 = new LinkedList<Integer>();

		List<Integer> ol03 = ObservableListFactory.getInstanceTheProxyWay(al02);
		assertNotNull(ol03);

		List<Integer> ol04 = ObservableListFactory.getInstanceTheDecoratorWay(al02);
		assertNotNull(ol04);
		List<String> ol05 = ObservableListFactory.getInstanceTheDecoratorWay(al01);
		assertSame(ol04, ol05);

	}
}
