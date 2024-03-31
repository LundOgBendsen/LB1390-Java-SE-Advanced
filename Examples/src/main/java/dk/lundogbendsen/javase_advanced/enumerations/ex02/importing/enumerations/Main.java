/*
 * Enums are often used with static imports.
 */
package dk.lundogbendsen.javase_advanced.enumerations.ex02.importing.enumerations;

import static dk.lundogbendsen.javase_advanced.enumerations.ex02.importing.enumerations.TrafficSignal.GREEN;
import static dk.lundogbendsen.javase_advanced.enumerations.ex02.importing.enumerations.TrafficSignal.RED;
import static dk.lundogbendsen.javase_advanced.enumerations.ex02.importing.enumerations.TrafficSignal.YELLOW;

public class Main
{

  @SuppressWarnings("unused")
  public static void main(final String[] args)
  {

    TrafficSignal ts1 = RED;
    TrafficSignal ts2 = YELLOW;
    TrafficSignal ts3 = GREEN;
  }
}
