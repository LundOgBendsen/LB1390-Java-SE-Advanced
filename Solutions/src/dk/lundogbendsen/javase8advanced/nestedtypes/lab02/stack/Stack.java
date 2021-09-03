package dk.lundogbendsen.javase8advanced.nestedtypes.lab02.stack;

public class Stack
{

  private Link topOfStack;

  public void push(final Object o)
  {
    Link newLink = new Link(o, this.topOfStack);
    this.topOfStack = newLink;
  }

  public Object pop()
  {
    if (topOfStack != null)
    {
      Link link = this.topOfStack;
      this.topOfStack = this.topOfStack.underMe;
      return link.value;
    }
    else
    {
      return null;
    }
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("TOP<");
    Link current = this.topOfStack;
    while (current != null)
    {
      sb.append(current + "<");
      current = current.underMe;
    }
    sb.append("BOTTOM");
    return sb.toString();
  }

  private class Link
  {
    public Link underMe;
    public Object value;

    public Link(final Object value, final Link underMe)
    {
      this.value = value;
      this.underMe = underMe;
    }

    @Override
    public String toString()
    {
      return "[" + value + "]";
    }
  }
}
