package dk.lundogbendsen.javase8advanced.annotations.lab01.xmlserializer;

import java.lang.reflect.Field;

public class XmlSerializer {

	public static String toXml(final Object o) throws Exception {
		StringBuilder sb = new StringBuilder();

		Class<?> c = o.getClass();

		// Find ud af hvad elementet der repræsenterer klassen skal hedde
		// Bemærk at vi fortæller metoden, at vi forventer at få en annotation
		// af typen Xml retur (ofte kan Java selv hitte ud af, hvilken
		// type en metode returnerer - det kan Java dog ikke her).
		// Vi kunne også have skrevet sådan her i stedet for:
		// Xml classAnnotation = (Xml) c.getAnnotation(Xml.class);
		Xml classAnnotation = c.getAnnotation(Xml.class);
		String elementNameForClass = classAnnotation.name();
		if (elementNameForClass.equals("")) {
			elementNameForClass = c.getSimpleName();
		}

		// Lav start-elemement for klassen
		sb.append("<" + elementNameForClass + ">" + "\n");

		// Håndter alle felter
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			Xml fieldAnnotation = field.<Xml>getAnnotation(Xml.class);

			// Find ud af hvad elementnavnet for feltet skal være
			String elementNameForField = fieldAnnotation.name();
			if (elementNameForField.equals("")) {
				elementNameForField = field.getName();
			}
			// Find ud af hvordan feltværdien skal udtrykkes i XML'en
			String nullSubstitution = fieldAnnotation.nullSubstitution();
			field.setAccessible(true);
			Object fieldValue = field.get(o);
			String fieldValueAsString;
			if (fieldValue != null) {
				fieldValueAsString = fieldValue.toString();
			} else {
				fieldValueAsString = nullSubstitution;
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
