/*
 * Illustrerer hvordan man kan lave indlejrede / nestede klasser
 */

package dk.lundogbendsen.javase8advanced.nestedtypes.ex02.nestedclass;

public class TestNestedClass
{
  public static void main(final String[] args)
  {
    Weekday dkDay = new Weekday.Danish();
    dkDay.setDay(3);
    System.out.println(dkDay);
    Weekday ukDay = new Weekday.English();
    ukDay.setDay(4);
    System.out.println(ukDay);
  }
}