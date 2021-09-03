package dk.lundogbendsen.javase8advanced.generictypes.ex02.defining.generic.types;

public class Trio<F, S, T> extends Pair<F, S>
{

  private T t;

  public Trio(F f, S s, T t)
  {
    super(f, s);
    this.t = t;
  }

  public T getT()
  {
    return t;
  }

  public void setT(T t)
  {
    this.t = t;
  }

}
