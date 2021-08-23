package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.javabrains.dao.UserRepository;

@SpringBootApplication
@EnableJpaRepositories( basePackageClasses = UserRepository.class )
public class JavaBrainsSpringSecurityJpaApplication {

	public static void main( String [] args ) {
		SpringApplication.run( JavaBrainsSpringSecurityJpaApplication.class, args );
	}

}
