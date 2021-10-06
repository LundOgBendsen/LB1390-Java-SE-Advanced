package dk.lundogbendsen.javase8advanced.io.lab01.savingpersons;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	private int bornIn;

	private double height;

	public Person(final String name, final int bornIn, final double height) {
		this.name = name;
		this.bornIn = bornIn;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person[name=" + name + ", bornIn=" + bornIn + ", height=" + height + "]";
	}

	public void saveAsSerialized(final String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(this);
			oos.flush();
		}
	}

	public static Person loadFromSerialized(final String fileName) throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			Object o = ois.readObject();
			Person p = (Person) o;
			return p;
		}
	}

	public void saveAsJavaData(final String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName); DataOutputStream dos = new DataOutputStream(fos);) {
			dos.writeUTF(this.name);
			dos.writeInt(this.bornIn);
			dos.writeDouble(this.height);
			dos.flush();
		}
	}

	public static Person loadFromJavaData(final String fileName) throws IOException {
		try (FileInputStream fis = new FileInputStream(fileName); DataInputStream dis = new DataInputStream(fis);) {
			String name = dis.readUTF();
			int bornIn = dis.readInt();
			double height = dis.readDouble();
			Person p = new Person(name, bornIn, height);
			return p;
		}
	}

	public void saveAsText(final String fileName, final String encoding) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				OutputStreamWriter fw = new OutputStreamWriter(fos, encoding);
				PrintWriter pw = new PrintWriter(fw);) {
			pw.println(this.name);
			pw.println(this.bornIn);
			pw.println(this.height);
		}
	}

	public static Person loadFromText(final String fileName, final String encoding) throws IOException {
		try (FileInputStream fis = new FileInputStream(fileName);
				InputStreamReader fr = new InputStreamReader(fis, encoding);
				BufferedReader br = new BufferedReader(fr);) {
			String name = br.readLine();
			String bornInAsString = br.readLine();
			int bornIn = Integer.parseInt(bornInAsString);
			String heightAsString = br.readLine();
			double height = Double.parseDouble(heightAsString);
			Person p = new Person(name, bornIn, height);
			br.close();
			fr.close();
			return p;
		}
	}
}