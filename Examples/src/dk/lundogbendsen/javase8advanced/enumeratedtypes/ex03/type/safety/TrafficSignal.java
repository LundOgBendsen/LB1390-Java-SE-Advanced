package dk.lundogbendsen.javase8advanced.enumeratedtypes.ex03.type.safety;

/*
 * I realiteten er en enum en klasse.
 * 
 * Listen af værdier i en enum er instanser af "enum"-klassen. Hver værdi i en
 * enum er i realiteten et public static final felt.
 * 
 * Det sikres, at der ikke kan laves nye værdier end de opstillede i en enum:
 * (1) at tvinge en enum til kun at måtte have private constructors (2) kun at
 * tillade "instantiering" vha. enums specielle syntaks (ikke new!)
 * 
 * Man kan fx lave metoder, der forventer at få en enum-type som parameter, og
 * det vil *ikke* være muligt at sende andet end netop en af enum'ens værdier.
 * Sammenlignet med heltalskonstante er enums altså langt sikrere.
 * 
 * Enums håndteres specielt mht. serialisering, så det ikke er muligt at få
 * oprettet dubletter af en enum-instans (dvs. vi kan bruge deres identitet,
 * eller sagt med andre ord, det er ufarligt at bruge == operatoren).
 * 
 * Enums er automatisk final (dvs. man ikke kan lave subtyper af en enum).
 */
public enum TrafficSignal
{
  RED,
  YELLOW,
  GREEN;
}
