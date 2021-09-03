package dk.lundogbendsen.javase8advanced.threads.ex03.by.composition;

/*
 * KONSTRUKTION AF TRÅDE VED IMPLEMENTATION AF RUNNABLE.
 * Viser hvordan man kan lave en tråd ved at implementere
 * interfacet Runnable. Den 'kørbare' instans gives til en ny
 * Thread-instans, som startes med metoden start( ). Herefter
 * vil Thread-instansen lave en ny tråd, hvormed den kalder run( ).
 * Bemærk vi kalder trådens start( )-metode i constructoren.
 */
public class ActiveObjectByComposition
{
  public static void main(final String[] args)
  {
    new Printer("Bliiiip", 250, 40);
    new Printer("Duuuuut", 1000, 10);
  }
}