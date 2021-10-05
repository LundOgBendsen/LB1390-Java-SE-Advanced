/*
 * Illustrerer et eksempel på brugen af generiske metoder (dvs. metoder, der
 * definerer deres egne generiske typer).
 */
package dk.lundogbendsen.javase8advanced.generictypes.ex08.generic.methods;

import java.util.Collections;

public class Main
{
  public static void main(String[] args)
  {
    Integer i = 12;
    Double d = 12.2;

    // Her vil compileren vha. "type inference" gætte typen på metoden 
    System.out.println(max(i, d));

    // Men man kan også eksplicit angive typen på metoden ved kaldet, idet
    // man dog så *skal* bruge dot-notation til kaldet. 
    System.out.println(Main.<Number> max(i, d));

    // At angive type til en metode, giver god mening i tilfælde, hvor 
    // compileren *ikke* kan gætte sig til typen, fx hvis vi vil have 
    // Collections-klassen til at give os en typed tom liste:
    System.out.println(Collections.<String> emptyList());
  }

  // Bemærk at vi her har en metode, der returnerer en double, men som
  // endvidere definerer typen N (som værende en subtype af Number).
  public static <N extends Number> N max(N first, N second)
  {
    if (first.doubleValue() > second.doubleValue())
    {
      return first;
    }
    else
    {
      return second;
    }
  }

}
