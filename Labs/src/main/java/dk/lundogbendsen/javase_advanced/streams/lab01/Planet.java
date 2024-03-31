package dk.lundogbendsen.javase_advanced.streams.lab01;

import java.util.LinkedList;
import java.util.List;

public class Planet {
	private final String name;
	private final PlanetType type;
	private final double equatorialDiameterED;
	private final double massEM;
	private final double orbitalRadiusAU;
	private final double orbitalPeriodY;
	private final double inclinationToSunsEquatorD;
	private final double orbitalEccentricity;
	private final double rotationPeriodD;
	private final int confirmedNumberOfMoons;
	private final boolean rings;
	private final String atmosphere;

	public String getName() {
		return name;
	}

	public PlanetType getType() {
		return type;
	}

	public double getEquatorialDiameterED() {
		return equatorialDiameterED;
	}

	public double getMassEM() {
		return massEM;
	}

	public double getOrbitalRadiusAU() {
		return orbitalRadiusAU;
	}

	public double getOrbitalPeriodY() {
		return orbitalPeriodY;
	}

	public double getInclinationToSunsEquatorD() {
		return inclinationToSunsEquatorD;
	}

	public double getOrbitalEccentricity() {
		return orbitalEccentricity;
	}

	public double getRotationPeriodD() {
		return rotationPeriodD;
	}

	public Integer getConfirmedNumberOfMoons() {
		return confirmedNumberOfMoons;
	}

	public boolean isRings() {
		return rings;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	private static final List<Planet> planets = new LinkedList<Planet>();

	public static List<Planet> getPlanets() {
		return planets;
	}

	public static Planet find(final String name) {
		for (Planet p : planets) {
			if (p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}

	static {
		planets.add(new Planet("Mercury", PlanetType.TERRESTRIAL, 0.382, 0.06, 0.39, 0.24, 3.38, 0.206, 58.64, 0, false,
				"minimal"));
		planets.add(new Planet("Venus", PlanetType.TERRESTRIAL, 0.949, 0.82, 0.72, 0.62, 3.86, 0.007, -243.02, 0, false,
				"CO2, N2"));
		planets.add(new Planet("Earth", PlanetType.TERRESTRIAL, 1.00, 1.00, 1.00, 1.00, 7.25, 0.017, 1.00, 1, false,
				"N2, O2, Ar"));
		planets.add(new Planet("Mars", PlanetType.TERRESTRIAL, 0.532, 0.11, 1.52, 1.88, 5.65, 0.093, 1.03, 2, false,
				"CO2, N2, Ar"));
		planets.add(new Planet("Uranus", PlanetType.GIANT, 4.007, 14.6, 19.22, 84.01, 6.48, 0.047, -0.72, 27, true,
				"H2, He"));
		planets.add(new Planet("Neptune", PlanetType.GIANT, 3.883, 17.2, 30.06, 164.8, 6.43, 0.009, 0.67, 14, true,
				"H2, He"));
		planets.add(new Planet("Jupiter", PlanetType.GIANT, 11.209, 317.8, 5.20, 11.86, 6.09, 0.048, 0.41, 67, true,
				"H2, He"));
		planets.add(new Planet("Saturn", PlanetType.GIANT, 9.449, 95.2, 9.54, 29.46, 5.51, 0.054, 0.43, 62, true,
				"H2, He"));
	}

	public Planet(final String name, final PlanetType type, final double equatorialDiameterED, final double massEM,
			final double orbitalRadiusAU, final double orbitalPeriodY, final double inclinationToSunsEquatorD,
			final double orbitalEccentricity, final double rotationPeriodD, final int confirmedNumberOfMoons,
			final boolean rings, final String atmosphere) {
		super();
		this.name = name;
		this.type = type;
		this.equatorialDiameterED = equatorialDiameterED;
		this.massEM = massEM;
		this.orbitalRadiusAU = orbitalRadiusAU;
		this.orbitalPeriodY = orbitalPeriodY;
		this.inclinationToSunsEquatorD = inclinationToSunsEquatorD;
		this.orbitalEccentricity = orbitalEccentricity;
		this.rotationPeriodD = rotationPeriodD;
		this.confirmedNumberOfMoons = confirmedNumberOfMoons;
		this.rings = rings;
		this.atmosphere = atmosphere;
	}

}
