package com.sample.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.app.model.Employee;

@SpringBootApplication
public class App {

	@Autowired
	@Qualifier("krishna")
	private Employee emp1;

	@Autowired
	@Qualifier("ram")
	private Employee emp2;

	public static void main(String args[]) {
		System.out.println("Main Application running.......");
		SpringApplication.run(App.class, args);

		System.out.println("ApplicationContext initialized");

	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

			System.out.println("Inside command line runner");

			emp1.print();
			emp2.print();

		};
	}

}
