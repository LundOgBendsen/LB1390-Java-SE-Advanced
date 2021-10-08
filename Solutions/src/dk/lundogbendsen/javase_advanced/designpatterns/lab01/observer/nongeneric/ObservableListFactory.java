package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.nongeneric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservableListFactory<T> {
	private static Map<List<?>, ObservableList<?>> observableLists = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> ObservableList<T> getInstanceTheProxyWay(final List<T> al) {
		if (!observableLists.containsKey(al)) {
			observableLists.put(al, new ObservableList<T>(al));
		}
		return (ObservableList<T>) observableLists.get(al);
	}

	public static <T> ObservableList<T> getInstanceTheDecoratorWay(final List<T> al) {
		return getInstanceTheProxyWay(al);
	}
}
