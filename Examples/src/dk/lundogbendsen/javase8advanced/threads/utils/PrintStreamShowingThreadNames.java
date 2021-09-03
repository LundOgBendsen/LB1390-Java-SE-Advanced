package dk.lundogbendsen.javase8advanced.threads.utils;

import java.io.PrintStream;

public class PrintStreamShowingThreadNames extends PrintStream
{

  PrintStreamShowingThreadNames(final PrintStream printStream, final boolean autoFlush)
  {
    super(printStream, autoFlush);
  }

  PrintStreamShowingThreadNames(final PrintStream printStream)
  {
    super(printStream);
  }

  @Override
  public void print(final String s)
  {
    String threadName = Thread.currentThread().getName();
    ((PrintStream) out).print("[" + threadName + "] " + s);
  }

  @Override
  public void println(final String s)
  {
    String threadName = Thread.currentThread().getName();
    ((PrintStream) out).println("[" + threadName + "] " + s);
  }

  @Override
  public void print(final boolean value)
  {
    print("" + value);
  }

  @Override
  public void print(final char value)
  {
    print("" + value);
  }

  @Override
  public void print(final char[] value)
  {
    print(new String(value));
  }

  @Override
  public void print(final double value)
  {
    print("" + value);
  }

  @Override
  public void print(final float value)
  {
    print("" + value);
  }

  @Override
  public void print(final int value)
  {
    print("" + value);
  }

  @Override
  public void print(final long value)
  {
    print("" + value);
  }

  @Override
  public void print(final Object value)
  {
    print(value.toString());
  }

  @Override
  public void println()
  {
    println("");
  }

  @Override
  public void println(final boolean value)
  {
    println("" + value);
  }

  @Override
  public void println(final char value)
  {
    println("" + value);
  }

  @Override
  public void println(final char[] value)
  {
    println(new String(value));
  }

  @Override
  public void println(final double value)
  {
    println("" + value);
  }

  @Override
  public void println(final float value)
  {
    println("" + value);
  }

  @Override
  public void println(final int value)
  {
    println("" + value);
  }

  @Override
  public void println(final long value)
  {
    println("" + value);
  }

  @Override
  public void println(final Object value)
  {
    println(value.toString());
  }

}