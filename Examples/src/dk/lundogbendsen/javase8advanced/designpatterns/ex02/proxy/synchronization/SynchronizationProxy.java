package dk.lundogbendsen.javase8advanced.designpatterns.ex02.proxy.synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizationProxy
{

  @SuppressWarnings({ "unused" })
  public static void main(String[] args)
  {

    // not synchronized
    ArrayList<String> list = new ArrayList<>();

    // synchronized
    List<String> syncList = Collections.synchronizedList(list);
  }
}
