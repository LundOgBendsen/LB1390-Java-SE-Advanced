package dk.lundogbendsen.javase8advanced.generics.lab02.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionUtil
{

  public static <T extends CharSequence> Collection<T> getLongWords(final Collection<T> col)
  {
    Iterator<T> iter = col.iterator();
    ArrayList<T> list = new ArrayList<T>();
    while (iter.hasNext())
    {
      T elem = iter.next();
      if (elem.length() > 6) list.add(elem);
    }
    return list;
  }
}
