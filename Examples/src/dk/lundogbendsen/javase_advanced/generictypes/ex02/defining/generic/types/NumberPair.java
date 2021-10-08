package dk.lundogbendsen.javase_advanced.generictypes.ex02.defining.generic.types;

public class NumberPair<N extends Number, K extends Number> extends Pair<N, K> {

	public NumberPair(N f, K s) {
		super(f, s);
	}

}
