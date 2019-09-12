package com.testyantra.cgbanspringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactory() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("student-db-unit");
		return bean;
	}
}
