package dk.lundogbendsen.javase8advanced.designpatterns.lab01.observer.nongeneric;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObservableList<T> implements List<T>
{

  private Set<ListObserver> observers = new HashSet<>();
  private List<T> list;
  private Logger log = Logger.getLogger("dk.lundogbendsen.dp.exercises.solution.observable");

  ObservableList(final List<T> l)
  {
    log.log(Level.INFO, "ObservableList created");
    this.list = l;
  }

  private void notifyListeners()
  {
    log.log(Level.INFO, "Starting notification of listeners");
    for (ListObserver obs : observers)
    {
      obs.notifyListChanged();
    }
    log.log(Level.INFO, "Ending notification of listeners");
  }

  public void registerObserver(final ListObserver lo)
  {
    log.log(Level.INFO, "Registering observer");
    this.observers.add(lo);
  }

  @Override
  public void add(final int arg0, final T arg1)
  {
    log.log(Level.INFO, "add(int, Obj) invoked");
    list.add(arg0, arg1);
    this.notifyListeners();
  }

  @Override
  public boolean add(final T arg0)
  {
    log.log(Level.INFO, "add(Obj) invoked");
    boolean changed = list.add(arg0);
    this.notifyListeners();
    return changed;
  }

  @Override
  public boolean addAll(final Collection<? extends T> arg0)
  {
    log.log(Level.INFO, "addAll(collection) invoked");
    boolean changed = list.addAll(arg0);
    this.notifyListeners();
    return changed;
  }

  @Override
  public boolean addAll(final int arg0, final Collection<? extends T> arg1)
  {
    log.log(Level.INFO, "addAll(int, collection) invoked");
    boolean changed = list.addAll(arg0, arg1);
    this.notifyListeners();
    return changed;
  }

  @Override
  public void clear()
  {
    log.log(Level.INFO, "clear() invoked");
    list.clear();
    this.notifyListeners();
  }

  @Override
  public boolean contains(final Object arg0)
  {
    log.log(Level.INFO, "contains() invoked");
    return list.contains(arg0);
  }

  @Override
  public boolean containsAll(final Collection<?> arg0)
  {
    log.log(Level.INFO, "containsAll() invoked");
    return list.containsAll(arg0);
  }

  @Override
  public T get(final int arg0)
  {
    log.log(Level.INFO, "get(int) invoked");
    return list.get(arg0);
  }

  @Override
  public int indexOf(final Object arg0)
  {
    log.log(Level.INFO, "indexOf(Collection) invoked");
    return list.indexOf(arg0);
  }

  @Override
  public boolean isEmpty()
  {
    log.log(Level.INFO, "isEmpty() Invoked");
    return list.isEmpty();
  }

  @Override
  public Iterator<T> iterator()
  {
    log.log(Level.INFO, "iterator() invoked");
    return list.iterator();
  }

  @Override
  public int lastIndexOf(final Object arg0)
  {
    log.log(Level.INFO, "lastIndexOf(Object) invoked");
    return list.lastIndexOf(arg0);
  }

  @Override
  public ListIterator<T> listIterator()
  {
    log.log(Level.INFO, "listIterator() invoked");
    return list.listIterator();
  }

  @Override
  public ListIterator<T> listIterator(final int arg0)
  {
    log.log(Level.INFO, "listIterator(int) invoked");
    return list.listIterator(arg0);
  }

  @Override
  public T remove(final int arg0)
  {
    log.log(Level.INFO, "remove(int) invoked");
    T res = list.remove(arg0);
    this.notifyListeners();
    return res;
  }

  @Override
  public boolean remove(final Object arg0)
  {
    log.log(Level.INFO, "remove(Object) invoked");
    boolean changed = list.remove(arg0);
    if (changed) this.notifyListeners();
    return changed;
  }

  @Override
  public boolean removeAll(final Collection<?> arg0)
  {
    log.log(Level.INFO, "removeAll(collection) invoked");
    boolean changed = list.removeAll(arg0);
    if (changed) this.notifyListeners();
    return changed;
  }

  @Override
  public boolean retainAll(final Collection<?> arg0)
  {
    log.log(Level.INFO, "retainAll(collection) invoked");
    boolean changed = list.retainAll(arg0);
    if (changed) this.notifyListeners();
    return changed;
  }

  @Override
  public T set(final int arg0, final T arg1)
  {
    log.log(Level.INFO, "set(int, Object) invoked");
    T res = list.set(arg0, arg1);
    this.notifyListeners();
    return res;
  }

  @Override
  public int size()
  {
    log.log(Level.INFO, "size() invoked");
    return list.size();
  }

  @Override
  public List<T> subList(final int arg0, final int arg1)
  {
    log.log(Level.INFO, "subList(int, int) invoked");
    return list.subList(arg0, arg1);
  }

  @Override
  public Object[] toArray()
  {
    log.log(Level.INFO, "toArray() invoked");
    return list.toArray();
  }

  @SuppressWarnings("unchecked")
  @Override
  public Object[] toArray(final Object[] arg0)
  {
    log.log(Level.INFO, "toArray(T[]) invoked");
    return list.toArray(arg0);
  }

}
