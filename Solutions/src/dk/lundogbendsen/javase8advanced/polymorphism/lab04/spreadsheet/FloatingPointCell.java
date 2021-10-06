package dk.lundogbendsen.javase8advanced.polymorphism.lab04.spreadsheet;

public class FloatingPointCell extends Cell {

	private double value;

	public FloatingPointCell(final double value) {
		this.value = value;
	}

	@Override
	public double getNumberValue() {
		return value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
