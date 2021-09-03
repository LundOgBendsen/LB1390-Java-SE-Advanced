package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Model
{
  private static Model model;

  private ArrayList<ModelListener> listeners = new ArrayList<ModelListener>();

  private String currentFileName;

  // Bruges til at få fat i den eneste mulige Model-instans
  public static Model getModel()
  {
    if (model == null)
    {
      model = new Model();
    }
    return model;
  }

  private Model()
  {
    this.currentFileName = "";
  }

  public void clear()
  {
    Person.setAllPersons(new ArrayList<Person>());
    this.currentFileName = "";
    notifyAllListeners();
  }

  // Bruges til at gemme på disk og indhente fra disk
  public void saveAs(final File file)
  {
    String fileName = file.getName();
    try (FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);)
    {
      oos.writeObject(Person.getAllPersons());
      oos.flush();
    }
    catch (Exception e)
    {
      System.err.println("Model.saveAs threw this exception: ");
      e.printStackTrace(System.err);
    }
    this.currentFileName = fileName;
    notifyAllListeners();
  }

  @SuppressWarnings("unchecked")
  public void load(final File file)
  {
    String fileName = file.getName();
    try (FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);)
    {
      List<Person> persons = (List<Person>) ois.readObject();
      Person.setAllPersons(new ArrayList<Person>(persons));
    }
    catch (Exception e)
    {
      System.err.println("Model.load threw this exception: ");
      e.printStackTrace(System.err);
    }
    this.currentFileName = fileName;
    notifyAllListeners();
  }

  public String getCurrentFileName()
  {
    return this.currentFileName;
  }

  // Sørger for views kan lytte på ændringer i modellen
  public void addListener(final ModelListener modelListener)
  {
    listeners.add(modelListener);
  }

  public void removeListener(final ModelListener modelListener)
  {
    listeners.remove(modelListener);
  }

  @SuppressWarnings("unchecked")
  public void notifyAllListeners()
  {
    ArrayList<ModelListener> list = (ArrayList<ModelListener>) listeners.clone();
    Iterator<ModelListener> iterator = list.iterator();
    while (iterator.hasNext())
    {
      ModelListener currentListener = iterator.next();
      currentListener.update();
    }
  }

  // Sørger for views kan aflæse modellen mht. Persons
  public static List<Person> getAllPersons()
  {
    return Person.getAllPersons();
  }

  public static Person getPersonWithId(final int id)
  {
    return Person.getPersonWithId(id);
  }

  public String getFullNameOfPerson(final int personId)
  {
    return getPersonWithId(personId).getFullName();
  }

  public int getBirthYearOfPerson(final int personId)
  {
    return getPersonWithId(personId).getBirthYear();
  }

  public boolean isValidPerson(final String fullName, final int birthYear)
  {
    return Person.isValidPerson(fullName, birthYear);
  }

  // Sørger for controllers kan ændre i modellen mht. Persons
  public Person createPerson(final String fullName, final int birthYear)
  {
    Person p = new Person(fullName, birthYear);
    notifyAllListeners();
    return p;
  }

  public void setFullNameOfPerson(final int personId, final String fullName)
  {
    getPersonWithId(personId).setFullName(fullName);
    notifyAllListeners();
  }
}