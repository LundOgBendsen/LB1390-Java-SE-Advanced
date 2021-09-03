package dk.lundogbendsen.javase8advanced.reflection.ex06.constructors;

public class Person
{
  private String firstName;

  private String lastName;

  public Person()
  {
  }

  public Person(final String firstName, final String lastName)
  {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(final String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(final String lastName)
  {
    this.lastName = lastName;
  }

  @Override
  public String toString()
  {
    return "Person[firstName=" + firstName + ", lastName=" + lastName + "]";
  }
}
