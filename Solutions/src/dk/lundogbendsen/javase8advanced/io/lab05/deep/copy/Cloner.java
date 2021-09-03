package dk.lundogbendsen.javase8advanced.io.lab05.deep.copy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cloner
{
  @SuppressWarnings("unchecked")
  public static <T> T deepCopy(final T o) throws IOException, ClassNotFoundException
  {
    if (!(o instanceof Serializable)) { throw new IOException("argument is not Serializable!"); }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(o);

    byte[] barr = baos.toByteArray();
    ByteArrayInputStream bais = new ByteArrayInputStream(barr);
    ObjectInputStream ois = new ObjectInputStream(bais);
    return (T) ois.readObject();

  }

}
