package dk.lundogbendsen.javase_advanced.lambda.ex01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WithLambda
{
  private static int retrogradeCompareTo(final String o1, final String o2)
  {
    int i1 = o1.length();
    int i2 = o2.length();
    while (--i1 >= 0 && --i2 >= 0 && o1.charAt(i1) == o2.charAt(i2))
    {
    }

    if (i1 < 0 && i2 < 0) return 0;
    if (i1 < 0) return -1;
    if (i2 < 0) return +1;

    return o1.charAt(i1) - o2.charAt(i2);
  }

  public static void main(final String[] args)
  {
    List<String> list = Arrays.asList("Merkur", "Venus", "Jorden", "Mars", "Saturn", "Jupiter", "Uranus", "Neptun", "Pluto?");

    System.out.println("Uden lambda-udtryk:");

    Collections.sort(list, new Comparator<String>()
    {
      @Override
      public int compare(final String o1, final String o2)
      {
        return o1.compareTo(o2);
      }
    });
    System.out.println(list);

    Collections.sort(list, new Comparator<String>()
    {
      @Override
      public int compare(final String o1, final String o2)
      {
        return o2.compareTo(o1);
      }
    });
    System.out.println(list);

    Collections.sort(list, new Comparator<String>()
    {
      @Override
      public int compare(final String o1, final String o2)
      {
        return retrogradeCompareTo(o1, o2);
      }
    });
    System.out.println(list);

    System.out.println("Med lambda-udtryk:");

    Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
    System.out.println(list);

    Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
    System.out.println(list);

    Collections.sort(list, (o1, o2) -> retrogradeCompareTo(o1, o2));
    System.out.println(list);

    Collections.sort(list, (o1, o2) -> {
      int i1 = o1.length();
      int i2 = o2.length();
      while (--i1 >= 0 && --i2 >= 0 && o1.charAt(i1) == o2.charAt(i2))
      {
      }

      if (i1 < 0 && i2 < 0) return 0;
      if (i1 < 0) return -1;
      if (i2 < 0) return +1;

      return o1.charAt(i1) - o2.charAt(i2);
    });
    System.out.println(list);

  }

}
