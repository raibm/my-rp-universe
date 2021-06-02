package com.wow.myrpuniverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MyrpuniverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyrpuniverseApplication.class, args);
	}

}
