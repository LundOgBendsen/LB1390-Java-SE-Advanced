package dk.lundogbendsen.javase_advanced.streams.lab02;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import dk.lundogbendsen.javase_advanced.streams.lab01.Planet;
import dk.lundogbendsen.javase_advanced.streams.lab01.PlanetType;

public class MoonsMain {
	public static void main(final String[] args) {
		List<Moon> moons = Moon.getMoons();

		System.out.println("Moons grouped by planets:");

		Map<String, List<Moon>> groupByName = moons.stream().collect(Collectors.groupingBy(Moon::getPlanetName));

		for (Entry<String, List<Moon>> g : groupByName.entrySet()) {
			System.out.println("  " + g.getKey());
			for (Moon m : g.getValue()) {
				System.out.println("    " + m.getName());
			}
		}
		System.out.println();

		System.out.println("Moons grouped by planet types:");

		Map<PlanetType, List<Moon>> groupByPlanetTypes = moons.stream()
				.collect(Collectors.groupingBy((m) -> Planet.find(m.getPlanetName()).getType()));

		for (Entry<PlanetType, List<Moon>> g : groupByPlanetTypes.entrySet()) {
			System.out.println("Moons belonging to " + g.getKey() + " planets");
			for (Moon m : g.getValue()) {
				System.out.println("  " + m.getName());
			}
		}
		System.out.println();

		System.out.println("Count of moons for each planet:");

//    Map<String, Integer> count = moons.stream().collect(Collectors.groupingBy(Moon::getPlanetName, Collectors.reducing(0, (m) -> 1, Integer::sum)));

		Map<String, Long> groupByCount = moons.stream()
				.collect(Collectors.groupingBy(Moon::getPlanetName, Collectors.counting()));

		for (Entry<String, Long> g : groupByCount.entrySet()) {
			System.out.println(g.getKey() + " " + g.getValue());
		}

		System.out.println("Moons grouped by planet types (only three listed):");

		Map<PlanetType, List<Moon>> groupByPlanetTypesMax3 = moons.stream()
				.collect(Collectors.groupingBy((m) -> Planet.find(m.getPlanetName()).getType()));

		for (Entry<PlanetType, List<Moon>> g : groupByPlanetTypesMax3.entrySet()) {
			System.out.println("Moons belonging to " + g.getKey() + " planets");

			g.getValue().stream().limit(3).forEach((m) -> System.out.println("  " + m.getName()));
			if (g.getValue().size() > 3) {
				System.out.println("  ... " + (g.getValue().size() - 3) + " more");
			}
		}
		System.out.println();

	}
}
