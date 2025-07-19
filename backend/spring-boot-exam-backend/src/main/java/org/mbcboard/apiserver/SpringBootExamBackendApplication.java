package org.mbcboard.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootExamBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExamBackendApplication.class, args);
	}

}
