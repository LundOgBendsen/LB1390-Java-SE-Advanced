package dk.lundogbendsen.javase8advanced.threads.ex02.by.extension;

/*
 * KONSTRUKTION AF TRÅDE VED NEDARVNING FRA THREAD.
 * Viser hvordan man kan lave en tråd ved at nedarve fra Thread.
 * Bemærk at run( )-metoden overrides i vores subklasse af Thread,
 * og at tråden startes ved at kalde den nedarvede metode start( ),
 * hvilket her gøres automatisk i constructoren.
 */
public class ActiveObjectByExtension {
	public static void main(final String[] args) {
		// NB: Da de to objekter har deres egne tråde,
		// garbage collectes de ikke førend deres egne tråde
		// er kørt færdig
		new Printer("Bliiiip", 250, 40);
		new Printer("Duuuuut", 1000, 10);
	}
}