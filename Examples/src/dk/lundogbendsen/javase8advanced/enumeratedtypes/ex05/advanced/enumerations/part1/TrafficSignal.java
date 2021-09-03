package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex05.advanced.enumerations.part1;

import static java.lang.Math.abs;

public enum TrafficSignal
{

  // Enum-værdierne skal defineres som det første i en enum.
  // Her aktiverer hver enkelt værdi den constructor, der tager en String.
  RED("Stop"),
  YELLOW("Start engine"),
  GREEN("Go");

  // Enums må gerne have felter
  String description;

  // Enums kan have constructors (de er automatisk private)
  TrafficSignal(String description)
  {
    this.description = description;
  }

  // Enums må godt have metoder
  public boolean isNextTo(TrafficSignal signal)
  {
    return abs(this.ordinal() - signal.ordinal()) == 1;
  }
}
