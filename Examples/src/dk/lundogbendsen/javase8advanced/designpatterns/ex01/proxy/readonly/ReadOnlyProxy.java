package dk.lundogbendsen.javase8advanced.designpatterns.ex01.proxy.readonly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyProxy {
	public static void main(String[] args) {

		// Read and write allowed
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hej");

		// Only reads are allowed
		List<String> readOnlyList = Collections.unmodifiableList(list);

		// OK to do this
		System.out.println(readOnlyList.get(0));

		// Not OK to do this (UnsupportedOperationException)
		readOnlyList.add("Goddag");
	}
}
