package dk.lundogbendsen.javase8advanced.annotations.ex01.example;

import dk.lundogbendsen.javase8advanced.annotations.ex02.persistence.SqlGenerator;

public class Main {

	public static void main(String[] args) {

		String sql = SqlGenerator.generateSqlFor(Person.class);
		System.out.println(sql);

	}
}
