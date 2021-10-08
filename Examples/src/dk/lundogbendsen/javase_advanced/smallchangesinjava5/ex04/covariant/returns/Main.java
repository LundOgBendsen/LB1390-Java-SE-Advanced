/*
 * Covariant return types betyder, at en metode B, der overrider en metode A,
 * godt må have en mere specifik returtype end metoden A har det.
 *
 * I den forbindelse har primitive typer *ikke* noget forhold til hinanden
 * (dvs. at en metode med returtypen double fx ikke kan overrides af en metode,
 * der har int som sin returtype).
 *
 * Metoden RandomIntegerGenerator.generateRandomObject() overrider metoden
 * RandomObjectGenerator.generateRandomObject(), *men* med en mere specifik
 * returtype (Integer fremfor Object).
 */
package dk.lundogbendsen.javase_advanced.smallchangesinjava5.ex04.covariant.returns;

public class Main {
	public static void main(final String[] args) {
		RandomObjectGenerator gen = new RandomIntegerGenerator();
		System.out.println(gen.generateRandomObject());
	}
}
