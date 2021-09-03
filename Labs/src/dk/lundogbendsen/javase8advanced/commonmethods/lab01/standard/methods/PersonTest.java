package dk.lundogbendsen.javase8advanced.commonmethods.lab01.standard.methods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PersonTest
{
  static Person p1 = new Person(true, "Hans Jensen", 82.5, 1972);

  // p2 is equal to p1
  static Person p2 = new Person(true, "Hans Jensen", 82.5, 1972);

  // p1 is male and p3 is female
  static Person p3 = new Person(false, "Hans Jensen", 82.5, 1972);

  // p1.name = Hans Jensen and p4.name = Jens Jensen
  static Person p4 = new Person(true, "Jens Jensen", 82.5, 1972);

  // p1.birthYear = 1972 and p5.birthYear = 1980
  static Person p5 = new Person(true, "Hans Jensen", 82.5, 1980);

  // p1.name = Hans Jensn and p6.name = null
  static Person p6 = new Person(true, null, 82.5, 1972);

  // p1 is of type Person and p7 is a subtype of Person
  static Person p7 = new Person(true, "Hans Jensen", 82.5, 1972)
  {

    @SuppressWarnings("unused")
    private int height = 200;

    @Override
    public boolean equals(final Object other)
    {
      return super.equals(other);
    }
  };

  @Test
  public void testEquals()
  {
    assertEquals("Not the same object", p1, p2);

    assertEquals("Not equal objects", p1, p2);

    assertNotEquals("Equal sexes", p1, p3);

    // p1.name = Hans Jensen and p4.name = Jens Jensen
    assertNotEquals("Equal names", p1, p4);

    // p1.birthYear = 1972 and p5.birthYear = 1980
    assertNotEquals("Equal ages", p1, p5);

    // p1.name = Hans Jensen and p6.name = null
    assertNotEquals("Ignored null", p1, p6);

    assertNotEquals("Ignored types", p1, p7);

    assertNotEquals("Ignored null", p1, null);
  }

  @Test
  public void testHashCode()
  {
    assertEquals("Different hashcodes", p1.hashCode(), p1.hashCode());

    assertEquals("Not equal object", p1.hashCode(), p2.hashCode());

    assertNotEquals("Equal sexes", p1.hashCode(), p3.hashCode());

    assertNotEquals("Equal names", p1.hashCode(), p4.hashCode());

    assertNotEquals("Equal ages", p1.hashCode(), p5.hashCode());

    assertNotEquals("Ignored null name", p1.hashCode(), p6.hashCode());
  }

  @Test
  public void testClone() throws Exception
  {
    Person original = new Person(true, "Hans Jensen", 82.5, 1972);
    Person clone = original.clone();

    assertFalse("Not same object", original == clone);

    assertTrue("Not queals", original.equals(clone));

    Person notCloneable = new Person(true, "Hans Jensen", 82.5, 1972)
    {
      @Override
      public Person clone() throws CloneNotSupportedException
      {
        throw new CloneNotSupportedException();
      }
    };
    try
    {
      notCloneable.clone();
      fail("Clone not disallowed");
    }
    catch (CloneNotSupportedException e)
    {
    }
  }

  @Test
  public void testCompareTo()
  {
    assertEquals("Not equal to myself", 0, p1.compareTo(p1));

    assertEquals("Not equal objects", 0, p1.compareTo(p2));

    assertTrue("Male not < female", 0 > p1.compareTo(p3));

    assertTrue("Hans Jensen not < Jens Jensen", 0 > p1.compareTo(p3));

    assertTrue("ung not < gammel", 0 < p1.compareTo(p5));

    assertTrue("name == null not < name != null", 0 < p1.compareTo(p6));

    try
    {
      p1.compareTo(p7);
      fail("Ignored subtype");
    }
    catch (ClassCastException e)
    {
    }
  }
}
