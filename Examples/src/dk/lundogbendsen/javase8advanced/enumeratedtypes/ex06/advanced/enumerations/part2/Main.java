package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex06.advanced.enumerations.part2;

public class Main
{
  public static void main(final String[] args)
  {
    for (TrafficSignal trafficSignal : TrafficSignal.values())
      System.out.println(trafficSignal + " " + trafficSignal.description + " " + trafficSignal.isNextTo(TrafficSignal.GREEN));
  }
}