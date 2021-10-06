package dk.lundogbendsen.javase8advanced.annotations.ex02.persistence;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class SqlGenerator {

	public static <T> String generateSqlFor(Class<T> c) {

		String result = "";

		// Linien nedenfor skal læses:
		// Giv mig annotationen af typen PersistentClass på klassen c
		PersistentClass pc = c.getAnnotation(PersistentClass.class);

		// Vi kunne også validere alle mulige andre ting mht. annotation
		// men det gider vi ikke i dette eksempel...
		if (pc == null) {
			String msg = "Missing annotation: PersistentClass";
			throw new IllegalStateException(msg);
		}

		String tableName = pc.table(); // person
		String pkField = pc.primaryKey(); // id
		String pkColumnName = null;

		result += "CREATE TABLE '" + tableName + "' (" + "\n";

		Method[] methods = c.getMethods();
		List<Method> getterMethods = new LinkedList<Method>();
		for (Method m : methods) {
			if (m.getName().startsWith("get") || m.getName().startsWith("is")) {
				if (!m.getName().startsWith("getClass")) {
					getterMethods.add(m);
				}
			}
		}
		for (Method m : getterMethods) {
			PersistentField pf = m.getAnnotation(PersistentField.class);
			String columnName = pf.columnName();
			String columnType = pf.columnType();
			result += "  " + columnName + " ";
			result += columnType + "," + "\n";
			if (m.getName().equalsIgnoreCase("get" + pkField)) {
				pkColumnName = columnName;
			}
		}

		result += "  " + "PRIMARY KEY (" + pkColumnName + ")" + "\n";
		result += ")";
		return result;
	}
}

/*
 * 
 * CREATE TABLE 'person' ( person_id INTEGER, first_name VARCHAR(40), last_name
 * VARCHAR(40), PRIMARY KEY (person_id) )
 */