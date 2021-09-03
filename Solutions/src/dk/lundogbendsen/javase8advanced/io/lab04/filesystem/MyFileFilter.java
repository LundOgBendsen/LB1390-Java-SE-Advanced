package dk.lundogbendsen.javase8advanced.io.lab04.filesystem;

import java.io.File;
import java.io.FileFilter;

class MyFileFilter implements FileFilter
{

  private String type;
  private boolean includeDirs = false;

  public MyFileFilter(final String type)
  {
    this.type = type;
  }

  public MyFileFilter()
  {
    type = null;
  }

  public String getType()
  {
    if (type != null)
      return type;
    else
      return "[any]";
  }

  @Override
  public boolean accept(final File pathname)
  {
    if (null != type)
      if (!includeDirs)
        return (pathname.getName().endsWith(type));
      else
        return (pathname.getName().endsWith(type) || pathname.isDirectory());
    else
      if (!includeDirs)
        return (pathname.isFile());
      else
        return true;
  }

  public void includeDirectories(final boolean tf)
  {
    includeDirs = tf;
  }
}
