package dk.lundogbendsen.javase_advanced.designpatterns.lab01.observer.generic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ObservableList<T> implements List<T> {

	private List<T> list;
	private Set<ListObserver> observers;

	public ObservableList(final List<T> list) {
		this.list = list;
		observers = new HashSet<ListObserver>();
	}

	private void notifyObservers() {
		for (ListObserver observer : observers) {
			observer.notifyListChanged();
		}
	}

	public boolean addObserver(final ListObserver observer) {
		return observers.add(observer);
	}

	public boolean removeObserver(final ListObserver observer) {
		notifyObservers();
		return observers.remove(observer);
	}

	@Override
	public void add(final int index, final T element) {
		notifyObservers();
		list.add(index, element);
	}

	@Override
	public boolean add(final T o) {
		notifyObservers();
		return list.add(o);
	}

	@Override
	public boolean addAll(final Collection<? extends T> c) {
		notifyObservers();
		return list.addAll(c);
	}

	@Override
	public boolean addAll(final int index, final Collection<? extends T> c) {
		notifyObservers();
		return list.addAll(index, c);
	}

	@Override
	public void clear() {
		notifyObservers();
		list.clear();
	}

	@Override
	public boolean contains(final Object o) {
		return list.contains(o);
	}

	@Override
	public boolean containsAll(final Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean equals(final Object o) {
		return list.equals(o);
	}

	@Override
	public T get(final int index) {
		return list.get(index);
	}

	@Override
	public int hashCode() {
		return list.hashCode();
	}

	@Override
	public int indexOf(final Object o) {
		return list.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public int lastIndexOf(final Object o) {
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(final int index) {
		return list.listIterator(index);
	}

	@Override
	public T remove(final int index) {
		notifyObservers();
		return list.remove(index);
	}

	@Override
	public boolean remove(final Object o) {
		notifyObservers();
		return list.remove(o);
	}

	@Override
	public boolean removeAll(final Collection<?> c) {
		notifyObservers();
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(final Collection<?> c) {
		notifyObservers();
		return list.retainAll(c);
	}

	@Override
	public T set(final int index, final T element) {
		notifyObservers();
		return list.set(index, element);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public List<T> subList(final int fromIndex, final int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <V> V[] toArray(final V[] a) {
		return list.toArray(a);
	}
}
