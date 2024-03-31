package dk.lundogbendsen.javase_advanced.streams.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;

public abstract class TimingUtil
{
  public static Duration time(final String title, final Consumer<String> runner)
  {
    Instant start = Instant.now();
  
    runner.accept(title);
  
    Instant end = Instant.now();
    return Duration.between(start, end);
  }
}
