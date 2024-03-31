package dk.lundogbendsen.javase_advanced.streams.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams
{
  public static void main(final String[] args)
  {
    System.out.println("Making a stream from values");

    Stream<Integer> streamOfValues = Stream.of(1, 2, 3, 4, 5);
    streamOfValues.forEach(System.out::println);

    
    System.out.println("Making a stream from array");

    Stream<Integer> streamOfArray = Stream.of(new Integer[] { 1, 2, 3, 4, 5 });
    streamOfArray.forEach(System.out::println);

    
    System.out.println("Making a stream from list");

    List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    Stream<Integer> streamOfList = list.stream();
    streamOfList.forEach(System.out::println);

    
    System.out.println("Making a stream from String chars");

    IntStream streamOfChars = "12345_abcdefg".chars();
    streamOfChars.forEach(System.out::println);

    
    System.out.println("Making a stream from String tokens");

    Stream<String> streamOfTokens = Stream.of("A$B$C".split("\\$"));
    streamOfTokens.forEach(System.out::println);

    System.out.println("Making a stream from integer sequence");

    IntStream streamOfRange = IntStream.rangeClosed(1, 5);
    streamOfRange.forEach(System.out::println);

    
    System.out.println("Making a endless stream");

    Stream<Date> stream6 = Stream.generate(Date::new);
    stream6.limit(10).forEach(System.out::println);
    

    System.out.println("Making an endless stream");

    Stream<Integer> stream7 = Stream.iterate(7, i -> i*3 + 11);
    stream7.limit(10).forEach(System.out::println);
   
    
    
    
    System.out.println("Getting an endless stream from Random.ints()");
    
    Random ran = new Random();
    IntStream streamofrandom = ran.ints();
    streamofrandom.limit(10).forEach(System.out::println);

  }
}
