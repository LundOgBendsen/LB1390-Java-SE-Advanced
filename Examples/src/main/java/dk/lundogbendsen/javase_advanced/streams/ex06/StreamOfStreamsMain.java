package dk.lundogbendsen.javase_advanced.streams.ex06;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

public class StreamOfStreamsMain
{
  public static void main(final String[] args) throws IOException
  {
    String filename = "." + File.separator + "src" + File.separator + StreamOfStreamsMain.class.getPackage().getName().replace('.', File.separatorChar) + File.separator + "text.txt";

    Stream<Stream<String>> stream = Files.lines(new File(filename).toPath(), StandardCharsets.UTF_8).map(line -> Stream.of(line.split("\\s+")));

    stream.forEach((s) ->
    {
      System.out.println("-----");
      s.forEach(System.out::println);
    });
  }
}
