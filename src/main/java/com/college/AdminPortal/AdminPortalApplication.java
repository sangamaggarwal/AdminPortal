package com.college.AdminPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.college.AdminPortal")
@Import({BeanConfig.class, WebConfig.class})
//@EnableWebMvc
@EnableAutoConfiguration
public class AdminPortalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdminPortalApplication.class);
	}
}
