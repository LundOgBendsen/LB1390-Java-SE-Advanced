package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex01.enumeration.basics;

/*
 * I en enum opstilles en kommasepareret liste af netop den endelige mængde af
 * værdier, som enum'en tillader.
 * 
 * En referencevariabel af typen TrafficSignal, vil kun kunne referere til én af
 * de tre navngivne konstante eller null.
 */
public enum TrafficSignal
{
  RED,
  YELLOW,
  GREEN;
}

/*
 * Svarer PRINCIPIELT nogenlunde til:
 * 
 * public enum TrafficSignal {
 * public static final TrafficSignal RED = new TrafficSignal();
 * public static final TrafficSignal YELLOW = new TrafficSignal();
 * public static final TrafficSignal GREEN = new TrafficSignal();
 * }
 */