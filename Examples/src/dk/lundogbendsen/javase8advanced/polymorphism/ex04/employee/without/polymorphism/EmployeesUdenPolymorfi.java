package dk.lundogbendsen.javase8advanced.polymorphism.ex04.employee.without.polymorphism;

/*
 * Viser et eksempel på noget kode, der
 * bruger switch fremfor polymorfi.
 *
 * Ulemper: Hvis vi retter i Employee ville
 * gemte objekter ikke længere kunne bruges.
 * Det er svært at overskue hvor der skal
 * ændres hvis vi vil tilføje en ny type
 * ansat...
 * Det er besværligt at checke om et nyt
 * Employee-objekt laves på den rigtige måde.
 *
 * NB: Håndterer ikke fejlagtige Employees i constructoren
 */
import java.util.ArrayList;

public class EmployeesUdenPolymorfi
{
  public static void main(final String[] args)
  {
    Department d = new Department();
    d.addEmployee(new Employee(Employee.MANAGER));
    d.addEmployee(new Employee(Employee.SALESMAN));
    d.addEmployee(new Employee(Employee.SALESMAN));
    d.addEmployee(new Employee(Employee.SALESMAN));
    d.addEmployee(new Employee(Employee.SALESMAN));
    d.addEmployee(new Employee(Employee.ENGINEER));
    d.addEmployee(new Employee(Employee.ENGINEER));
    d.addEmployee(new Employee(Employee.ENGINEER));
    // Følgende fejl er svær at opdage
    d.addEmployee(new Employee(8));

    System.out.println(d);
    System.out.println("Total department salary: " + d.totalPayAmount());
  }
}

class Department
{
  ArrayList<Employee> employees = new ArrayList<Employee>();

  void addEmployee(final Employee e)
  {
    employees.add(e);
  }

  void removeEmployee(final Employee e)
  {
    employees.remove(e);
  }

  int totalPayAmount()
  {
    int total = 0;
    for (Employee emp : employees)
    {
      total += emp.payAmount();
    }

    return total;
  }

  @Override
  public String toString()
  {
    String s = "Department[\n";
    for (Employee emp : employees)
    {
      s += "    " + emp.toString() + ",\n";
    }
    return s + "]";
  }
}

class Employee
{
  static final int ENGINEER = 0;

  static final int SALESMAN = 1;

  static final int MANAGER = 2;

  static int salary = 30000;

  static int commission = 10000;

  static int bonus = 40000;

  int type;

  Employee(final int type)
  {
    this.type = type;
  }

  int payAmount()
  {
    switch (type)
    {
      case 0:
        return salary;
      case 1:
        return salary + commission;
      case 2:
        return salary + bonus;
      default: // should never happen
        return 0;
    }
  }

  @Override
  public String toString()
  {
    switch (type)
    {
      case 0:
        return "Employee[type=ENGINEER]";
      case 1:
        return "Employee[type=SALESMAN]";
      case 2:
        return "Employee[type=MANAGER]";
      default:
        return ""; // Should never happen
    }
  }

}