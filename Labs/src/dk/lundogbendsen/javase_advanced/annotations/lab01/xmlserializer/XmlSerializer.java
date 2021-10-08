package dk.lundogbendsen.javase_advanced.annotations.lab01.xmlserializer;

import java.lang.reflect.Field;

public class XmlSerializer {

	public static String toXml(final Object o) throws Exception {
		StringBuilder sb = new StringBuilder();

		Class<?> c = o.getClass();

		// Find ud af hvad elementnavnet for klassen skal være
		String elementNameForClass = c.getSimpleName();

		// Lav start-elemement for klassen
		sb.append("<" + elementNameForClass + ">" + "\n");

		// Håndter alle felter
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {

			// Find ud af hvad elementnavnet for feltet skal være
			String elementNameForField = field.getName();

			// Find ud af hvordan feltværdien skal udtrykkes i XML'en
			field.setAccessible(true);
			Object fieldValue = field.get(o);
			String fieldValueAsString;
			if (fieldValue != null) {
				fieldValueAsString = fieldValue.toString();
			} else {
				fieldValueAsString = "";
			}
			// Lav start-element for feltet
			sb.append("  <" + elementNameForField + ">");

			// Indsæt værdien fra feltet
			sb.append(fieldValueAsString);

			// Lav slut-element for feltet
			sb.append("</" + elementNameForField + ">" + "\n");
		}

		// Lav slut-element for klassen
		sb.append("</" + elementNameForClass + ">");

		return sb.toString();
	}
}
