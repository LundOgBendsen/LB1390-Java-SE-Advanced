package dk.lundogbendsen.javase8advanced.swing.ex08.personlist;

/**
 * Se beskrivelse i klassen PersonRegister.
 */

public abstract class View implements ModelListener
{
  private Model model;

  protected View()
  {
    this.model = Model.getModel();
    this.model.addListener(this);
  }

  protected Model getModel()
  {
    return this.model;
  }
}