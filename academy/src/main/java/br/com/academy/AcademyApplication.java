package br.com.academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EntityScan(basePackages = "br.com.academy.model")
@ComponentScan(basePackages = { "br.*" })
@EnableJpaRepositories(basePackages = "br.com.academy.dao")
@EnableTransactionManagement
@SpringBootApplication
//@EnableWebMvc
public class AcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademyApplication.class, args);
	}

}
