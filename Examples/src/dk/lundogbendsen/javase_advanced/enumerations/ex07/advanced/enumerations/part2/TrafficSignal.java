package dk.lundogbendsen.javase_advanced.enumerations.ex07.advanced.enumerations.part2;

public enum TrafficSignal {

	/*
	 * Enums can have their own overriden methods using the syntax for anonymous
	 * classes. In this case GREEN has its own version of allowsDriving. Use with
	 * care
	 */
	RED("Stop"),
	YELLOW("Start engine"),
	GREEN("Go") {
		@Override
		public boolean allowsDriving() {
			return true;
		}
	};

	public boolean allowsDriving() {
		return false;
	}

	String description;

	TrafficSignal(final String description) {
		this.description = description;
	}
}
