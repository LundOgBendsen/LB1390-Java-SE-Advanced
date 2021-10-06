/*
 * Vha. Text.getTextAsLinkedList() kan du få fat i en LinkedList, med en masse
 * små bidder af en samlet tekst. Kør evt. Text-klassens main-metode, der
 * demonstrerer indholdet af listen.
 *
 * Skal du have listens indhold over i en anden type samling - fx en ArrayList,
 * kan det gøres sådan her:
 *
 * ArrayList arrayList = new ArrayList(); arrayList.addAll(
 * Text.getTextAsLinkedList() );
 */
package dk.lundogbendsen.javase8advanced.collections.lab01.text.corpus;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Text {
	public static void main(final String[] args) {
		LinkedList<String> list = Text.getTextAsLinkedList();
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static LinkedList<String> getTextAsLinkedList() {
		String s = "Det er morgen. Klinikassistenten fotokopierer den side fra aftalebogen, som viser dagens aftaler. Hun kigger dem igennem og tjekker, at det er de rigtige journaler, hun har fundet frem dagen før. Hun lægger journalerne og kopien fra kalenderen ind på bordet i frokoststuen. Tandlægen sætter sig ved bordet og skimmer journalerne for at se, om der er noget, hun skal være opmærksom på. Hun skriver noter ned på kopien fra aftalebogen. Hun kan se, at Lise skal have lavet en plastfyldning, og at de har lavet en plastfyldning på hende før - hun noterer ned på dagsplanen hvilken farve plast, der skal bruges - og at Lise plejer at blive bedøvet. På denne måde er det let for klinikassistenten at finde de rigtige ting frem, før patienten kommer. På samme måde skriver hun noter om de øvrige af dagens patienter. Ved nogle patienter har hun skrevet en gul 'postit' med hvad hun skal lave. Det er dog kun ved større behandlingsforløb. Knap et kvarter senere er hun færdig med at gennemgå dagsplanen. Hun tager nu kontokortene ud af samtlige journaler og lægger dem ud i receptionen til sekretæren. Dagsplanen og journalerne tager hun med ind på klinikken.";

		StringTokenizer st = new StringTokenizer(s, " .,-'", true);
		LinkedList<String> list = new LinkedList<String>();
		String current;
		while (st.hasMoreTokens()) {
			current = st.nextToken();
			if (!current.equals(" ")) {
				list.add(current);
			}
		}
		return list;
	}

}