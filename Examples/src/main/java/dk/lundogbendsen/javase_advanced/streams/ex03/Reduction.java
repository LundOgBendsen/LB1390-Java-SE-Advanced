package dk.lundogbendsen.javase_advanced.streams.ex03;

import java.time.Duration;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduction
{
  public static void main(final String[] args)
  {

    //called reduce() and collect(), as well as multiple specialized reduction forms such as sum(), max(), or count().

    System.out.println("reduce example:");

    IntStream s = IntStream.rangeClosed(1, 100);
    System.out.println(s.reduce(0, (x, y) -> x + y));

    
    
    System.out.println("collect example:");
    int N = 10000;

    Random ran1 = new Random(119L);
    Stream<String> ss1 = Stream.generate(() -> "" + ran1.nextInt()).limit(N);
    
    Duration d1 = TimingUtil.time("reduce", (t) ->
    {
      System.out.println(t+":"+ss1.reduce("", String::concat).length());
    });
    System.out.println(d1);
    
    Random ran2 = new Random(119L);
    Stream<String> ss2 = Stream.generate(() -> "" + ran2.nextInt()).limit(N);

    Duration d2 = TimingUtil.time("collect", (t) ->
    {
      StringBuilder b = ss2.collect(() -> new StringBuilder(), (c, e) -> c.append(e), (c1, c2) -> c1.append(c2));
      System.out.println(t+":"+b.toString().length());
    });
    System.out.println(d2);
  }
}
