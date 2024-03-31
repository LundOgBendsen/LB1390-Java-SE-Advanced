package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.nongeneric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class ObservableListTest {

	@Test
	public void testRegisterObserver() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverMandatory lom01 = new ListObserverMandatory();
		ListObserverMandatory lom02 = new ListObserverMandatory();
		ol.registerObserver(lom01);
		ol.registerObserver(lom02);
		ol.add("a string");
		assertTrue(lom01.success);
		assertTrue(lom02.success);
	}

	@Test
	public void testAddObject() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverCounter loc01 = new ListObserverCounter();
		ol.registerObserver(loc01);
		ol.add("a string");
		assertEquals(loc01.count, 1);
		ol.add("another string");
		assertEquals(loc01.count, 2);
	}

	@Test
	public void testAddAllintCollection() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverCounter loc01 = new ListObserverCounter();
		ol.registerObserver(loc01);
		ol.addAll(0, new ArrayList<String>());
		assertEquals(loc01.count, 1);
	}

	@Test
	public void testClear() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverCounter loc01 = new ListObserverCounter();
		ol.registerObserver(loc01);
		ol.clear();
		assertEquals(loc01.count, 1);
	}

	@Test
	public void testContains() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverFail lof01 = new ListObserverFail();
		ol.registerObserver(lof01);
		ol.contains("hej");
	}

	@Test
	public void testRemoveint() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverCounter loc01 = new ListObserverCounter();
		ol.registerObserver(loc01);
		ol.add("1");
		ol.add("2");
		ol.remove(1);
		assertEquals(loc01.count, 3);
	}

	@Test
	public void testRemoveObject() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverCounter loc01 = new ListObserverCounter();
		ol.registerObserver(loc01);
		ol.add("1");
		ol.add("2");
		ol.remove("1");
		assertEquals(loc01.count, 3);
	}

	@Test
	public void testRemoveAll() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverCounter loc01 = new ListObserverCounter();
		ol.registerObserver(loc01);
		ol.add("1");
		ol.add("2");
		ol.removeAll(ol);
		assertEquals(loc01.count, 3);
	}

	@Test
	public void testSize() {
		ObservableList<String> ol = new ObservableList<String>(new ArrayList<String>());
		ListObserverFail lof01 = new ListObserverFail();
		ol.registerObserver(lof01);
		ol.size();
	}

	/**
	 * ListObserver that counts number of notifications
	 */
	class ListObserverCounter implements ListObserver {
		public int count = 0;

		@Override
		public void notifyListChanged() {
			count++;
		}
	}

	/**
	 * ListObserver that ought to be called, or else success==false
	 */
	class ListObserverMandatory implements ListObserver {
		public boolean success = false;

		@Override
		public void notifyListChanged() {
			success = true;
		}
	}

	/**
	 * ListObserver that ought not be called (calls fail())
	 */
	class ListObserverFail implements ListObserver {
		@Override
		public void notifyListChanged() {
			fail("This cannot be called!");
		}
	}
}
