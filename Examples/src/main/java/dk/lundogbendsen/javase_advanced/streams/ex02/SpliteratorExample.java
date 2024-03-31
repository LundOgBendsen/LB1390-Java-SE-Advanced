package dk.lundogbendsen.javase_advanced.streams.ex02;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class SpliteratorExample
{
  public static void main(final String[] args)
  {
    PrimitiveIterator.OfInt it = new PrimitiveIterator.OfInt()
    {
      private int value = 0;

      @Override
      public int nextInt()
      {
        return value++;
      }

      @Override
      public boolean hasNext()
      {
        return true;
      }
    };

    System.out.println("Spliterator");

    Spliterator.OfInt spliterator = Spliterators.spliteratorUnknownSize(it, Spliterator.DISTINCT | Spliterator.IMMUTABLE | Spliterator.ORDERED | Spliterator.SORTED);

    IntStream stream = StreamSupport.intStream(spliterator, false);
    stream.limit(10).forEach(System.out::println);

    
    
    System.out.println("Adding 2");
    
    Spliterator.OfInt spliterator2 = Spliterators.spliteratorUnknownSize(it, Spliterator.DISTINCT | Spliterator.IMMUTABLE | Spliterator.ORDERED | Spliterator.SORTED);
    
    IntStream stream2 = StreamSupport.intStream(spliterator2, false).map(n -> n + 2);
    stream2.limit(10).forEach(System.out::println);

  }
}
