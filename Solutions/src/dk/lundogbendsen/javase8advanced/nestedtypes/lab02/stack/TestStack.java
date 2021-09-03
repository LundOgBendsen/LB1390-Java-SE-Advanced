package dk.lundogbendsen.javase8advanced.nestedtypes.lab02.stack;

public class TestStack
{

  public static void main(final String[] args)
  {
    Object o;

    Stack stack = new Stack();
    System.out.println(stack + "\n");

    o = "One";
    stack.push(o);
    System.out.println("Push'ed " + o);
    System.out.println(stack + "\n");

    o = "Two";
    stack.push(o);
    System.out.println("Push'ed " + o);
    System.out.println(stack + "\n");

    o = "Three";
    stack.push(o);
    System.out.println("Push'ed " + o);
    System.out.println(stack + "\n");

    o = "Four";
    stack.push(o);
    System.out.println("Push'ed " + o);
    System.out.println(stack + "\n");

    o = stack.pop();
    System.out.println("Pop'ed " + o);
    System.out.println(stack + "\n");

    o = stack.pop();
    System.out.println("Pop'ed " + o);
    System.out.println(stack + "\n");

    o = stack.pop();
    System.out.println("Pop'ed " + o);
    System.out.println(stack + "\n");

    o = stack.pop();
    System.out.println("Pop'ed " + o);
    System.out.println(stack + "\n");

    o = stack.pop();
    System.out.println("Pop'ed " + o);
    System.out.println(stack + "\n");
  }
}
