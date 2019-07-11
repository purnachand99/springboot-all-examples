package com.sample.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.sample.app.model.Employee;
import com.sample.app.repository.EmployeeRepository;

@SpringBootApplication
public class App {

	public static void main(String args[]) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository employeeRepository) {
		return (args) -> {
			Employee emp1 = Employee.builder().firstName("Ram").lastName("Gurram").age(32).salary(100000.23).build();
			Employee emp2 = Employee.builder().firstName("Joel").lastName("Chelli").age(43).salary(60000).build();
			Employee emp3 = Employee.builder().firstName("Gopi").lastName("Battu").age(32).salary(1000000).build();
			Employee emp4 = Employee.builder().firstName("Bomma").lastName("Srikanth").age(39).salary(60000).build();
			Employee emp5 = Employee.builder().firstName("Surendra").lastName("Sami").age(32).salary(100000.23).build();
			Employee emp6 = Employee.builder().firstName("Bhadri").lastName("Venakata RamaRao").age(32).salary(100000.23).build();
			Employee emp7 = Employee.builder().firstName("Sushmithaa").lastName("Kulakarni").age(39).salary(100000.23).build();

			employeeRepository.save(emp1);
			employeeRepository.save(emp2);
			employeeRepository.save(emp3);
			employeeRepository.save(emp4);
			employeeRepository.save(emp5);
			employeeRepository.save(emp6);
			employeeRepository.save(emp7);
			
			Sort sort = new Sort(Direction.ASC, Arrays.asList("age","firstName"));
			int pageIndex = 0;
			int size = 2;
			
			PageRequest pageRequest = PageRequest.of(pageIndex, size, sort);
			Page<Employee> empsPage = employeeRepository.findByAge(32, pageRequest);
			
			do {
				System.out.println("\n*********************************");
				List<Employee> emps = empsPage.getContent();
				
				for(Employee emp: emps) {
					System.out.println(emp);
				}
				
				if(!empsPage.hasNext()) {
					break;
				}
				
				Pageable pageable = empsPage.nextPageable();
				empsPage = employeeRepository.findByAge(32, pageable);
				System.out.println("*********************************");
				
			}while(true);
			

		};
	}

}

