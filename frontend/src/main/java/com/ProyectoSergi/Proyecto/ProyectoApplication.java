package com.ProyectoSergi.Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.BackendSergi.domain","com.ProyectoSergi.Proyecto"})
@EnableJpaRepositories(basePackages = "com.BackendSergi.domain.repository")
@EntityScan(basePackages = "com.BackendSergi.domain.entity")
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
