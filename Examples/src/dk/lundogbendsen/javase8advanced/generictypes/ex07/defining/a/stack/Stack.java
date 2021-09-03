package dk.lundogbendsen.javase8advanced.generictypes.ex07.defining.a.stack;

public interface Stack<E>
{

  // Push-metoden vil *kun* tage i mod parametre af den type, som Stack'en
  // fik som typeparameter
  public abstract void push(E element);

  // Pop-metoden returnerer objekter af den type, som Stack'en fik som 
  // typeparameter.
  public abstract E pop();

}