package dk.lundogbendsen.javase_advanced.lambda.lab02;

public class CompareUtil
{
  private int res;

  private CompareUtil()
  {
    this.res = 0;
  }

  public static CompareUtil commence()
  {
    CompareUtil cu = new CompareUtil();
    return cu;
  }

  public <F extends Comparable<F>> CompareUtil compare(final F obj1, final F obj2)
  {
    if (res == 0)
    {
      int c = obj1.compareTo(obj2);
      res = c;
    }
    return this;
  }

  public int conclude()
  {
    return res;
  }
}
