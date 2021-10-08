package dk.lundogbendsen.javase_advanced.io.ex07.three.ways.to.save;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

	Person(String name, int bornIn, double height) {
		this.name = name;
		this.bornIn = bornIn;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person[name=" + name + ", bornIn=" + bornIn + ", height=" + height + "]";
	}

	public void saveAsSerialized(String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(this);
			oos.flush();
		}
	}

	public static Person loadFromSerialized(String fileName) throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			Object o = ois.readObject();
			Person p = (Person) o;
			return p;
		}
	}

	public void saveAsJavaData(String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName); DataOutputStream dos = new DataOutputStream(fos);) {
			dos.writeUTF(this.name);
			dos.writeInt(this.bornIn);
			dos.writeDouble(this.height);
			dos.flush();
		}
	}

	public static Person loadFromJavaData(String fileName) throws IOException {
		try (FileInputStream fis = new FileInputStream(fileName); DataInputStream dis = new DataInputStream(fis);) {
			String name = dis.readUTF();
			int bornIn = dis.readInt();
			double height = dis.readDouble();
			Person p = new Person(name, bornIn, height);
			return p;
		}
	}

	public void saveAsText(String fileName) throws IOException {
		try (FileWriter fw = new FileWriter(fileName); PrintWriter pw = new PrintWriter(fw);) {
			pw.println(this.name);
			pw.println(this.bornIn);
			pw.println(this.height);
			pw.flush();
		}
	}

	public static Person loadFromText(String fileName) throws IOException {
		try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr);) {
			String name = br.readLine();
			String bornInAsString = br.readLine();
			int bornIn = Integer.parseInt(bornInAsString);
			String heightAsString = br.readLine();
			double height = Double.parseDouble(heightAsString);
			Person p = new Person(name, bornIn, height);
			return p;
		}
	}

	public void saveAsXML(String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				PrintWriter pw = new PrintWriter(osw);) {
			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println("<person>");
			pw.println("  <name>");
			pw.println("    " + this.name);
			pw.println("  </name>");
			pw.println("  <bornIn>");
			pw.println("    " + this.bornIn);
			pw.println("  </bornIn>");
			pw.println("  <height>");
			pw.println("    " + this.height);
			pw.println("  </height>");
			pw.println("</person>");

			pw.flush();
		}
	}
}