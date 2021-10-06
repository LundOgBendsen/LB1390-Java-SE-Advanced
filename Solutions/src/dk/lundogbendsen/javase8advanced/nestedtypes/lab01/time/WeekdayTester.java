package dk.lundogbendsen.javase8advanced.nestedtypes.lab01.time;

/*
 * Illustrerer hvordan man kan lave indlejrede / nestede klasser
 */
public class WeekdayTester {
	public static void main(final String[] args) {
		Weekday dkDay = Weekday.danishWeekDay();
		dkDay.setDay(3);
		System.out.println(dkDay);
		Weekday ukDay = Weekday.englishWeekday();
		ukDay.setDay(4);
		System.out.println(ukDay);
	}
}

abstract class Weekday {
	int day;

	void setDay(final int day) {
		if (day < 1 || day > 7) {
			throw new IllegalArgumentException(day + " is not a legal day");
		}
		this.day = day;
	}

	static Weekday danishWeekDay() {
		return new Weekday() {
			@Override
			public String toString() {
				switch (day) {
				case 1:
					return "Mandag";
				case 2:
					return "Tirsdag";
				case 3:
					return "Onsdag";
				case 4:
					return "Torsdag";
				case 5:
					return "Fredag";
				case 6:
					return "Lørdag";
				default:
					return "Søndag";
				}
			}
		};
	}

	static Weekday englishWeekday() {
		return new Weekday() {
			@Override
			public String toString() {
				switch (day) {
				case 1:
					return "Monday";
				case 2:
					return "Tuesday";
				case 3:
					return "Wednesday";
				case 4:
					return "Thursday";
				case 5:
					return "Friday";
				case 6:
					return "Saturday";
				default:
					return "Sunday";
				}
			}
		};
	}
}