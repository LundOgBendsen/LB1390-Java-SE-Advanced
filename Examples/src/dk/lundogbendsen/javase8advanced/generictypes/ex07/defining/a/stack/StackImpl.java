package dk.lundogbendsen.javase8advanced.generictypes.ex07.defining.a.stack;

import java.util.NoSuchElementException;

// Vi definerer en stak, der kan indeholde elementer. Typen af elementer stakken
// skal indeholde, skal angives, når man laver en ny referencevariabel eller
// en ny instans af vores stak (fx Stack<String>).

public class StackImpl<E> implements Stack<E> {

	// Vores stak indeholder en reference til det link, som holder elementet,
	// der ligger på toppen af vores stak.
	//
	// Link-klassen kræver også en typeparameter.
	// Her "videresender" vi så og sige bare Stack'ens type som typeparameter
	// til Link.
	// Dvs. at laver brugeren en new Stack<String>(), så får Stack typen
	// <String>, og giver så <String> som typeparameter til Link.
	private Link<E> top;

	// Push-metoden vil *kun* tage i mod parametre af den type, som Stack'en
	// fik som typeparameter
	@Override
	public void push(E element) {
		Link<E> newLink = new Link<E>(element);
		if (top == null) {
			top = newLink;
		} else {
			newLink.belowMe = top;
			top = newLink;
		}

	}

	// Pop-metoden returnerer objekter af den type, som Stack'en fik som
	// typeparameter.
	@Override
	public E pop() {
		if (top == null) {
			throw new NoSuchElementException();
		} else {
			E element = top.element;
			if (top.belowMe == null) {
				top = null;
			} else {
				top = top.belowMe;
			}
			return element;
		}
	}

	// Link-objekter kan "holde" et objekt i stakken, og kan referere til
	// det link-objekt, der ligger "under dem selv" i stakken.
	// Link er også en generic class, der tager en type som parameter.
	private class Link<O> {

		// Link kan referere til linket under den selv (samme type).
		private Link<O> belowMe;

		// Hver link kan refere til et objekt, som er af netop den type, som
		// en Link har fået som sin typeparameter.
		private O element;

		private Link(O element) {
			this.element = element;
		}
	}
}
