package dk.lundogbendsen.javase8advanced.polymorphism.lab02.polymorphism.and.types;

public class E extends D implements B
{

  @Override
  public void a()
  {
    System.out.println("a( ) i E");
  }

  @Override
  public void c()
  {
    System.out.println("c( ) i E");
  }
}
