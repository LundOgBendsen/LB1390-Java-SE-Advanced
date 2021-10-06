package dk.lundogbendsen.javase8advanced.polymorphism.ex05.employee.with.polymorphism;

/*
 * Viser et eksempel på noget kode, der
 * bruger polymorfi fremfor switch.
 */
import java.util.Vector;

public class EmployeesMedPolymorfi {
	public static void main(final String[] args) {
		Department d = new Department();
		d.addEmployee(new Manager()); // før new Employee( Employee.MANAGER )
		d.addEmployee(new Salesman()); // før new Employee( Employee.SALESMAN )
		d.addEmployee(new Salesman());
		d.addEmployee(new Salesman());
		d.addEmployee(new Salesman());
		d.addEmployee(new Engineer()); // før new Employee( Employee.ENGINEER )

		d.addEmployee(new Engineer());
		d.addEmployee(new Engineer());
		// Der _kan_ ikke laves fejl som før:
		// d.addEmployee( new Employee( 8 ) );

		System.out.println(d);
		System.out.println("Total department salary: " + d.totalPayAmount());
	}
}

class Department {
	Vector<Employee> employees = new Vector<Employee>();

	void addEmployee(final Employee e) {
		employees.add(e);
	}

	void removeEmployee(final Employee e) {
		employees.remove(e);
	}

	int totalPayAmount() {
		int total = 0;
		for (Employee emp : employees) {
			total += emp.payAmount();
		}
		return total;
	}

	@Override
	public String toString() {
		String s = "Department[\n";
		for (Employee emp : employees) {
			s += "  " + emp.toString() + ",\n";
		}
		return s + "]";
	}
}

abstract class Employee {
	static int salary = 30000;

	static int commission = 10000;

	static int bonus = 40000;

	abstract int payAmount();

	@Override
	abstract public String toString();
}

class Engineer extends Employee {
	@Override
	int payAmount() {
		return salary;
	}

	@Override
	public String toString() {
		return "Engineer";
	}
}

class Salesman extends Employee {
	@Override
	int payAmount() {
		return salary + commission;
	}

	@Override
	public String toString() {
		return "Salesman";
	}
}

class Manager extends Employee {
	@Override
	int payAmount() {
		return salary + bonus;
	}

	@Override
	public String toString() {
		return "Manager";
	}
}