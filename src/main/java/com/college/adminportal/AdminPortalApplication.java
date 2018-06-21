package com.college.adminportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.college.adminportal")
@EntityScan("com.college.adminportal.entity")
@EnableJpaRepositories("com.college.adminportal.repository")
//@Import({BeanConfig.class, WebConfig.class})
@EnableAutoConfiguration
@SpringBootApplication
public class AdminPortalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdminPortalApplication.class);
	}
}
