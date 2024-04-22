package dk.lundogbendsen.javase_advanced.enums.lab01.trafficsignal;

public class TrafficLight {
	SignalColor signalColor;

	public TrafficLight(final SignalColor sig) {
		signalColor = sig;
	}

	public TrafficLight() {
	}

	public boolean drivingAllowed() {
		return signalColor.getDrivingAllowed();
	}

	public void setSignalColor(final SignalColor sig) {
		signalColor = sig;
	}

	public String getColorOfLight() {
		return signalColor.toString();
	}

	@Override
	public String toString() {
		if (signalColor.getDrivingAllowed())
			return "The light is " + signalColor.toString().toLowerCase() + ". Driving is allowed!";
		else
			return "The light is " + signalColor.toString().toLowerCase() + ". Driving is not allowed!";
	}
}
