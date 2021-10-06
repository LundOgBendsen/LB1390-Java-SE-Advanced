package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Programmet PersonRegister består af følgende klasser:
 *
 * Klasser der udgør modellen (data og funktionalitet): - Person (repræsenterer
 * en person) - Model (tilbyder samlet syn på modellen) - ModelListener
 * (objekter der implementerer dette interface kan registrere sig hos Model mht.
 * at få besked når modellens tilstand (data) ændres)
 *
 * Klasser der udgør brugergrænsefladen (skærmbillede og interaktion): - View
 * (base-klasse for alle views, hvor view er et vindue) - MainView (programmets
 * primære vindue, indeholder alle de øvrige vinduer, gør det endvidere muligt
 * at åbne de øvrige vinduer og at save og loade) - AllPersonsView (vindue der
 * viser tabel med alle eksisterende personer) - PersonView (vindue der viser en
 * enkelt person, bruges både til at redigere eksisterende personer og når der
 * oprettes nye personer)
 */

public class PersonRegisterMain {
	public static void main(String[] args) {
		new MainView();
	}
}