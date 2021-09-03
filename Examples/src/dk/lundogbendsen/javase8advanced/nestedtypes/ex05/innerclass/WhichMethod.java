package dk.lundogbendsen.javase8advanced.nestedtypes.ex05.innerclass;

public class WhichMethod
{

  public static void main(String[] args)
  {
    OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner = outer.new InnerClass();
    inner.callPrint();
  }
}

class BaseClassForInner
{
  public void print()
  {
    System.out.println("BaseClassForInner");
  }
}

class BaseClassForOuter
{
  public void print()
  {
    System.out.println("BaseClassForOuter");
  }
}

class OuterClass extends BaseClassForOuter
{

  @Override
  public void print()
  {
    System.out.println("OuterClass");
  }

  public class InnerClass extends BaseClassForInner
  {

    public void callPrint()
    {
      // Hvilken print kaldes her?
      print();

      // Brug hellere en af disse to:
      super.print();
      OuterClass.this.print();

      // Også check lige det her :-)
      OuterClass.super.print();
    }

  }
}