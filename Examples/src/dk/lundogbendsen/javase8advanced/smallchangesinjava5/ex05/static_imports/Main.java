/*
 * Med static imports kan vi importere alle static members, så man kan tilgå
 * dem *uden* at prefixe dem med den klasse/det interface, hvorfra de kommer.
 *
 * Static members importeres vha. sætningen:
 * import static <pakke>.<type>.*; // alle static members
 * import static <pakke>.<type>.<member>; // kun den angivne static member
 *
 * Hvor <type> kan være en klasse, et interface eller en enumeration.
 *
 * Importerer man en overloaded metode (fx println), får man *alle* udgaver
 * af println importeret.
 */
package dk.lundogbendsen.javase8advanced.smallchangesinjava5.ex05.static_imports;

// Import af alle static metoder, felter og metoden ceil fra Math-klassen.
import static java.lang.Math.PI;
import static java.lang.Math.ceil;
// Import af out-variablen fra System-klassen.
import static java.lang.System.out;

public class Main
{

  public static void main(final String[] args)
  {
    int int01 = (int) ceil(PI); // ...og ikke Math.ceil(Math.PI);

    out.println(int01); // ...og ikke System.out.println(int01)
  }
}
