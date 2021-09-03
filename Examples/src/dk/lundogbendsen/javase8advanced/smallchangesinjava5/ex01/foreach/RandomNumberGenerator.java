package dk.lundogbendsen.javase8advanced.smallchangesinjava5.ex01.foreach;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomNumberGenerator implements Iterable<Integer>
{

  private static Random random = new Random();
  int current;
  int lenght;

  public RandomNumberGenerator(final int lenght)
  {
    this.lenght = lenght;
  }

  @Override
  public Iterator<Integer> iterator()
  {
    return new RandomNumberIterator();
  }

  private class RandomNumberIterator implements Iterator<Integer>
  {

    @Override
    public boolean hasNext()
    {
      return current < lenght;
    }

    @Override
    public Integer next()
    {
      if (current < lenght)
      {
        current++;
        return random.nextInt();
      }
      else
      {
        throw new NoSuchElementException();
      }
    }

    @Override
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}
