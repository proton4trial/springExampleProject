package com.mayank.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class EmployeeApplication extends SpringBootServletInitializer
{// implements CommandLineRunner {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(EmployeeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	/* 
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public void run(String... args) throws Exception{
		Employee emp1 = new Employee("Rajesh", 2000);
		Employee emp2 = new Employee("Rakesh", 4000);
		Employee emp3 = new Employee("Ramesh", 8000);
		Employee emp4 = new Employee("Ratesh", 16000);
		
		empRepository.save(emp1);
		empRepository.save(emp2);
		empRepository.save(emp3);
		empRepository.save(emp4);
	}
	*/
}
