package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex06.advanced.enumerations.part2;

import static java.lang.Math.abs;

public enum TrafficSignal
{

  // Man kan også give enums deres egne varianter af metoder.
  // Det gøres med samme syntaks, som når man definerer anonyme klasser.
  // Her har GREEN fået sin egen variant af metoden allowsDriving:
  RED("Stop"),
  YELLOW("Start engine"),
  GREEN("Go")
  {
    @Override
    public boolean allowsDriving()
    {
      return true;
    }
  };

  public boolean allowsDriving()
  {
    return false;
  }

  String description;

  TrafficSignal(String description)
  {
    this.description = description;
  }

  public boolean isNextTo(TrafficSignal signal)
  {
    return abs(this.ordinal() - signal.ordinal()) == 1;
  }
}
