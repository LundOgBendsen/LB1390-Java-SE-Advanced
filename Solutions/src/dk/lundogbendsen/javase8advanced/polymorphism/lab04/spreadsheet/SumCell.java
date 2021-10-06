package dk.lundogbendsen.javase8advanced.polymorphism.lab04.spreadsheet;

public class SumCell extends Cell {

	private Cell firstCell;
	private Cell secondCell;

	public SumCell(final Cell firstCell, final Cell secondCell) {
		this.firstCell = firstCell;
		this.secondCell = secondCell;
	}

	@Override
	public double getNumberValue() {
		double firstValue = firstCell.getNumberValue();
		double secondValue = secondCell.getNumberValue();
		return firstValue + secondValue;
	}

	@Override
	public String toString() {
		return "" + getNumberValue();
	}
}
