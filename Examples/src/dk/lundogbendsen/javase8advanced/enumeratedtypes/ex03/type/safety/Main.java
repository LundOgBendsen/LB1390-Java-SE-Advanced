package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex03.type.safety;

// Vi laver static import af alle enumerated types (konstante)
import static dk.lundogbendsen.javase8advanced.enumeratedtypes.ex03.type.safety.TrafficSignal.*;

public class Main
{

  public static void main(String[] args)
  {
    receiveSignal(YELLOW);
  }

  // Denne metode vil ALDRIG kunne få en ulovlig værdi (ud over null, som vil
  // resultere i en NullPointerException, når der switches på den).
  public static void receiveSignal(TrafficSignal signal)
  {
    switch (signal)
    {
      case RED:
        System.out.println("Stop");
        break;
      case YELLOW:
        System.out.println("Gas op");
        break;
      case GREEN:
        System.out.println("Kør");
        break;
      default:
        assert false : "Unknown color";
        break;
    }
  }
}
