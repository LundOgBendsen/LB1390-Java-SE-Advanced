package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.generic;

import java.util.HashMap;
import java.util.List;

public class ObservableListFactory {
	private static HashMap<List<?>, ObservableList<?>> myMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> ObservableList<T> getObservableList(final List<T> list) {
		ObservableList<?> singleton = null;

		if (myMap.containsKey(list)) {
			singleton = myMap.get(list);
		} else {
			singleton = new ObservableList<T>(list);
			myMap.put(list, singleton);
		}

		return (ObservableList<T>) singleton;
	}
}
