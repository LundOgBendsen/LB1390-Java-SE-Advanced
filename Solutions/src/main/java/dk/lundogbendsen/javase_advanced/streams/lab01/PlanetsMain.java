package dk.lundogbendsen.javase_advanced.streams.lab01;

import java.util.Comparator;
import java.util.List;

public class PlanetsMain
{
  public static void main(final String[] args)
  {
    List<Planet> planets = Planet.getPlanets();

    System.out.println("List names of planets");
    planets.stream().forEach((p) -> System.out.println(p.getName()));
    System.out.println();

    System.out.println("List names of all terrestial planets");
    planets.stream().filter((p) -> p.getType() == PlanetType.TERRESTRIAL).forEach(PlanetsMain::printName);
    System.out.println();

    System.out.println("List names of all terrestial planets with more than one moon");
    planets.stream().filter((p) -> p.getType() == PlanetType.TERRESTRIAL).filter((p) -> p.getConfirmedNumberOfMoons() > 1).forEach(PlanetsMain::printName);
    System.out.println();

    System.out.println("List names of all planets by mass, lightest first");
    planets.stream().sorted((p1, p2) -> (int)Math.signum(p1.getMassEM() - p2.getMassEM())).forEach(PlanetsMain::printNameAndMass);
    System.out.println();
        
    System.out.println("List names of three most distant planets");
    planets.stream().sorted(Comparator.comparing(Planet::getOrbitalRadiusAU).reversed()).limit(3).forEach(PlanetsMain::printNameAndDistance);
    System.out.println();
    
    System.out.println("Find most eccentric planet");
    planets.stream().sorted(Comparator.comparing(Planet::getOrbitalEccentricity).reversed()).limit(1).forEach(PlanetsMain::printNameAndEccentricity);
    System.out.println();
    
    System.out.println("Find third-most eccentric planet");
    planets.stream().sorted(Comparator.comparing(Planet::getOrbitalEccentricity).reversed()).skip(2).limit(1).forEach(PlanetsMain::printNameAndEccentricity);
  }
  
  
  
  public static void printName(final Planet p)
  {
    System.out.println(p.getName());
  }
  public static void printNameAndMass(final Planet p)
  {
    System.out.println(p.getName() + " mass: "+p.getMassEM());
  }
  public static void printNameAndDistance(final Planet p)
  {
    System.out.println(p.getName() + " distance (AU): "+p.getOrbitalRadiusAU());
  }
  public static void printNameAndEccentricity(final Planet p)
  {
    System.out.println(p.getName() + " eccentricity: "+p.getOrbitalEccentricity());
  }
}
