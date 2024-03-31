package dk.lundogbendsen.javase_advanced.streams.lab01;

import java.util.List;

public class PlanetsMain {
	public static void main(final String[] args) {
		@SuppressWarnings("unused")
		List<Planet> planets = Planet.getPlanets();

//    System.out.println("List names of planets");
//    planets.stream(). ...;
//    System.out.println();

	}

	public static void printName(final Planet p) {
		System.out.println(p.getName());
	}

	public static void printNameAndMass(final Planet p) {
		System.out.println(p.getName() + " mass: " + p.getMassEM());
	}

	public static void printNameAndDistance(final Planet p) {
		System.out.println(p.getName() + " distance (AU): " + p.getOrbitalRadiusAU());
	}

	public static void printNameAndEccentricity(final Planet p) {
		System.out.println(p.getName() + " eccentricity: " + p.getOrbitalEccentricity());
	}
}
