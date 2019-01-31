package br.castgroup.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.castgroup.teste.controller"})
@ComponentScan(basePackages = {"br.castgroup.teste"})
public class TesteApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}
        
        @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TesteApplication.class);
	}

}

