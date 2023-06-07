package vj.com.demo.clg3.clgdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import vj.com.demo.clg3.clgdemo.entity.Department;
import vj.com.demo.clg3.clgdemo.repository.DepartmentIRepository;

@SpringBootApplication
public class ClgdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClgdemoApplication.class, args);
	}
	//@Profile("demo")
	@Bean
	CommandLineRunner initDB(DepartmentIRepository repository){
		return args -> {
						repository.save(new Department( 1L,"IT","IT-2022"));
			repository.save(new Department( 2L,"CSE","CSE-2022"));
		};
	}
}
