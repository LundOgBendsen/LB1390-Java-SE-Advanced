package dk.lundogbendsen.javase_advanced.streams.lab02;

import java.util.List;

public class MoonsMain {
	public static void main(final String[] args) {
		@SuppressWarnings("unused")
		List<Moon> moons = Moon.getMoons();

		System.out.println("Moons grouped by planets:");

//    Map<String, List<Moon>> groupByName = moons.stream(). ...
//
//    for (Entry<String, List<Moon>> g : groupByName.entrySet())
//    {
//      System.out.println("  "+g.getKey());
//      for (Moon m : g.getValue())
//      {
//        System.out.println("    " + m.getName());
//      }
//    }
//    System.out.println();

	}
}
