package dk.lundogbendsen.javase_advanced.streams.lab02;

import java.util.LinkedList;
import java.util.List;

public class Moon
{
  /*
   * Name planet Radius (km) Mass (kg) Semi-major axis (km) Orbital period D
   */

  private final String name;
  private final String planetName;
  private final double diameterKM;
  private final double massKG;
  private final double semimajorAxisKM;
  private final double orbitalPeriodD;
  private final boolean retrogradeMotion;

  public String getName()
  {
    return name;
  }

  public String getPlanetName()
  {
    return planetName;
  }

  public double getDiameterKM()
  {
    return diameterKM;
  }

  public double getMassKG()
  {
    return massKG;
  }

  public double getSemimajorAxisKM()
  {
    return semimajorAxisKM;
  }

  public double getOrbitalPeriodD()
  {
    return orbitalPeriodD;
  }

  public boolean isRetrogradeMotion()
  {
    return retrogradeMotion;
  }

  private static final List<Moon> moons = new LinkedList<Moon>();

  public static List<Moon> getMoons()
  {
    return moons;
  }

  private static final double F_MASS = 1e22;
  private static final double F_MA = 1000.0;

  static
  {
    //    masse        Radius   semimajor   period    retro
    //    10 i 20   km    1000km    dage
    moons.add(new Moon("Moon", "Earth", 7.3477e22 / F_MASS, 1737, 384399 / F_MA, 27.321582, false));
    moons.add(new Moon("Phobos", "Mars", 10.8e15 / F_MASS, 11.1, 9377 / F_MA, 7.66 / 24, false));
    moons.add(new Moon("Deimos", "Mars", 2e15 / F_MASS, 6.3, 23460 / F_MA, 30.35 / 24, false));

    moons.add(new Moon("Io (JI)", "Jupiter", 893.2, 1821.6, 421.6, 1.769138, false));
    moons.add(new Moon("Europa (JII)", "Jupiter", 480.0, 1560.8, 670.9, 3.551181, false));
    moons.add(new Moon("Ganymede (JIII)", "Jupiter", 1481.9, 2631.2, 1070.4, 7.154553, false));
    moons.add(new Moon("Callisto (JIV)", "Jupiter", 1075.9, 2410.3, 1882.7, 16.689018, false));
    moons.add(new Moon("Metis (JXVI, S/1979 J3)", "Jupiter", 1, 20, 128.0, 0.294779, false));
    moons.add(new Moon("Adrastea (JXV, S/1979 J1)", "Jupiter", 0.0002, 12, 129.0, 0.298260, false));
    moons.add(new Moon("Amalthea (JV)", "Jupiter", 75, 90, 181.4, 0.498179, false));
    moons.add(new Moon("Thebe (JXIV, S/1979 J2)", "Jupiter", 8, 50, 221.9, 0.6745, false));
    moons.add(new Moon("Themisto (JXVIII, S/1975 J1)", "Jupiter", 0, 4, 7507, 130.02, false));
    moons.add(new Moon("Leda (JXIII)", "Jupiter", 0.00006, 5, 11170, 240.92, false));
    moons.add(new Moon("Himalia (JVI)", "Jupiter", 95, 85, 11460, 250.5662, false));
    moons.add(new Moon("Lysithea (JX)", "Jupiter", 0.0008, 12, 11720, 259.22, false));
    moons.add(new Moon("Elara (JVII)", "Jupiter", 8, 40, 11740, 259.6528, false));
    moons.add(new Moon("S/2000 J11", "Jupiter", 0, 2.0, 12560, 287.0, false));
    moons.add(new Moon("Carpo (XLVI, S/2003 J20)", "Jupiter", 0, 3.0, 16990, 456.1, false));
    moons.add(new Moon("Euporie (JXXXIV, S/2001 J10)", "Jupiter", 0, 1.0, 19390, 553.1, true));
    moons.add(new Moon("Orthosie (JXXXV, S/2001 J9)", "Jupiter", 0, 1.0, 20720, 622.6, true));
    moons.add(new Moon("Euanthe (JXXXIII, S/2001 J7)", "Jupiter", 0, 1.5, 20800, 620.6, true));
    moons.add(new Moon("Thyone (JXXIX, S/2001 J2)", "Jupiter", 0, 2.0, 20940, 627.3, true));
    moons.add(new Moon("Mneme (JXL, S/2003 J21)", "Jupiter", 0, 2.0, 21070, 620.0, true));
    moons.add(new Moon("Harpalyke (JXXII, S/2000 J5)", "Jupiter", 0, 2.2, 21110, 623.3, true));
    moons.add(new Moon("Hermippe (JXXX, S/2001 J3)", "Jupiter", 0, 2.0, 21130, 633.9, true));
    moons.add(new Moon("Praxidike (JXXVII, S/2000 J7)", "Jupiter", 0, 3.4, 21150, 625.3, true));
    moons.add(new Moon("Thelxinoe (XLII, S/2003 J22)", "Jupiter", 0, 2.0, 21160, 628.1, true));
    moons.add(new Moon("Helike (XLV, S/2003 J6)", "Jupiter", 0, 4.0, 21260, 634.8, true));
    moons.add(new Moon("Iocaste (JXXIV, S/2000 J3)", "Jupiter", 0, 2.6, 21270, 631.5, true));
    moons.add(new Moon("Ananke (JXII)", "Jupiter", 0.0004, 10, 21280, 629.8, true));
    moons.add(new Moon("Herse (L, S/2003 J17)", "Jupiter", 0, 2.0, 22870, 717.3, true));
    moons.add(new Moon("Eurydome (JXXXII, S/2001 J4)", "Jupiter", 0, 1.5, 22930, 723.9, true));
    moons.add(new Moon("Arche (XLIII, S/2002 J1)", "Jupiter", 0, 1.5, 23040, 762.7, true));
    moons.add(new Moon("Autonoe (JXXVIII, S/2001 J1)", "Jupiter", 0, 2.0, 23097, 715.4, true));
    moons.add(new Moon("Pasithee (JXXXVIII, S/2001 J6)", "Jupiter", 0, 1.0, 23100, 716.3, true));
    moons.add(new Moon("Chaldene (JXXI, S/2000 J10)", "Jupiter", 0, 1.9, 23180, 723.8, true));
    moons.add(new Moon("Kale (JXXXVII, S/2001 J8)", "Jupiter", 0, 1.0, 23220, 729.5, true));
    moons.add(new Moon("Isonoe (JXXVI, S/2000 J6)", "Jupiter", 0, 1.9, 23220, 725.5, true));
    moons.add(new Moon("Aitne (JXXXI, S/2001 J11)", "Jupiter", 0, 1.5, 23230, 730.2, true));
    moons.add(new Moon("Erinome (JXXV, S/2000 J4)", "Jupiter", 0, 1.6, 23280, 728.3, true));
    moons.add(new Moon("Taygete (JXX, S/2000 J9)", "Jupiter", 0, 2.5, 23360, 732.2, true));
    moons.add(new Moon("Carme (JXI)", "Jupiter", 1, 15, 23400, 734.2, true));
    moons.add(new Moon("Sponde (JXXXVI, S/2001 J5)", "Jupiter", 0, 1.0, 23490, 748.3, true));
    moons.add(new Moon("Kalyke (JXXIII, S/2000 J2)", "Jupiter", 0, 2.6, 23580, 743.0, true));
    moons.add(new Moon("Pasiphae (JVIII)", "Jupiter", 3, 18, 23620, 743.6, true));
    moons.add(new Moon("Eukelade (XLVII, S/2003 J1)", "Jupiter", 0, 4.0, 23660, 746.4, true));
    moons.add(new Moon("Megaclite (JXIX, S/2000 J8)", "Jupiter", 0, 2.7, 23810, 752.8, true));
    moons.add(new Moon("Sinope (JIX)", "Jupiter", 0.0008, 14, 23940, 758.9, true));
    moons.add(new Moon("Hegemone (JXXXIX, S/2003 J8)", "Jupiter", 0, 3.0, 23950, 739.6, true));
    moons.add(new Moon("Aoede (XLI, S/2003 J7)", "Jupiter", 0, 4.0, 23980, 761.5, true));
    moons.add(new Moon("Kallichore (XLIV, S/2003 J11)", "Jupiter", 0, 2.0, 24040, 764.7, true));
    moons.add(new Moon("Callirrhoe (JXVII, S/1999 J1)", "Jupiter", 0, 4, 24100, 758.8, true));
    moons.add(new Moon("Cyllene (XLVIII, S/2003 J13)", "Jupiter", 0, 2.0, 24350, 737.8, true));
    moons.add(new Moon("Kore (XLIX, S/2003 J14)", "Jupiter", 0, 2.0, 24540, 779.2, true));
    moons.add(new Moon("S/2003 J2", "Jupiter", 0, 2.0, 28570, 982.5, true));
    moons.add(new Moon("S/2003 J3", "Jupiter", 0, 2.0, 18340, 504.0, true));
    moons.add(new Moon("S/2003 J4", "Jupiter", 0, 2.0, 23260, 723.2, true));
    moons.add(new Moon("S/2003 J5", "Jupiter", 0, 4.0, 24080, 759.7, true));
    moons.add(new Moon("S/2003 J9", "Jupiter", 0, 1.0, 22440, 683.0, true));
    moons.add(new Moon("S/2003 J10", "Jupiter", 0, 2.0, 24250, 767.0, true));
    moons.add(new Moon("S/2003 J12", "Jupiter", 0, 1.0, 19000, 533.3, true));
    moons.add(new Moon("S/2003 J15", "Jupiter", 0, 2.0, 22000, 668.4, true));
    moons.add(new Moon("S/2003 J16", "Jupiter", 0, 2.0, 21000, 595.4, true));
    moons.add(new Moon("S/2003 J18", "Jupiter", 0, 2.0, 20700, 606.3, true));
    moons.add(new Moon("S/2003 J19", "Jupiter", 0, 2.0, 22800, 701.3, true));
    moons.add(new Moon("S/2003 J23", "Jupiter", 0, 2.0, 24060, 759.7, true));
    moons.add(new Moon("S/2010 J1", "Jupiter", 0, 2.0, 23314, 723.2, true));
    moons.add(new Moon("S/2010 J2", "Jupiter", 0, 2.0, 20307, 588.1, true));
    moons.add(new Moon("S/2011 J1", "Jupiter", 0, 2.0, 20155, 580.7, true));
    moons.add(new Moon("S/2011 J2", "Jupiter", 0, 2.0, 23330, 726.8, true));
  }

  public Moon(final String name, final String planetName, final double diameterKM, final double massKG, final double semimajorAxisKM, final double orbitalPeriodD, final boolean retrogradeMotion)
  {
    super();
    this.name = name;
    this.planetName = planetName;
    this.diameterKM = diameterKM;
    this.massKG = massKG * F_MASS;
    this.semimajorAxisKM = semimajorAxisKM * F_MA;
    this.orbitalPeriodD = orbitalPeriodD;
    this.retrogradeMotion = retrogradeMotion;
  }

}
