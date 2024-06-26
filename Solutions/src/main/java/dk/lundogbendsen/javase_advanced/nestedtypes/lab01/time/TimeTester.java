package dk.lundogbendsen.javase_advanced.nestedtypes.lab01.time;

public class TimeTester {
	public static void main(final String[] args) {
		Time dkTime = new Time.Danish();
		dkTime.setTime(2, 54);
		System.out.println(dkTime);
		dkTime.setTime(13, 35);
		System.out.println(dkTime);

		Time ukTime = new Time.English();
		ukTime.setTime(2, 54);
		System.out.println(ukTime);
		ukTime.setTime(13, 35);
		System.out.println(ukTime);
	}
}

abstract class Time {
	int hour, minutes;

	void setTime(final int hour, final int minutes) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException(hour + ":" + minutes + " is not a legal time");
		}
		this.hour = hour;
		if (minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException(hour + ":" + minutes + " is not a legal time");
		}
		this.minutes = minutes;
	}

	static class Danish extends Time {
		@Override
		public String toString() {
			return hour + ":" + minutes;
		}
	}

	static class English extends Time {
		@Override
		public String toString() {
			if (hour == 0) {
				return "12:" + minutes + " AM";
			} else if (hour <= 12) {
				return hour + ":" + minutes + " AM";
			} else {
				return (hour - 12) + ":" + minutes + " PM";
			}
		}
	}
}