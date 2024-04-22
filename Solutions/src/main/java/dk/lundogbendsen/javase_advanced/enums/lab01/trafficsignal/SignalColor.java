package dk.lundogbendsen.javase_advanced.enums.lab01.trafficsignal;

public enum SignalColor {
	GREEN(true), RED(false), YELLOW(false);

	private boolean drivingAllowed;

	private SignalColor(final boolean drivingAllowed) {
		this.drivingAllowed = drivingAllowed;
	}

	public void setDrivingAllowed(final boolean tf) {
		drivingAllowed = tf;
	}

	public boolean getDrivingAllowed() {
		return drivingAllowed;
	}
}
